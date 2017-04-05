package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.result.BankTransfer;

/**
 * Created by rafagonc on 27/03/17.
 */
public class CNPJExtractor extends RegexDataExtractor {

    public CNPJExtractor() {
        super("(\\d{2})\\.?(\\d{3})\\.?(\\d{3})\\/?(\\d{4})-?(\\d{2})", "cnpj","cpnj");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String s = super.extract(text, transfer);
        if (s != null) {
            transfer.setCnpj(s.replace(".","").replace("/","").replace("-",""));
            return s;
        }
        return null;
    }
}
