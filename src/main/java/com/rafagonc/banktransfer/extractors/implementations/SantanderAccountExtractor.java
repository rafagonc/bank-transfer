package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.extractors.contract.BankDataExtractor;
import com.rafagonc.banktransfer.result.BankTransfer;

/**
 * Created by Santander on 13/01/2017.
 */
public class SantanderAccountExtractor extends RegexDataExtractor implements BankDataExtractor {

    public SantanderAccountExtractor() {
        super("\\b(\\d{2}\\.\\d{6}\\.\\d{1})\\b");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        transfer.setAccount(result);
        return result;
    }


}
