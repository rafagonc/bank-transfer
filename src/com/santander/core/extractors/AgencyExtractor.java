package com.santander.core.extractors;

import com.santander.core.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class AgencyExtractor extends RegexDataExtractor {

    public AgencyExtractor() {
        super("\\b[0-9]{4}(-[0-9]{1})?\\b", "agencia", "Agencia", "agência", "Agência");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        transfer.setAgency(result);
        return result;
    }
}
