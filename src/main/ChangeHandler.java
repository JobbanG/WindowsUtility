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
    }

    public void goThroughFiles(File currentFile) {
        if (currentFile.exists() && currentFile.isDirectory()) {
            for (File file: Objects.requireNonNull(currentFile.listFiles())) {
                goThroughFiles(file);
            }
        }
        else {
            RenameFile(currentFile);
        }
    }

    private void RenameFile(File currentFile) {
        boolean success = false;
        switch (operation) {
            case "DEACCENT":
                success = currentFile.renameTo(new File(fileRenamer.deAccent(currentFile.getName()))); break;
            case "LOWERCASE":
                success = currentFile.renameTo(new File(fileRenamer.toLowerCase(currentFile.getName()))); break;
            case "UPPERCASE":
                success = currentFile.renameTo(new File(fileRenamer.toUpperCase(currentFile.getName()))); break;
        }
        if (!success) {
            System.out.println("There was an error while renaming file: " + currentFile.getAbsolutePath());
        }
    }

}
