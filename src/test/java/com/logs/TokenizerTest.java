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
    void parseNotValidString() {
        String invalidLogEntry = "177.71.128.21 - - [10/Jul/2018:22:21:T /intranet-analytics/ HT/1.1\" 200 3574";

        Tokenizer tokenizer = new Tokenizer();
        Entry result = tokenizer.parse(invalidLogEntry);
        Assertions.assertNull(result);
    }
}