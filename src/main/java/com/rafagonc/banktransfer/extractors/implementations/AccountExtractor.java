package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.extractors.contract.BankDataExtractor;
import com.rafagonc.banktransfer.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class AccountExtractor extends RegexDataExtractor implements BankDataExtractor {

    public AccountExtractor() {
        super("\\b([0-9]{2})\\.?([0-9]{2,})-([0-9]{1})\\b", "conta", "Conta", "corrente", "Corrente", "cc", "CC.", "cc.","CC","cta","cta.","C\\c","C/c","c/c");
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
                    if (transfer.getAgency() != null) {
                        if (result != null && !transfer.getAgency().equals(result)) transfer.setAccount(account);
                        return result;
                    }
                }
            }
        }
        return null;
    }
}
