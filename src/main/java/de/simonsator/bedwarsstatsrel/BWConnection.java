package de.simonsator.bedwarsstatsrel;


import de.simonsator.partyandfriends.communication.sql.SQLCommunication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;


public class BWConnection extends SQLCommunication {

	protected BWConnection(String pDatabase, String pURL, String pUserName, String pPassword, boolean pSSL) {
		super(pDatabase, pURL, pUserName, pPassword, pSSL);
	}


	public PlayerData getPlayerData(UUID pUUID) {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			rs = (stmt = con.createStatement()).executeQuery("select kills, wins, loses, games, kd, destroyedBeds, deaths from `" + this.DATABASE + "`." + "bw_stats_players WHERE uuid='" + pUUID.toString() + "' LIMIT 1");
			if (rs.next()) {
				return new PlayerData(rs.getInt("wins"), rs.getInt("loses"), rs.getInt("games"), rs.getInt("destroyedBeds"), rs.getDouble("kd"), rs.getInt("deaths"), rs.getInt("kills"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs, stmt);
		}
		return null;
	}

}