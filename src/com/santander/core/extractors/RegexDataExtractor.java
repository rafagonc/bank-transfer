package com.santander.core.extractors;

import com.santander.core.BankDataExtractor;
import com.santander.core.BankTransfer;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Santander on 3/13/17.
 */
public class RegexDataExtractor implements BankDataExtractor {

    private String regex;
    private List<String> fromLine;

    public RegexDataExtractor(String regex, String... fromLine) {
        this.regex = regex;
        this.fromLine = Arrays.asList(fromLine);
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String match = find(text,this.regex);
        if (match != null) {
            return match;
        } else {
            String[] lines = text.split("\n");
            for (String line : lines) {
                for (String fromLine: this.fromLine) {
                    if (line.contains(fromLine)) {
                        return find(line, "[0-9].*[0-9]");
                    }
                }
            }
        }
        return null;
    }

    private String find(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }
}
