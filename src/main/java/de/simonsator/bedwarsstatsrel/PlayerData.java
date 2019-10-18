package de.simonsator.bedwarsstatsrel;


public class PlayerData {
	public final int wins;

	public final int loses;
	public final int games;
	public final int destroyedBeds;
	public final double kd;
	public final int deaths;
	public final int kills;

	public PlayerData(int wins, int loses, int games, int destroyedBeds, double kd, int deaths, int kills) {
		this.wins = wins;
		this.loses = loses;
		this.games = games;
		this.destroyedBeds = destroyedBeds;
		this.kd = kd;
		this.deaths = deaths;
		this.kills = kills;
	}
}