package com.scrap;

public class Article {
    private String title;
    private String link;
    private String sourceName;
    private String summary;

    public Article(String title, String link, String sourceName, String summary) {
        this.title = title;
        this.link = link;
        this.sourceName = sourceName;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getSummary() {
        return summary;
    }

}


    