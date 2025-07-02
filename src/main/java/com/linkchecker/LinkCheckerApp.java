package com.napendra.linkchecker;

import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinkCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String targetUrl = null;
        int maxAttempts = 3;
        int attempt = 0;

            while (attempt < maxAttempts) {
        System.out.print("🔍 Enter website URL to scan: ");
        String input = scanner.nextLine().trim();

        // Basic format validation
        if (!input.startsWith("http://") && !input.startsWith("https://")) {
            System.out.println("❌ Invalid format. Please use http:// or https://");
            attempt++;
            continue;
        }

        // Try to connect with JSoup
        try {
            org.jsoup.Jsoup.connect(input).get(); // test connection
            targetUrl = input;
            break; // success
        } catch (Exception e) {
            System.out.println("❌ Failed to connect: " + e.getMessage());
            attempt++;
        }
    }

    if (targetUrl == null) {
        System.out.println("❌ Too many failed attempts. Exiting...");
        scanner.close();
        return;
    }

    System.out.println("🔍 Scanning: " + targetUrl);
    scanner.close();

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

        System.out.println("\n✅ Report generated: link_report.html");
        System.out.println("Press Enter to exit...");
        
        try {
    Scanner finalScanner = new Scanner(System.in);
    finalScanner.nextLine();
    // DO NOT close this scanner
} catch (Exception e) {
    // In case of weird stream closure (rare), just skip
}
    }
}
