package com.scrap;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class RssReader {

    private String getText(Element item, String tag) {
    Element found = item.getElementsByTag(tag).first();
    if (found == null) {
        return "";
    }
    return found.text();
}
    public ArrayList<Article> readFeed(FeedSource feedSource) throws IOException{
        ArrayList<Article> articles = new ArrayList<Article>();

        Document document = Jsoup.connect(feedSource.getUrl()).userAgent("College Project Tester").timeout(20000).ignoreContentType(true).parser(Parser.xmlParser()).get();

        Elements items = document.getElementsByTag("item");

        for (int i = 0; i < items.size(); i++) {

            Element item = items.get(i);
            String title = getText(item, "title");
            String link = getText(item, "link");
            String summary = Jsoup.parse(getText(item, "description")).text();

             if (title.equals("") || link.equals(""))
                continue;

            Article article = new Article( title, link, feedSource.getName(), summary);
            articles.add(article);
        }
        return articles;
    }
}