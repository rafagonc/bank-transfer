package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.utils.StringUtils;
import com.rafagonc.banktransfer.result.BankTransfer;
import com.rafagonc.banktransfer.extractors.contract.BankDataExtractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Santander on 3/13/17.
 */
public class RegexDataExtractor implements BankDataExtractor {

    protected String regex;
    protected List<String> fromLine;
    protected List<String> matches;
    protected Boolean trust;

    public RegexDataExtractor(String regex, String... fromLine) {
        this.regex = regex;
        this.fromLine = Arrays.asList(fromLine);
        this.matches = new ArrayList<>();
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        return find(text,this.regex);
    }

    private String find(String text, String regex) {
        Matcher matcher = matcher(text,regex);
        while (matcher.find()) {
            String match = matcher.group();
            matches.add(match);
            for (String fl : this.fromLine) {
                String wordBefore = StringUtils.wordBefore(text, match);
                if (fl.equalsIgnoreCase(wordBefore)) {
                    this.trust = true;
                    return match;
                }
            }
        }
        this.trust = false;
        if (matches.size() > 0) {
            return matches.get(0);
        } else {
            return null;
        }
    }

    protected Matcher matcher(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher;
    }

    @Override
    public String getRegex() {
        return regex;
    }
}
