package com.logs;

import java.util.HashMap;

public class Storage {
    private final HashMap<String, Integer> ipStorage = new HashMap<>();
    private final HashMap<String, Integer> urlStorage = new HashMap<>();

    public HashMap<String, Integer> getIpStorage() {
        return ipStorage;
    }

    public HashMap<String, Integer> getUrlStorage() {
        return urlStorage;
    }

    public void addEntry(Entry entry) {
        ipStorage.compute(entry.getIpAddress(), (k, v) -> v == null ? 1 : ++v);
        urlStorage.compute(entry.getUrl(), (k, v) -> v == null ? 1 : ++v);
    }

}
