package com.napendra.linkchecker;

public class LinkResult {
    public String url;
    public int statusCode;
    public String statusText;

    public LinkResult(String url, int statusCode, String statusText) {
        this.url = url;
        this.statusCode = statusCode;
        this.statusText = statusText;
    }
}
