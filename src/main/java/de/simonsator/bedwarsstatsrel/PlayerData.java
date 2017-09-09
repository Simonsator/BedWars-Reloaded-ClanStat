/*    */ package de.simonsator.bedwarsstatsrel;
/*    */ 
/*    */ 
/*    */ public class PlayerData
/*    */ {
/*    */   public final int wins;
/*    */   
/*    */   public final int loses;
/*    */   public final int games;
/*    */   public final int destroyedBeds;
/*    */   public final double kd;
/*    */   public final int deaths;
/*    */   public final int kills;
/*    */   
/*    */   public PlayerData(int wins, int loses, int games, int destroyedBeds, double kd, int deaths, int kills)
/*    */   {
/* 17 */     this.wins = wins;
/* 18 */     this.loses = loses;
/* 19 */     this.games = games;
/* 20 */     this.destroyedBeds = destroyedBeds;
/* 21 */     this.kd = kd;
/* 22 */     this.deaths = deaths;
/* 23 */     this.kills = kills;
/*    */   }
/*    */ }


/* Location:              /Users/simonbrungs/Downloads/bedwars-stats-rel-1.0-SNAPSHOT.jar!/de/simonsator/bedwarsstatsrel/PlayerData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */