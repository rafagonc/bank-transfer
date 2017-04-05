package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.extractors.contract.BankDataExtractor;
import com.rafagonc.banktransfer.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class ValueExtractor extends RegexDataExtractor implements BankDataExtractor {

    public ValueExtractor() {
        super("(R)?(\\$)(\\s?)(\\d*)((\\.|,)\\d*)?", "valor", "Valor", "reais", "Reais", "R$", "$", "montante");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (result != null) transfer.setValue(result);
        return result;
    }
}
