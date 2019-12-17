package com.logs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private static final String LOG_ENTRY_PATTERN = "^(.*?) - .*\\w (.*) HTTP";
    private static final Pattern PATTERN = Pattern.compile(LOG_ENTRY_PATTERN);

    public static Entry parse(String entry) {
        Matcher matcher = PATTERN.matcher(entry);
        if (matcher.find()) {
            return new Entry(matcher.group(1), matcher.group(2));
        } else {
            return null;
        }
    }
}
