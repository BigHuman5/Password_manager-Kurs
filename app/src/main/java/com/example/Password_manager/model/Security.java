package com.example.Password_manager.model;

public class Security {
    private static String key;
    private static int minKey = 4;

    public Security() {}

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        Security.key = key;
    }

    public static int getMinKey() {
        return minKey;
    }

    public static void setMinKey(int minKey) {
        Security.minKey = minKey;
    }

}
