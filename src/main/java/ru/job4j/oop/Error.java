package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error's flag: " + active);
        System.out.println("Error's code: " + status);
        System.out.println("Error's message: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error second = new Error(true, 440, "Not Found");
        Error third = new Error(false, 418, "I'm a teapot");
        error.printInfo();
        second.printInfo();
        third.printInfo();
    }
}