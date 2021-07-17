package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ChangeHandler {

    private final FileRenamer fileRenamer;
    private final String operation;

    public ChangeHandler(FileRenamer fileRenamer, String operation) {
        this.fileRenamer = fileRenamer;
        this.operation = operation;
    }

    public void doOperation(String path) {
        File currentFile = new File(path);
        goThroughFiles(currentFile);
        System.out.println("Finished renaming all folders under '" + path + "'");
    }

    public void goThroughFiles(File currentFile) {
        if (currentFile.exists() && currentFile.isDirectory()) {
            for (File file: Objects.requireNonNull(currentFile.listFiles())) {
                goThroughFiles(file);
            }
        }
        RenameFile(currentFile);
    }

    private void RenameFile(File currentFile) {
        Path path = Paths.get(currentFile.getAbsolutePath());
        String newName = "";
        switch (operation) {
            case "DEACCENT":
                newName = fileRenamer.deAccent(currentFile.getName()); break;
            case "LOWERCASE":
                newName = fileRenamer.toLowerCase(currentFile.getName()); break;
            case "UPPERCASE":
                newName = fileRenamer.toUpperCase(currentFile.getName()); break;
        }
        try {
            Files.move(path, path.resolveSibling(newName));
            System.out.println("Renaming file " + path + " to " + path.resolveSibling(newName));
        }
        catch (IOException exception) {
            System.out.println("There was an error while renaming file: " + currentFile.getAbsolutePath());
        }
    }

}
