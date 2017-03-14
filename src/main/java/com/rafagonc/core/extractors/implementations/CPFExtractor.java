package com.rafagonc.core.extractors.implementations;

import com.rafagonc.core.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class CPFExtractor extends RegexDataExtractor {

    public CPFExtractor() {
        super("(([0-9]{3})\\.?([0-9]{3})\\.?([0-9]{3})(-|/)?([0-9]{2}))", "cpf", "CPF", "c.p.f", "C.P.F");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (result != null) transfer.setCpf(result);
        return result;
    }
}
