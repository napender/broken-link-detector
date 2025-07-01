package com.napendra.linkchecker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriter {

    public static void writeHtmlReport(List<LinkResult> results, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("<html><head><title>Link Report</title>");
            writer.write("<style>");
            writer.write("table { width: 100%; border-collapse: collapse; }");
            writer.write("th, td { border: 1px solid #ddd; padding: 8px; }");
            writer.write("th { background-color: #f2f2f2; }");
            writer.write(".ok { color: green; }");
            writer.write(".broken { color: red; }");
            writer.write("</style></head><body>");

            writer.write("<h2>Broken Link Report</h2>");
            writer.write("<table>");
            writer.write("<tr><th>URL</th><th>Status</th><th>Status Code</th></tr>");

            for (LinkResult result : results) {
                String rowClass = result.statusCode == 200 ? "ok" : "broken";
                writer.write("<tr>");
                writer.write("<td><a href=\"" + result.url + "\">" + result.url + "</a></td>");
                writer.write("<td class='" + rowClass + "'>" + result.statusText + "</td>");
                writer.write("<td>" + result.statusCode + "</td>");
                writer.write("</tr>");
            }

            writer.write("</table></body></html>");
            System.out.println("🌐 HTML Report saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Failed to write HTML: " + e.getMessage());
        }
    }
}
