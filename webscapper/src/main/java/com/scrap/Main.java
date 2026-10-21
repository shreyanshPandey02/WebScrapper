package com.scrap;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<FeedSource> feedSources = new ArrayList<FeedSource>();

        feedSources.add(new FeedSource(
                "IEEE Spectrum Robotics",
                "https://spectrum.ieee.org/"
        ));

        feedSources.add(new FeedSource(
                "MIT Technology Review",
                "https://www.technologyreview.com/"
        ));

        RssReader rssReader = new RssReader();
    }
}
