package com.napendra.linkchecker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.List;

public class LinkExtractor {
    private String url;
    LinkExtractor(String url) {
        this.url = url;
    }

    public static Elements extractLinks(String url) {
        try{
            Document webpage = Jsoup.connect(url).get();
            Elements links = webpage.select("a[href]");
            return links;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}