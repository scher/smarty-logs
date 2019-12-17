package com.logs.reporters;

import com.logs.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TopMostAddressesReporterTest {

    @Test
    void report() {
        Storage storageMock = mock(Storage.class);
        HashMap<String, Integer> ipMap = new HashMap<>();
        ipMap.put("ip1", 10);
        ipMap.put("ip2", 2);
        ipMap.put("ip3", 3);
        ipMap.put("ip4", 4);

        when(storageMock.getIpStorage()).thenReturn(ipMap);

        TopMostAddressesReporter classToTest = new TopMostAddressesReporter(2, storageMock);
        List<String> report = classToTest.report();
        Assertions.assertEquals(2, report.size());
        Assertions.assertTrue(report.contains("ip1"));
        Assertions.assertTrue(report.contains("ip4"));
    }

    @Test
    void reportsLestThanNumber() {
        Storage storageMock = mock(Storage.class);
        HashMap<String, Integer> ipMap = new HashMap<>();
        ipMap.put("ip1", 10);
        ipMap.put("ip2", 2);
        ipMap.put("ip3", 3);
        ipMap.put("ip4", 4);

        when(storageMock.getIpStorage()).thenReturn(ipMap);

        TopMostAddressesReporter classToTest = new TopMostAddressesReporter(10, storageMock);
        List<String> report = classToTest.report();
        Assertions.assertEquals(4, report.size());
        Assertions.assertTrue(report.contains("ip1"));
        Assertions.assertTrue(report.contains("ip2"));
        Assertions.assertTrue(report.contains("ip3"));
        Assertions.assertTrue(report.contains("ip4"));
    }

    @Test
    void reportsNothing() {
        Storage storageMock = mock(Storage.class);
        HashMap<String, Integer> ipMap = new HashMap<>();

        when(storageMock.getIpStorage()).thenReturn(ipMap);

        TopMostAddressesReporter classToTest = new TopMostAddressesReporter(10, storageMock);
        List<String> report = classToTest.report();
        Assertions.assertEquals(0, report.size());
    }
}