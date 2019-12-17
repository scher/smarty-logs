package com.logs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TokenizerTest {

    @Test
    void parseSuccessfulGET() {
        String logEntry = "177.71.128.21 - - [10/Jul/2018:22:21:28 +0200] \"GET /intranet-analytics/ HTTP/1.1\" 200 3574";
        Tokenizer tokenizer = new Tokenizer();
        Entry result = tokenizer.parse(logEntry);
        Assertions.assertEquals("177.71.128.21", result.getIpAddress());
        Assertions.assertEquals("/intranet-analytics/", result.getUrl());
    }

    @Test
    void parseSuccessfulPOST() {
        String logEntry = "177.71.128.21 - - [10/Jul/2018:22:21:28 +0200] \"POST /intranet-analytics/ HTTP/1.1\" 200 3574";
        Tokenizer tokenizer = new Tokenizer();
        Entry result = tokenizer.parse(logEntry);
        Assertions.assertEquals("177.71.128.21", result.getIpAddress());
        Assertions.assertEquals("/intranet-analytics/", result.getUrl());
    }

    @Test
    void parseSuccessfulAdmin() {
        String logEntry = "50.112.00.11 - admin [11/Jul/2018:17:31:56 +0200] \"GET /asset.js HTTP/1.1\" 200 3574 " +
                "\"-\" \"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1092.0 Safari/536.6";
        Tokenizer tokenizer = new Tokenizer();
        Entry result = tokenizer.parse(logEntry);
        Assertions.assertEquals("50.112.00.11", result.getIpAddress());
        Assertions.assertEquals("/asset.js", result.getUrl());
    }

    @Test
    void parseSuccessfulHttp() {
        String logEntry = "168.41.191.40 - - [09/Jul/2018:10:11:30 +0200] \"GET http://example.net/faq/ HTTP/1.1\" " +
                "200 3574 \"-\" \"Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; HTC Vision Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
        Tokenizer tokenizer = new Tokenizer();
        Entry result = tokenizer.parse(logEntry);
        Assertions.assertEquals("168.41.191.40", result.getIpAddress());
        Assertions.assertEquals("http://example.net/faq/", result.getUrl());
    }

    @Test
    void parseNotValidString() {
        String invalidLogEntry = "177.71.128.21 - - [10/Jul/2018:22:21:T /intranet-analytics/ HT/1.1\" 200 3574";
        Tokenizer tokenizer = new Tokenizer();
        Entry result = tokenizer.parse(invalidLogEntry);
        Assertions.assertNull(result);
    }
}