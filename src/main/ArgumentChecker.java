package main;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ArgumentChecker {

    private static final List<String> possibleOperations = Arrays.asList("DEACCENT", "UPPERCASE", "LOWERCASE");

    public void checkArguments(String[] args) {
        System.out.println("Checking arguments...");
        if (args.length != 2) {
            System.out.println("Invalid number of arguments! Must be 2!");
            System.exit(1);
        }
        String operation = args[0];
        if (!possibleOperations.contains(operation)) {
            System.out.println("Operation: '" + operation + "' is invalid!");
            System.out.println("Possible operations: 'DEACCENT', 'UPPERCASE', 'LOWERCASE'");
            System.exit(1);
        }
        String path = args[1];
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Path: '" + path + "' is invalid!");
            System.exit(1);
        }
    }

}
