package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AccentMapReader {

    private static final String ACCENT_FILE_NAME = "accent_map.txt";

    public Map<Character, Character> readAccentMap() {
        Map<Character, Character> accentMap = new HashMap<>();
        InputStream inputStream = getInputStream();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] characters = line.split(",");
                accentMap.put(characters[0].charAt(0), characters[1].charAt(0));
            }
        }
        catch (IOException exception) {
            System.out.println("There was a problem while reading accent map!");
            exception.printStackTrace();
            System.exit(1);
        }
        return accentMap;
    }

    private InputStream getInputStream() {
        InputStream inputStream = getClass().getResourceAsStream(ACCENT_FILE_NAME);
        if (Objects.isNull(inputStream)) {
            System.out.println("Accent map couldn't be found!");
            System.exit(1);
        }
        return inputStream;
    }

}
