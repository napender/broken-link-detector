#!/bin/bash
cd "$(dirname "$0")"
java -jar broken-link-detector.jar
read -p "Press Enter to close window..."

