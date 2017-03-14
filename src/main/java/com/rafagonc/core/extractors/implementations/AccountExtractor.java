package com.rafagonc.core.extractors.implementations;

import com.rafagonc.core.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class AccountExtractor extends RegexDataExtractor {

    public AccountExtractor() {
        //\b([0-9]{2})\.?([0-9]*)-([0-9]{1})\b
        //\b([0-9]{2})\.?([0-9]{3,6})-([0-9]{1})\b
        super("\\b([0-9]{2})\\.?([0-9]{2,})-([0-9]{1})\\b", "conta", "Conta", "corrente", "Corrente", "cc", "CC.", "cc.","CC");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (this.trust) {
            if (result != null) transfer.setAccount(result);
            return result;
        } else {
            for (String account: matches) {
                if (account.contains("-")) {
                    String[] split = account.split("-");
                    String accountWithoutDigit = split[0];
                    if (accountWithoutDigit.length() > 4) {
                        if (result != null) transfer.setAccount(account);
                        return accountWithoutDigit;
                    }
                }
            }
        }
        if (result != null) transfer.setAccount(result);
        return result;
    }
}
