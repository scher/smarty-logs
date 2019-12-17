package com.logs;

public class Entry {
    private final String ipAddress;
    private final String url;

    public Entry(String ipAddress, String url) {
        this.ipAddress = ipAddress;
        this.url = url;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getUrl() {
        return url;
    }
}
