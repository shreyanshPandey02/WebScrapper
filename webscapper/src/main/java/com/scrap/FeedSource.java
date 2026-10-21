package com.scrap;

public class FeedSource {

    private String name;
    private String url;

    public FeedSource(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}