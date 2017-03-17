package com.rafagonc.core;

import com.rafagonc.core.extractors.contract.BankDataExtractor;
import com.rafagonc.core.factory.BankDataExtractorFactory;
import com.rafagonc.core.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class BankDataProcessor {

    //Getter and setters
    private String text;

    //Constructor
    public BankDataProcessor(String text) {
        this.text = text;
    }

    //static factory
    public static BankTransfer transfer(String text) {
        return new BankDataProcessor(text).transfer();
    }

    //Methods
    public BankTransfer transfer() {
        BankTransfer bankTransfer = new BankTransfer();
        for (BankDataExtractor extractor : BankDataExtractorFactory.extractors()) extractor.extract(text, bankTransfer);
        return bankTransfer;
    }
}
