package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.result.BankTransfer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Santander on 13/01/2017.
 */
public class DescriptiveValueExtractor extends RegexDataExtractor {

    public DescriptiveValueExtractor() {
        super("((\\d{1,})((,)\\d{1,})?.(reais|Reais))");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (result != null) {
            Pattern pattern = Pattern.compile("(\\d{1,})((,)\\d{1,})?");
            Matcher matcher = pattern.matcher(result);
            if (matcher.find()) {
                String value = matcher.group();
                if (transfer.getValue() == null) {
                    transfer.setValue(value);
                }
            }
            return result;
        } else {
            return null;
        }
    }
}
