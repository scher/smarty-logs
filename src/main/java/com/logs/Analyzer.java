package com.logs;

import com.logs.reporters.TopMostAddressesReporter;
import com.logs.reporters.TopMostUrlReporter;
import com.logs.reporters.UniqueAddressesReporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Analyzer {
    private String fileName;
    private Storage storage = new Storage();

    public Analyzer(String fileName) {
        this.fileName = fileName;
    }

    public void analyze() {
        readFile();
        printReport();
    }

    private void printReport() {
        UniqueAddressesReporter uniqueAddressesReporter = new UniqueAddressesReporter(storage);
        int numberOfUniqAddresses = uniqueAddressesReporter.report();
        TopMostUrlReporter topMostUrlReporter = new TopMostUrlReporter(3, storage);
        List<String> topMostUrls = topMostUrlReporter.report();
        TopMostAddressesReporter topMostAddressesReporter = new TopMostAddressesReporter(3, storage);
        List<String> topMostAddresses = topMostAddressesReporter.report();

        System.out.println("The number of unique IP addresses: " + numberOfUniqAddresses);
        System.out.println("The top 3 most visited URLs: " + topMostUrls.toString());
        System.out.println("The top 3 most active IP addresses: " + topMostAddresses.toString());
    }

    private void readFile() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(this::processLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processLine(String line) {
        Entry entry = Tokenizer.parse(line);
        if (entry == null) {
            System.err.println("Invalid line: " + line);
            System.err.println("Skipping it");
        } else {
            storage.addEntry(entry);
        }
    }
}
