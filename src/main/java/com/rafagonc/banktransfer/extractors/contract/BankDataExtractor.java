package com.rafagonc.banktransfer.extractors.contract;

import com.rafagonc.banktransfer.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public interface BankDataExtractor {

    public String extract(String text, BankTransfer transfer);
    public String getRegex();

}
