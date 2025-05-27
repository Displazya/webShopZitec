package com.automation.framework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random; // Import Random class
import java.util.UUID;

public class TestUtils {

    /**
     * Generates a timestamp string in "yyyyMMdd_HHmmss" format.
     * @return A string representing the current timestamp.
     */
    //Todo change pattern to a more friendly format
    public static String generateTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return now.format(formatter);
    }

    /**
     * Prints a message to the console
     * @param message The message to print.
     */
    public static void logMessage(String message) {
        System.out.println("[" + generateTimestamp() + "] " + message);
    }

    /**
     * Simulates a wait for a given number of milliseconds.
     * Not recommended to be used, instead use wait for element if possible.
     * @param milliseconds The number of milliseconds to wait.
     */
    public static void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logMessage("Wait interrupted: " + e.getMessage());
        }
    }

    /**
     * Generates a random username with a prefix and a random alphanumeric suffix.
     *
     * @param prefix The prefix for the username (e.g., "user_").
     * @param length The desired length of the random alphanumeric suffix.
     * @return A randomly generated username.
     */
    public static String generateRandomString(String prefix, String suffix) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }
        return prefix + randomString + suffix;
    }

    public static String generateRandomString(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }
        return String.valueOf(randomString);
    }


    /**
     * Generates a UUID string used for passwords
     * @return A 12-character string derived from a random UUID.
     */
    public static String uuidGenerator(){
        return UUID.randomUUID().toString().substring(0, 12);
    }
}