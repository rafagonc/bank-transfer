package com.rafagonc.core.extractors.implementations;

import com.rafagonc.core.result.BankTransfer;

/**
 * Created by rafagonc on 26/03/17.
 */
public class WeakAccountExtractor extends RegexDataExtractor {

    public WeakAccountExtractor() {
        super("\\b\\d{6,9}\\b", "conta", "Conta", "corrente", "Corrente", "cc", "CC.", "cc.","CC","cta","cta.","C\\c","C/c","c/c");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String account = super.extract(text, transfer);
        if (account != null && transfer.getAccount() == null) transfer.setAccount(account);
        return account;
    }
}
