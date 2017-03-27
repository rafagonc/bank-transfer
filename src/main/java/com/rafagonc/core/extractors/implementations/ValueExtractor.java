package com.rafagonc.core.extractors.implementations;

import com.rafagonc.core.extractors.contract.BankDataExtractor;
import com.rafagonc.core.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class ValueExtractor extends RegexDataExtractor implements BankDataExtractor {

    public ValueExtractor() {
        super("\\bR?(\\$?)(\\s?)(\\d*)((\\.|,)\\d*)\\b", "valor", "Valor", "reais", "Reais", "R$", "$", "montante");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (result != null) transfer.setValue(result);
        return result;
    }
}
