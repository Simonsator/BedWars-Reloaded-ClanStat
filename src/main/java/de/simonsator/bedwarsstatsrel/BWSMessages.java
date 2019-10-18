package de.simonsator.bedwarsstatsrel;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.utilities.Language;
import de.simonsator.partyandfriends.utilities.LanguageConfiguration;

import java.io.File;
import java.io.IOException;

public class BWSMessages extends LanguageConfiguration {
	public BWSMessages(Language pLanguage, File pFile, PAFExtension pPlugin) throws IOException {
		super(pLanguage, pFile, pPlugin);
		readFile();
		loadDefaultValues();
		saveFile();
		process();
	}

	private void loadDefaultValues() {
		set("ClanStats.Wins", "&7The clan has won &a[WON] &7games.");
		set("ClanStats.Lost", "&7The clan has lost &a[LOST] &7games.");
		set("ClanStats.Played", "&7The clan has played &a[GAMES] &7games.");
		set("ClanStats.DestroyedBeds", "&7The clan has destroyed &a[BEDS] &7beds.");
		set("ClanStats.KD", "&7The average K/D of the clan is &a[KD]&7.");
		set("ClanStats.Kills", "&7The people of the clan have killed &a[KILLS] &7people.");
		set("ClanStats.Deaths", "&7The people of the clan have died &a[DEATHS]&7 times.");
	}
}