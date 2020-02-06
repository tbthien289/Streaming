package com.server;

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.servent.PlayerI;

import Ice.InitializationData;
import streaming.Track;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class Server {
	
	public static void openStreaming() throws InterruptedException {
		String media = "E:\\UAPV\\S2\\ApplicationArchitectures\\StreamingServer\\App\\Track\\missyou.mp3";

        String options = formatHttpStream("172.20.10.2", 5555);

        System.out.println("Streaming '" + media + "' to '" + options + "'");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        MediaPlayer mediaPlayer = mediaPlayerFactory.mediaPlayers().newMediaPlayer();
        mediaPlayer.media().play(media, options);

        // Don't exit
        //Thread.currentThread().join();
	}

	private static String formatHttpStream(String serverAddress, int serverPort) {
		StringBuilder sb = new StringBuilder(60);
		sb.append(":sout=#duplicate{dst=std{access=http,mux=ts,");
		sb.append("dst=");
		sb.append(serverAddress);
		sb.append(':');
		sb.append(serverPort);
		sb.append("}}");
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int status = 0;
		Ice.Communicator ic = null;

		try {
			ic = Ice.Util.initialize(args);

			System.out.println("Create object adapter, listening on port 10000...");
			Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("PlayerMp3",
					"default -h 172.20.10.2 -p 10000");

			Ice.Object object = new PlayerI();

			adapter.add(object, ic.stringToIdentity("PlayerMp3"));

			// Open streaming server
			openStreaming();
			
			adapter.activate();

			ic.waitForShutdown();
		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (ic != null) {
			try {
				ic.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		System.exit(status);
	}

}
