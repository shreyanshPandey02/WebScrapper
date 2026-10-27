package com.scrap;

import java.util.*;

public class Filter {

    private String[] keywords = {"engineering", "engineer", "robot", "robotics", "artificial intelligence", "machine learning", "semiconductor",
            "electronics","embedded","sensor", "cybersecurity", "software", "programming","developer","aerospace", "satellite","drone",
            "energy","battery","electric vehicle","manufacturing","automation","5g","network","data science","quantum","3d printing"
    };

    public boolean isEngineeringArticle(Article article) {

        String text = article.getTitle().toLowerCase()
                + " " + article.getSummary().toLowerCase();

        for (int i = 0; i < keywords.length; i++) {

            if (text.contains(keywords[i])) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Article> filterArticles(ArrayList<Article> allArticles) {

        ArrayList<Article> engineeringArticles = new ArrayList<Article>();

        for (int i = 0; i < allArticles.size(); i++) {

            Article currentArticle = allArticles.get(i);

            if (isEngineeringArticle(currentArticle) == true) {
                engineeringArticles.add(currentArticle);
            }
        }

        return engineeringArticles;
    }
}