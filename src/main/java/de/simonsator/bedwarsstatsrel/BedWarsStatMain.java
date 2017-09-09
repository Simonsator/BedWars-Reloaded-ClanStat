/*    */ package de.simonsator.bedwarsstatsrel;
/*    */ 
/*    */ import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
/*    */ import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
/*    */ import de.simonsator.partyandfriends.clan.api.Clan;
/*    */ import de.simonsator.partyandfriends.clan.api.ClanStat;
/*    */ import de.simonsator.partyandfriends.clan.commands.ClanCommands;
/*    */ import de.simonsator.partyandfriends.clan.commands.subcommands.Stats;
/*    */ import de.simonsator.partyandfriends.utilities.Language;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.md_5.bungee.api.plugin.Plugin;
/*    */ import net.md_5.bungee.config.Configuration;
/*    */ 
/*    */ public class BedWarsStatMain
/*    */   extends Plugin
/*    */   implements ClanStat
/*    */ {
/*    */   private Configuration config;
/*    */   private BWConnection connection;
/*    */   private Configuration messagesConfig;
/*    */   
/*    */   public void onEnable()
/*    */   {
/*    */     try
/*    */     {
/* 29 */       this.config = new BWSConfig(new File(getDataFolder(), "config.yml")).getCreatedConfiguration();
/* 30 */       this.messagesConfig = new BWSMessages(Language.OWN, new File(getDataFolder(), "messages.yml")).getCreatedConfiguration();
/*    */     } catch (IOException e) {
/* 32 */       e.printStackTrace();
/*    */     }
/* 34 */     this.connection = new BWConnection(this.config.getString("database.db"), "jdbc:mysql://" + this.config.getString("database.host") + ":" + this.config.getInt("database.port"), this.config.getString("database.user"), this.config.getString("database.password"));
/* 35 */     ((Stats)ClanCommands.getInstance().getSubCommand(Stats.class)).registerClanStats(this, this);
/*    */   }
/*    */   
/*    */   public void stats(OnlinePAFPlayer pSender, Clan pClan) {
/* 39 */     List<PAFPlayer> players = pClan.getAllPlayers();
/* 40 */     List<PlayerData> playerData = new ArrayList();
/* 41 */     for (PAFPlayer player : players) {
/* 42 */       PlayerData data = this.connection.getPlayerData(player.getUniqueId());
/* 43 */       if (data != null)
/* 44 */         playerData.add(data);
/*    */     }
/* 46 */     int wins = 0;
/* 47 */     int deaths = 0;
/* 48 */     int loses = 0;
/* 49 */     int destroyedBeds = 0;
/* 50 */     int games = 0;
/* 51 */     int kills = 0;
/* 52 */     double kds = 0.0D;
/* 53 */     for (PlayerData data : playerData) {
/* 54 */       wins += data.wins;
/* 55 */       deaths += data.deaths;
/* 56 */       loses += data.loses;
/* 57 */       destroyedBeds += data.destroyedBeds;
/* 58 */       games += data.games;
/* 59 */       kds += data.kd;
/* 60 */       kills += data.kills;
/*    */     }
/* 62 */     kds /= playerData.size();
/* 63 */     if (kds != kds)
/* 64 */       kds = 0.0D;
/* 65 */     pSender.sendMessage(this.messagesConfig.getString("ClanStats.Wins").replace("[WON]", wins + ""));
/* 66 */     pSender.sendMessage(this.messagesConfig.getString("ClanStats.Lost").replace("[LOST]", loses + ""));
/* 67 */     pSender.sendMessage(this.messagesConfig.getString("ClanStats.Played").replace("[GAMES]", games + ""));
/* 68 */     pSender.sendMessage(this.messagesConfig.getString("ClanStats.DestroyedBeds").replace("[BEDS]", destroyedBeds + ""));
/* 69 */     pSender.sendMessage(this.messagesConfig.getString("ClanStats.KD").replace("[KD]", kds + ""));
/* 70 */     pSender.sendMessage(this.messagesConfig.getString("ClanStats.Kills").replace("[KILLS]", kills + ""));
/* 71 */     pSender.sendMessage(this.messagesConfig.getString("ClanStats.Deaths").replace("[DEATHS]", deaths + ""));
/*    */   }
/*    */   
/*    */   public String getName() {
/* 75 */     return "BedWars";
/*    */   }
/*    */ }


/* Location:              /Users/simonbrungs/Downloads/bedwars-stats-rel-1.0-SNAPSHOT.jar!/de/simonsator/bedwarsstatsrel/BedWarsStatMain.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */