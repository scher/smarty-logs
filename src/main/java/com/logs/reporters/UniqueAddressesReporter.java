package com.logs.reporters;

import com.logs.Storage;

public class UniqueAddressesReporter {
    private Storage storage;

    public UniqueAddressesReporter(Storage storage) {
        this.storage = storage;
    }

    public int report() {
        return storage.getIpStorage().size();
    }
}
