package com.rafagonc.core.extractors.implementations;

import com.rafagonc.core.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class ValueExtractor extends RegexDataExtractor {

    public ValueExtractor() {
        super("R?\\$\\s?[0-9]+((,|\\.)[0-9]+)?", "valor", "Valor", "reais", "Reais", "R$", "$", "montante");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (result != null) transfer.setValue(result);
        return result;
    }
}
