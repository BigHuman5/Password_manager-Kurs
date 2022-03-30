package com.example.Password_manager.model;

public class Security {
    private String key;
    private static int minKey = 4;

    public Security() {}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public static int getMinKey() {
        return minKey;
    }

    public static void setMinKey(int minKey) {
        Security.minKey = minKey;
    }

}
