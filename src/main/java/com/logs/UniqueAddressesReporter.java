package com.logs;

public class UniqueAddressesReporter {
    private Storage storage;

    public UniqueAddressesReporter(Storage storage) {
        this.storage = storage;
    }

    public int report() {
        return storage.getIpStorage().size();
    }
}
