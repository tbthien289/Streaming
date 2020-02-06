package com.server;

import java.io.*;
import java.util.*;
import java.net.*;
import org.json.*;

public class FetchData {

	public static void main(String[] args) {
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
					System.out.println(objectData.toString());
				}
				//System.out.println(output);
			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
