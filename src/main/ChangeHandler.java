package main;

import java.io.File;
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
        System.out.println("Finished renaming all folders and files under '" + path + "'");
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
        String newName = "";
        switch (operation) {
            case "DEACCENT":
                newName = fileRenamer.deAccent(currentFile.getName()); break;
            case "LOWERCASE":
                newName = fileRenamer.toLowerCase(currentFile.getName()); break;
            case "UPPERCASE":
                newName = fileRenamer.toUpperCase(currentFile.getName()); break;
        }
        if (currentFile.renameTo(new File(currentFile.getParent(), newName))) {
            System.out.println("Renamed '" + currentFile.getName() + "' to '" + newName + "'");
        }
        else {
            System.out.println("Couldn't rename '" + currentFile.getName() + "' to '" + newName + "'");
        }
    }

}
