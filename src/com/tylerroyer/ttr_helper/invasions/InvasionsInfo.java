package com.tylerroyer.ttr_helper.invasions;

import java.util.ArrayList;
import org.json.*;

import com.tylerroyer.ttr_helper.cogs.Cog;

public class InvasionsInfo {
	private ArrayList<Invasion> invasionList = new ArrayList<>();
	private int lastUpdated;
	private boolean error = false;

	public InvasionsInfo(String rawJSON) {
		JSONObject root = null;
		try {
			root = new JSONObject(rawJSON);
		} catch (Exception e) { // Gets thrown if API request timed out.
			System.out.println("WARNING: API request timed out.\n");
			error = true;
			return;
		}
		
		error = false;
		
		lastUpdated = root.getInt("lastUpdated");
		JSONObject invasions = root.getJSONObject("invasions");

		for (int i = 0; i < invasions.length(); i++) {
			String name = invasions.names().getString(i);
			JSONObject invasionInfo = invasions.getJSONObject(name);

			String cogName = fixName(invasionInfo.getString("type"));
			Cog cog = Cog.findCogByName(cogName);

			String progress = (String) invasionInfo.get("progress");
			String invType = (String) invasionInfo.get("progress");

			int currentProgress = Integer.parseInt(progress.substring(0, progress.indexOf("/")));
			int maxProgress = Integer.parseInt(progress.substring(progress.indexOf("/") + 1));

			if (progress.equals("0/1000000"));
				progress.replace("0/1000000", "MEGA Invasion!");

			invasionList.add(new Invasion(cog, name, currentProgress, maxProgress, progress));
		}
	}

	// Work around for the API placing a utf character, 0x0003, into some names.
	// Possibly in names which could be mulitple words? Ex. Blood\u0003sucker and
	// micro\u0003manager
	private String fixName(String name) {
		for (int i = name.length() - 1; i >= 0; i--) {
			if (name.charAt(i) == 0x0003) {
				name = name.substring(0, i) + name.substring(i + 1);
			}
		}
		name = name.replace("Version 2.0 ", "");
		return name;
	}

	public int getLastUpdated() {
		return lastUpdated;
	}
	
	public boolean isError() {
		return error;
	}

	public ArrayList<Invasion> getInvasionList() {
		return invasionList;
	}
}
