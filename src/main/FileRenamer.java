package main;

import java.util.Map;

public class FileRenamer {

    private final Map<Integer, Character> accentMap;

    public FileRenamer() {
        accentMap = new AccentMapReader().readAccentMap();
    }

    public String deAccent(String currentFileName) {
        char[] newCharacters = new char[currentFileName.length()];
        for(int i = 0; i < currentFileName.length(); ++i) {
            int characterCode = currentFileName.charAt(i);
            if (accentMap.containsKey(characterCode)) {
                newCharacters[i] = accentMap.get(characterCode);
            }
            else {
                newCharacters[i] = currentFileName.charAt(i);
            }
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
