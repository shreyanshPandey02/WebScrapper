# EngiDigest — Engineering Newsletter & Tech Digest Scraper
**EngiDigest** is a Java-based web scraping application that collects recent engineering and technology articles from publicly available RSS feeds, filters them for engineering-related topics, analyzes frequently used keywords, and generates a structured newsletter digest in CSV and HTML formats.

The project was developed as part of the **CSN203 / Java Programming** coursework to demonstrate practical use of Java Programming language in a real world application.

---
## 📌 Project Overview

Engineers often need to stay updated with developments in areas such as artificial intelligence, robotics, electronics, software engineering, and emerging technologies. Manually visiting multiple websites can be time-consuming.

EngiDigest automates this process by:

- Fetching articles from selected RSS feeds
- Extracting titles, links, descriptions, and publication information
- Filtering content based on engineering-related keywords
- Identifying the most frequently occurring technical keywords
- Saving the collected articles in CSV format
- Generating a clean, readable HTML newsletter digest

The application uses RSS feeds rather than aggressively scraping regular web pages, making the data-collection approach more structured and respectful of source websites.

---
## 🛠️ Technologies Used

- Maven | Project build and dependency management 
- Jsoup | Fetching and parsing RSS/HTML content 
- CSV | Structured storage of scraped articles 
- HTML/CSS | Presentation of the generated digest 

[Jsoup](https://jsoup.org/) is an open-source Java library used for fetching, parsing, and extracting data from HTML and XML documents. It is commonly used for web scraping and supports DOM traversal and CSS-selector-based extraction. 

---

## 🧠Core Components
### `Article`
A model class representing one scraped article. It stores fields such as title, URL, description, source, and topic/category.

### `FeedSource`
Represents a news source. It stores the source name and RSS feed URL.

### `RssReader`
Connects to an RSS feed using Jsoup, reads the XML content, and extracts article details such as title, link, and description.

### `EngineeringFilter`
Checks whether an article is relevant to engineering by matching its title or description against a predefined list of engineering-related keywords.

### `KeywordAnalyzer`
Counts the frequency of important technical words using a `HashMap<String, Integer>` and identifies trending keywords.

### `CsvWriter`
Writes filtered articles into a CSV file so that the data can be opened in Excel or used for further analysis.

### `HtmlWriter`
Creates an HTML newsletter file containing the selected articles in a readable format.

### `Main`
The entry point of the application. It creates feed sources, reads articles, applies filtering, performs keyword analysis, and generates the output files.

---
## 🌐 Data Sources

The project uses publicly available RSS feeds from technology and engineering publications.

Example source:

- IEEE Spectrum RSS Feed: https://spectrum.ieee.org/feeds/feed.rss [12]

Additional sources such as MIT Technology Review can be added by creating new `FeedSource` objects in the main class.

---

## ⚠️ Ethical Usage

This project is intended for educational purposes only.

- Only publicly available RSS feeds are used.
- The application does not bypass login systems or paywalls.
- Users should review the terms of service and `robots.txt` of any website before scraping.
- Request frequency should be kept reasonable to avoid overloading servers.

---
