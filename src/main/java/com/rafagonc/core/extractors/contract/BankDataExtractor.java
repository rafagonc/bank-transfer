package com.rafagonc.core.extractors.contract;

import com.rafagonc.core.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public interface BankDataExtractor {

    public String extract(String text, BankTransfer transfer);

}
