package com.logs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StorageTest {

    @Test
    void addEntryCountsNumOfEntries() {
        Storage storage = new Storage();
        storage.addEntry(new Entry("ip", "url"));
        storage.addEntry(new Entry("ip", "url"));
        storage.addEntry(new Entry("ip1", "url1"));

        Assertions.assertEquals(2, storage.getIpStorage().get("ip"));
        Assertions.assertEquals(1, storage.getIpStorage().get("ip1"));

        Assertions.assertEquals(2, storage.getUrlStorage().get("url"));
        Assertions.assertEquals(1, storage.getUrlStorage().get("url1"));
    }
}