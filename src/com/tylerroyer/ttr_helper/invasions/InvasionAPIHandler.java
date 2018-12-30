package com.tylerroyer.ttr_helper.invasions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.tylerroyer.ttr_helper.globals.GlobalStrings;

public class InvasionAPIHandler {
	private static final String API_URL = "https://www.toontownrewritten.com/api/invasions";
	private String rawJSON;
	private InvasionsInfo invasionsInfo;

	public InvasionAPIHandler() {
		requaryAPI();
	}

	public InvasionsInfo getInvasionInfo() {
		return invasionsInfo;
	}

	public void requaryAPI() {
		HttpURLConnection connection = null;

		// HTML request code from https://www.baeldung.com/java-http-request
		try {
			URL url = new URL(API_URL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent",
					"User name: " + System.getProperty("user.name") + "; OS Name: " + System.getProperty("os.name")
							+ "; OS Version: " + System.getProperty("os.version") + "; Agent name: "
							+ GlobalStrings.ProgramName + "; Agent version: " + GlobalStrings.ProgramVersion);
			connection.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			rawJSON = in.readLine();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}
		
		invasionsInfo = new InvasionsInfo(rawJSON);
	}
}
