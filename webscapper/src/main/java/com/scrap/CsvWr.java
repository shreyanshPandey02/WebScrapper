package com.scrap;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.BufferedWriter;

public class CsvWr {

    public void writeCsv(ArrayList<Article> articles, String fileName)
            throws IOException {

        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("Title,Source,Link,Summary");
        bufferedWriter.newLine();

        for (int i = 0; i < articles.size(); i++) {

            Article article = articles.get(i);

            String line = escapeCsv(article.getTitle()) + ","
                    + escapeCsv(article.getSourceName()) + ","
                    + escapeCsv(article.getLink()) + ","
                    + escapeCsv(article.getSummary());

            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        fileWriter.close();
    }

    private String escapeCsv(String text) {

        if (text == null) {
            text = "";
        }

        text = text.replace("\"", "\"\"");

        return "\"" + text + "\"";
    }
}