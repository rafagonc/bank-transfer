package com.santander.core.extractors;

import com.santander.core.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class AccountExtractor extends RegexDataExtractor {

    public AccountExtractor() {
        super("\\b([0-9]{2})\\.?([0-9])*-([0-9]{1})\\b", "conta", "Conta", "corrente", "Corrente");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        transfer.setAccount(result);
        return result;
    }
}
