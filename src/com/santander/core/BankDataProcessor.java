package com.santander.core;

import com.santander.core.factory.BankDataExtractorFactory;

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

    //Methods
    public BankTransfer transfer() {
        BankTransfer bankTransfer = new BankTransfer();
        for (BankDataExtractor extractor : BankDataExtractorFactory.extractors()) extractor.extract(text, bankTransfer);
        return bankTransfer;
    }
}
