package com.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
 
import org.json.JSONObject;

public class PostData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "Hi";
		try {
	
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("payload", string);
			
			try {
				URL url = new URL("http://172.20.10.2:3000");
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(jsonObject.toString());
				out.close();

				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				String output = "";
				while ((output = in.readLine()) != null) {
					System.out.println(output);
				}
				System.out.println("\nREST Service Invoked Successfully..");
				in.close();
			} catch (Exception e) {
				System.out.println("\nError while calling REST Service");
				System.out.println(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
