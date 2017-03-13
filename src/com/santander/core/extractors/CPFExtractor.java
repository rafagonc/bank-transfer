package com.santander.core.extractors;

import com.santander.core.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class CPFExtractor extends RegexDataExtractor {

    public CPFExtractor() {
        super("(([0-9]{3})\\.?([0-9]{3})\\.?([0-9]{3})-?([0-9]{2}))", "cpf", "CPF", "c.p.f", "C.P.F");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        transfer.setCpf(result);
        return result;
    }
}
