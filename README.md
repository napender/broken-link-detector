# 🔗 Broken Link Detector

A simple and powerful Java CLI tool that scans any webpage for broken links and generates a clean HTML report. Built using **JSoup**, **Java 11+**, and **Maven**.

---

## ⚙️ Features

- Extracts all `<a href>` links from a given URL
- Sends HTTP HEAD requests to validate links
- Detects broken links (4xx/5xx)
- Generates a **clean HTML report** with results
- Easy to run from command line

---
## 🚀 How to Run ( using .jar )

### 💻 Windows
1. Download broken-link-detector.jar & run-link-checker.bat in same directory.
2. Double-click `run-link-checker.bat`.

### 🍏 macOS
1. Download broken-link-detector.jar & run-link-checker.command in same directory.
2. Double-click `run-link-checker.command`.

### 🐧 Linux
1. Download broken-link-detector.jar & run-link-checker.sh in same directory.
2. Make script executable:
   ```bash
   chmod +x run-link-checker.sh
---
## 🚀 How to Run ( Using code )

1. Clone the repo:

```bash
git clone https://github.com/YOUR_USERNAME/broken-link-detector.git
cd broken-link-detector
```

2. Build the project:

```bash
mvn clean install
```

3. Run the scanner:

```bash
mvn exec:java -Dexec.mainClass="com.napendra.linkchecker.LinkCheckerApp" -Dexec.args="https://example.com"
```

4. Open `link_report.html` to view results.

---   


## 📄 Sample Output (Console)

```c#
[OK]      https://example.com
[BROKEN]  https://example.com/badpage --> 404

✅ Scan complete!
Total links    : 23
Valid links    : 20
Broken links   : 3

```
---
## 🛠 Tech Stack
* Java 11+
* Maven
* JSoup
* HTTP Client (`java.net.http`)

---
👤 Author

Napendra Singh

Senior SDET | Building test tools, frameworks & real-world QA solutions

---
📌 License

MIT License – free to use, improve, and contribute.

