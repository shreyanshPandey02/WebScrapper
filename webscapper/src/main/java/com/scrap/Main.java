package com.scrap;
 
import java.io.IOException;
import java.util.ArrayList;
 
public class Main {
 
    public static void main(String[] args) {
 
        ArrayList<FeedSource> feedSources = new ArrayList<FeedSource>();
 
        feedSources.add(new FeedSource(
                "IEEE Spectrum",
                "https://spectrum.ieee.org/feeds/feed.rss"
        ));
 
        feedSources.add(new FeedSource(
                "MIT Technology Review",
                "https://www.technologyreview.com/feed/"
        ));
 
        RssReader rssReader = new RssReader();
        Filter filter = new Filter();
        CsvWr csvWr = new CsvWr();
 
        ArrayList<Article> allArticles = new ArrayList<Article>();
 
        for (int i = 0; i < feedSources.size(); i++) {
 
            FeedSource source = feedSources.get(i);
            System.out.println("Reading: " + source.getName());
 
            try {
                ArrayList<Article> articles = rssReader.readFeed(source);
                allArticles.addAll(articles);
                System.out.println("  Found " + articles.size() + " articles");
            } catch (IOException e) {
                System.out.println("  Failed to read " + source.getName() + ": " + e.getMessage());
            }
        }
 
        ArrayList<Article> engineeringArticles = filter.filterArticles(allArticles);
 
        System.out.println();
        System.out.println("Total articles: " + allArticles.size());
        System.out.println("Engineering articles: " + engineeringArticles.size());

        for (int i = 0; i < engineeringArticles.size(); i++) {
 
            Article article = engineeringArticles.get(i);
 
            System.out.println("[" + article.getSourceName() + "] " + article.getTitle());
            System.out.println("  " + article.getLink());
            System.out.println();
        }

        try {
            csvWr.writeCsv(engineeringArticles, "articles.csv");
            System.out.println("\nSaved " + engineeringArticles.size() + " articles to articles.csv");
        } catch (IOException e) {
            System.out.println("\nCould not write CSV: " + e.getMessage());
        }
    }
}
