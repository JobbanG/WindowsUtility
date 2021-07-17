package main;

public class Main {

    public static void main(String[] args) {
        ArgumentChecker argumentChecker = new ArgumentChecker();
        argumentChecker.checkArguments(args);
        ChangeHandler changeHandler = new ChangeHandler(new FileRenamer(), args[0]);
        changeHandler.doOperation(args[1]);
    }
}
