package main;

import java.io.File;
import java.util.Locale;
import java.util.Map;

public class FileRenamer {

    private final Map<Character, Character> accentMap;

    public FileRenamer() {
        accentMap = new AccentMapReader().readAccentMap();
    }

    public String deAccent(String currentFileName) {
        char[] newCharacters = new char[currentFileName.length()];
        for(int i = 0; i < currentFileName.length(); ++i) {
            newCharacters[i] = accentMap.get(currentFileName.charAt(i));
        }
        return new String(newCharacters);
    }

    public String toLowerCase(String currentFileName) {
        return currentFileName.toLowerCase();
    }

    public String toUpperCase(String currentFileName) {
        return currentFileName.toUpperCase();
    }

}
