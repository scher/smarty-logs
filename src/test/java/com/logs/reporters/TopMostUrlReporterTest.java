package com.logs.reporters;

import com.logs.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TopMostUrlReporterTest {

    @Test
    void report() {
        Storage storageMock = mock(Storage.class);
        HashMap<String, Integer> ipMap = new HashMap<>();
        ipMap.put("url1", 10);
        ipMap.put("url2", 2);
        ipMap.put("url3", 3);
        ipMap.put("url4", 4);

        when(storageMock.getUrlStorage()).thenReturn(ipMap);

        TopMostUrlReporter classToTest = new TopMostUrlReporter(2, storageMock);
        List<String> report = classToTest.report();
        Assertions.assertEquals(2, report.size());
        Assertions.assertTrue(report.contains("url1"));
        Assertions.assertTrue(report.contains("url4"));
    }

    @Test
    void reportsLestThanNumber() {
        Storage storageMock = mock(Storage.class);
        HashMap<String, Integer> ipMap = new HashMap<>();
        ipMap.put("url1", 10);
        ipMap.put("url2", 2);
        ipMap.put("url3", 3);
        ipMap.put("url4", 4);

        when(storageMock.getUrlStorage()).thenReturn(ipMap);

        TopMostUrlReporter classToTest = new TopMostUrlReporter(10, storageMock);
        List<String> report = classToTest.report();
        Assertions.assertEquals(4, report.size());
        Assertions.assertTrue(report.contains("url1"));
        Assertions.assertTrue(report.contains("url2"));
        Assertions.assertTrue(report.contains("url3"));
        Assertions.assertTrue(report.contains("url4"));
    }

    @Test
    void reportsNothing() {
        Storage storageMock = mock(Storage.class);
        HashMap<String, Integer> ipMap = new HashMap<>();

        when(storageMock.getUrlStorage()).thenReturn(ipMap);

        TopMostUrlReporter classToTest = new TopMostUrlReporter(10, storageMock);
        List<String> report = classToTest.report();
        Assertions.assertEquals(0, report.size());
    }

}