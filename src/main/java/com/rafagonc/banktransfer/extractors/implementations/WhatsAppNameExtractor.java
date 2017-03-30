package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.result.BankTransfer;

/**
 * Created by rafagonc on 26/03/17.
 */
public class WhatsAppNameExtractor extends RegexDataExtractor {

    public WhatsAppNameExtractor() {
        super("(?<=\\d{2}\\/\\d{2}\\/\\d{2}\\s\\d{2}:\\d{2}:\\d{2}:\\s).*(?=:)");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String name = super.extract(text, transfer);
        transfer.setName(name);
        return name;
    }
}
