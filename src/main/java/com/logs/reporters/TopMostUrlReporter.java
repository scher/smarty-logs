package com.logs.reporters;

import com.logs.Storage;

import java.util.List;

public class TopMostUrlReporter extends TopMostReporter {
    public TopMostUrlReporter(int number, Storage storage) {
        super(number, storage);
    }

    @Override
    public List<String> report() {
        return calculateTopMost(storage.getUrlStorage());
    }
}
