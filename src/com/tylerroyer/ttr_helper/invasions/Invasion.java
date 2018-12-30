package com.tylerroyer.ttr_helper.invasions;

import com.tylerroyer.ttr_helper.cogs.Cog;

public class Invasion {
	private Cog cog;
	private String district;
	private int currentProgress, maxProgress;
	
	public Invasion(Cog cog, String district, int currentProgress, int maxProgress) {
		this.cog = cog;
		this.district = district;
		this.currentProgress = currentProgress;
		this.maxProgress = maxProgress;
	}

	public Cog getCog() {
		return cog;
	}
	
	public String getDistrict() {
		return district;
	}

	public int getCurrentProgress() {
		return currentProgress;
	}

	public int getMaxProgress() {
		return maxProgress;
	}
}
