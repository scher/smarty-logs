package com.logs;

public class Runner {
    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer(args[0]);
        analyzer.analyze();
    }
}