package com.santander.core.extractors;

import com.santander.core.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class ValueExtractor extends RegexDataExtractor {

    public ValueExtractor() {
        super("R?\\$\\s?[0-9]+((,|\\.)[0-9]+)?", "valor", "Valor", "reais", "Reais");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        transfer.setValue(result);
        return result;
    }
}
