package com.rafagonc.core.extractors.implementations;

import com.rafagonc.core.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class AgencyExtractor extends RegexDataExtractor {

    public AgencyExtractor() {
        super("\\b[0-9]{4}(-[0-9]{1})?\\b", "agencia", "Agencia", "agência", "Agência", "Ag", "ag", "Ag.", "ag.");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (result != null) transfer.setAgency(result);
        return result;
    }
}
