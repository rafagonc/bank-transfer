package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.extractors.contract.BankDataExtractor;
import com.rafagonc.banktransfer.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class AgencyExtractor extends RegexDataExtractor implements BankDataExtractor {

    public AgencyExtractor() {
        super("\\b(?<!(\\/|\\\\))[0-9]{4}(-[0-9]{1})?\\b", "agencia", "Agencia", "agência", "Agência", "Ag", "ag", "Ag.", "ag.");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (result != null) transfer.setAgency(result);
        return result;
    }
}
