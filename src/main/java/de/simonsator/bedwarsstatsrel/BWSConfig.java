/*    */
package de.simonsator.bedwarsstatsrel;
/*    */ 
/*    */

import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

/*    */
/*    */
/*    */ 
/*    */ 
/*    */ public class BWSConfig
/*    */ extends ConfigurationCreator
/*    */ {
	/*    */
	protected BWSConfig(File file)
/*    */     throws IOException
/*    */ {
/* 14 */
		super(file);
/* 15 */
		readFile();
/* 16 */
		loadDefaultValues();
/* 17 */
		saveFile();
/*    */
	}

	/*    */
/*    */
	private void loadDefaultValues() {
/* 21 */
		set("database.host", "localhost");
/* 22 */
		set("database.port", 3306);
/* 23 */
		set("database.db", "minecraft");
/* 24 */
		set("database.user", "root");
/* 25 */
		set("database.password", "password");
/*    */
	}

	/*    */
/*    */
	public void reloadConfiguration() throws IOException {
/* 29 */
		this.configuration = new BWSConfig(this.FILE).getCreatedConfiguration();
/*    */
	}
/*    */
}


/* Location:              /Users/simonbrungs/Downloads/bedwars-stats-rel-1.0-SNAPSHOT.jar!/de/simonsator/bedwarsstatsrel/BWSConfig.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */