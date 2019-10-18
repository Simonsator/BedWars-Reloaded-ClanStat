package de.simonsator.bedwarsstatsrel;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.clan.api.Clan;
import de.simonsator.partyandfriends.clan.api.ClanStat;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.util.ArrayList;
import java.util.List;

public class BWStat implements ClanStat {
	private BWConnection connection;
	private ConfigurationCreator messagesConfig;

	public BWStat(BWConnection connection, ConfigurationCreator messagesConfig) {
		this.connection = connection;
		this.messagesConfig = messagesConfig;
	}

	public void stats(OnlinePAFPlayer pSender, Clan pClan) {
		List<PAFPlayer> players = pClan.getAllPlayers();
		List<PlayerData> playerData = new ArrayList();
		for (PAFPlayer player : players) {
			PlayerData data = this.connection.getPlayerData(player.getUniqueId());
			if (data != null)
				playerData.add(data);
		}
		int wins = 0;
		int deaths = 0;
		int loses = 0;
		int destroyedBeds = 0;
		int games = 0;
		int kills = 0;
		double kds = 0.0D;
		for (PlayerData data : playerData) {
			wins += data.wins;
			deaths += data.deaths;
			loses += data.loses;
			destroyedBeds += data.destroyedBeds;
			games += data.games;
			kds += data.kd;
			kills += data.kills;
		}
		kds /= playerData.size();
		if (kds != kds)
			kds = 0.0D;
		pSender.sendMessage(this.messagesConfig.getString("ClanStats.Wins").replace("[WON]", wins + ""));
		pSender.sendMessage(this.messagesConfig.getString("ClanStats.Lost").replace("[LOST]", loses + ""));
		pSender.sendMessage(this.messagesConfig.getString("ClanStats.Played").replace("[GAMES]", games + ""));
		pSender.sendMessage(this.messagesConfig.getString("ClanStats.DestroyedBeds").replace("[BEDS]", destroyedBeds + ""));
		pSender.sendMessage(this.messagesConfig.getString("ClanStats.KD").replace("[KD]", kds + ""));
		pSender.sendMessage(this.messagesConfig.getString("ClanStats.Kills").replace("[KILLS]", kills + ""));
		pSender.sendMessage(this.messagesConfig.getString("ClanStats.Deaths").replace("[DEATHS]", deaths + ""));
	}

	public String getName() {
		return "BedWars";
	}
}
