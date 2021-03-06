package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.result.BankTransfer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Santander on 13/01/2017.
 */
public class LooseValueExtractor extends RegexDataExtractor {

    public LooseValueExtractor() {
        super("\\b(?<!-|\\/|\\\\|#|:|[a-zA-Z]|\\.)(\\d+((\\.?)\\d*)+((,|\\.)\\d{1,2})?(?!-|\\/|\\\\|#|:|[a-zA-Z]))\\b");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (result != null && transfer.getValue() == null) {
            transfer.setValue(result);
            return result;
        }
        return null;
    }

}
