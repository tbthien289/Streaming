package com.client;

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

import org.json.JSONArray;
import org.json.JSONObject;

import Ice.InitializationData;
import streaming.*;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class Client {
	public static String IP = "172.20.10.2";
	public static Scanner s;

	public static void addTrack(PlayerPrx player) {
		s = new Scanner(System.in);
		System.out.print("Name of track : ");
		String name = s.nextLine();
		System.out.print("Singer : ");
		String singer = s.nextLine();
		System.out.print("Author : ");
		String author = s.nextLine();
		System.out.print("Album  : ");
		String album = s.nextLine();
		System.out.print("Path   : ");
		String path = s.nextLine();

		player.addTrack(name, album, author, singer, path);
	}

	public static void searchTrack(PlayerPrx player) {
		s = new Scanner(System.in);
		System.out.print("Name of track : ");
		String name = s.nextLine();

		String track = player.searchTrack(name);
		if (!track.equals("")) {
			System.out.println("Found Track: ");
			System.out.println(track);
		} else {
			System.out.println("Can't find track");
		}
	}

	public static void deleteTrack(PlayerPrx player) {
		s = new Scanner(System.in);
		System.out.print("Name of track : ");
		String name = s.nextLine();
		
		if(player.deleteTrack(name) == 1) {
			System.out.println("Delete track success!");
		} else {
			System.out.println("Can't delete track!");
		}
	}

	public static void getAllTrack(PlayerPrx player) {
		String result = player.getListTrack();
		System.out.println(result);
	}

	public static void playTrack(PlayerPrx player) throws IOException, InterruptedException {
		s = new Scanner(System.in);
		System.out.print("Name of track : ");
		String name = s.nextLine();

		String path = player.playTrack(name);

		Runtime runtime = Runtime.getRuntime();
		Process p = null;
		p = runtime.exec(
				new String[] { "C:\\Program Files (x86)\\K-Lite Codec Pack\\Media Player Classic\\mpc-hc.exe", path });
		p.waitFor();
	}
	
	public static void playStream() {
		final EmbeddedMediaListPlayerComponent component = new EmbeddedMediaListPlayerComponent();
		
		JFrame f = new JFrame();
		f.setContentPane(component);
		f.setBounds(new Rectangle(200, 200, 200, 200));
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				component.release();
			}
			 
		});
		f.setVisible(true);
		
		component.mediaPlayer().media().play("http://" + IP + ":5555");
	}

	public static void showMenu() {
		System.out.println("###################### [ Player MP3 ] #####################\n");
		System.out.println("1/ Add new track");
		System.out.println("2/ Search track");
		System.out.println("3/ Delete track");
		System.out.println("4/ Play track");
		System.out.println("5/ Music information");
		System.out.println("6/ Live stream");
		System.out.println("7/ Exit");
		System.out.println("\nEnter your choice : ");
	}
	
	public static void fetchDataFromRest(PlayerPrx player) {
		try {

			URL url = new URL("http://localhost:3000");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while ((output = br.readLine()) != null) {
				JSONArray arrayData = new JSONArray(output);
				for (int i = 0; i < arrayData.length(); i++) {
					JSONObject objectData = (JSONObject) arrayData.get(i);
					
					// Create data
					player.addTrack(objectData.getString("name"),
									objectData.getString("album"),
									objectData.getString("author"),
									objectData.getString("author"),
									objectData.getString("path"));
					
				}
			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void init(PlayerPrx player) {
		fetchDataFromRest(player);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ice.Communicator ic = null;
		try {
			// Initialize Ice run time
			ic = Ice.Util.initialize(args);

			// Access to remote adapter Streaming agent
			Ice.ObjectPrx base = ic.stringToProxy("PlayerMp3:default -h " + IP + " -p 10000");

			// Convert proxy
			PlayerPrx playerMp3 = PlayerPrxHelper.checkedCast(base);

			// Check if conversion proxy is valid
			if (playerMp3 == null) {
				throw new Error("Proxy is invalid");
			}

			// init data
			init(playerMp3);

			// Call the method and pass the value
			int tmp = 0;
			do {
				if (s == null)
					s = new Scanner(System.in);
				showMenu();
				tmp = s.nextInt();
				switch (tmp) {
				case 1:
					addTrack(playerMp3);
					break;
				case 2:
					searchTrack(playerMp3);
					break;
				case 3:
					deleteTrack(playerMp3);
					break;
				case 4:
					playTrack(playerMp3);
					break;
				case 5:
					getAllTrack(playerMp3);
					break;
				case 6:
					playStream();
					break;
				case 7:
					System.exit(0);
					break;
				}
				// s.next();
			} while (true);

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			if (ic != null) {
				ic.destroy();
			}
		}
		System.exit(1);
	}

}
