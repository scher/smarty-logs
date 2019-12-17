package com.logs.reporters;

import com.logs.Storage;

import java.util.List;

public class TopMostAddresses extends TopMostReporter {

    public TopMostAddresses(int number, Storage storage) {
        super(number, storage);
    }

    @Override
    public List<String> report() {
        return calculateTopMost(storage.getIpStorage());
    }
}
