package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.result.BankTransfer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rafagonc on 26/03/17.
 */
public class WhatsAppNameExtractor extends RegexDataExtractor {

    public WhatsAppNameExtractor() {
        super("(?<=\\d{2}\\/\\d{2}\\/\\d{2,4}\\s\\d{2}:\\d{2}:\\d{2}:\\s).*(?=:)");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String name = super.extract(text, transfer);
        if (name != null) {
            transfer.setName(name);
            return name;
        }
        return null;
    }

    public static String removeNameFromText(String text) {
        Pattern pattern = Pattern.compile("(?=\\d{2}\\/\\d{2}\\/\\d{2,4}\\s\\d{2}:\\d{2}:\\d{2}:\\s).*(?<=:)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String match = matcher.group();
            text = text.replace(match,"");
        }
        return text;
    }
}
