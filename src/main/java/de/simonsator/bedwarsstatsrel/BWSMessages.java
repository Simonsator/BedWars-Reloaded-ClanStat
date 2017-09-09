/*    */ package de.simonsator.bedwarsstatsrel;
/*    */ 
/*    */ import de.simonsator.partyandfriends.utilities.Language;
/*    */ import de.simonsator.partyandfriends.utilities.LanguageConfiguration;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BWSMessages
/*    */   extends LanguageConfiguration
/*    */ {
/*    */   public BWSMessages(Language pLanguage, File pFile)
/*    */     throws IOException
/*    */   {
/* 16 */     super(pLanguage, pFile);
/* 17 */     readFile();
/* 18 */     loadDefaultValues();
/* 19 */     saveFile();
/* 20 */     process(this.configuration);
/*    */   }
/*    */   
/*    */   private void loadDefaultValues() {
/* 24 */     set("ClanStats.Wins", "&7The clan has won &a[WON] &7games.");
/* 25 */     set("ClanStats.Lost", "&7The clan has lost &a[LOST] &7games.");
/* 26 */     set("ClanStats.Played", "&7The clan has played &a[GAMES] &7games.");
/* 27 */     set("ClanStats.DestroyedBeds", "&7The clan has destroyed &a[BEDS] &7beds.");
/* 28 */     set("ClanStats.KD", "&7The average K/D of the clan is &a[KD]&7.");
/* 29 */     set("ClanStats.Kills", "&7The people of the clan have killed &a[KILLS] &7people.");
/* 30 */     set("ClanStats.Deaths", "&7The people of the clan have died &a[DEATHS]&7 times.");
/*    */   }
/*    */   
/*    */   public void reloadConfiguration() throws IOException {
/* 34 */     this.configuration = new BWSMessages(Language.OWN, this.FILE).getCreatedConfiguration();
/*    */   }
/*    */ }


/* Location:              /Users/simonbrungs/Downloads/bedwars-stats-rel-1.0-SNAPSHOT.jar!/de/simonsator/bedwarsstatsrel/BWSMessages.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */