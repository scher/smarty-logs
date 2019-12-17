package com.logs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UniqueAddressesReporterTest {

    @Test
    void report() {
        Storage storageMock = mock(Storage.class);
        HashMap<String, Integer> ipMap = new HashMap<>();
        ipMap.put("ip1", 5);
        ipMap.put("ip2", 1);
        ipMap.put("ip3", 100);
        when(storageMock.getIpStorage()).thenReturn(ipMap);

        UniqueAddressesReporter classToTest = new UniqueAddressesReporter(storageMock);
        int report = classToTest.report();
        Assertions.assertEquals(3, report);
    }
}