package com.logs.reporters;

import com.logs.Storage;

import java.util.*;

public abstract class TopMostReporter {
    protected final Storage storage;
    private final int mostNumber;

    protected TopMostReporter(int number, Storage storage) {
        this.mostNumber = number;
        this.storage = storage;
    }

    public abstract List<String> report();

    protected List<String> calculateTopMost(HashMap<String, Integer> entries) {
        Comparator<Map.Entry<String, Integer>> comparing = Comparator.comparing(Map.Entry::getValue);
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(comparing.reversed());
        heap.addAll(entries.entrySet());
        ArrayList<String> result = new ArrayList<>();
        int limit = Math.min(mostNumber, heap.size());
        for (int i = 0; i < limit; i++) {
            result.add(heap.poll().getKey());
        }
        return result;
    }
}
