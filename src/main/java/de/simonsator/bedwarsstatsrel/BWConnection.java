/*    */
package de.simonsator.bedwarsstatsrel;
/*    */ 
/*    */

import de.simonsator.partyandfriends.communication.sql.SQLCommunication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/*    */
/*    */
/*    */
/*    */
/*    */

/*    */
/*    */ 
/*    */ 
/*    */ public class BWConnection
/*    */ extends SQLCommunication
/*    */ {
	/*    */
	protected BWConnection(String pDatabase, String pURL, String pUserName, String pPassword)
/*    */ {
/* 17 */
		super(pDatabase, pURL, pUserName, pPassword);
/*    */
	}

	/*    */
/*    */
	public PlayerData getPlayerData(UUID pUUID) {
/* 21 */
		Connection con = getConnection();
/* 22 */
		Statement stmt = null;
/* 23 */
		ResultSet rs = null;
/*    */
		try {
/* 25 */
			rs = (stmt = con.createStatement()).executeQuery("select kills, wins, loses, games, kd, destroyedBeds, deaths from `" + this.DATABASE + "`." + "bw_stats_players WHERE uuid='" + pUUID.toString() + "' LIMIT 1");
/*    */       
/* 27 */
			if (rs.next()) {
/* 28 */
				return new PlayerData(rs.getInt("wins"), rs.getInt("loses"), rs.getInt("games"), rs.getInt("destroyedBeds"), rs.getDouble("kd"), rs.getInt("deaths"), rs.getInt("kills"));
/*    */
			}
/*    */
		}
/*    */ catch (SQLException e) {
/* 32 */
			e.printStackTrace();
/* 33 */
			return null;
/*    */
		} finally {
/* 35 */
			close(rs, stmt);
/*    */
		}
/* 37 */
		return null;
/*    */
	}
/*    */
}