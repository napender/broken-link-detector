package com.napendra.linkchecker;

import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class LinkCheckerApp {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("❗ Please provide a URL as an argument.");
            return;
        }

        String targetUrl = args[0];
        System.out.println("🔍 Scanning: " + targetUrl);

        Elements urls = LinkExtractor.extractLinks(targetUrl);

        int total = 0, ok = 0, broken = 0;
        List<LinkResult> resultList = new ArrayList<>();

        for (Element urlElement : urls) {
            total++;
            String url = urlElement.attr("abs:href");
            int statusCode = LinkValidator.validateLinks(url);
            String statusText = (statusCode == 200) ? "OK" : "BROKEN";

            // Store result for report
            resultList.add(new LinkResult(url, statusCode, statusText));

            // Console Output
            if (statusCode >= 200 && statusCode < 300) {
                ok++;
                System.out.println("[OK]      " + url);
            } else {
                broken++;
                System.out.println("[BROKEN]  " + url + " --> " + statusCode);
            }
        }

        System.out.println("\n✅ Scan complete!");
        System.out.println("Total links    : " + total);
        System.out.println("Valid links    : " + ok);
        System.out.println("Broken links   : " + broken);

        // Save to HTML report
        String reportFileName = "link_report.html";
        ReportWriter.writeHtmlReport(resultList, reportFileName);
    }
}
