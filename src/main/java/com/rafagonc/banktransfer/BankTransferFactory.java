package com.rafagonc.banktransfer;

import com.rafagonc.banktransfer.exceptions.EmptyTextException;
import com.rafagonc.banktransfer.extractors.contract.BankDataExtractor;
import com.rafagonc.banktransfer.factory.BankDataExtractorFactory;
import com.rafagonc.banktransfer.result.BankTransfer;

/**
 * Created by Santander on 3/13/17.
 */
public class BankTransferFactory {

    //Getter and setters
    private String text;

    //Constructor
    public BankTransferFactory(String text) {
        this.text = text;
    }

    //static factory
    public static BankTransfer transfer(String text) throws Exception {
        return new BankTransferFactory(text).transfer();
    }

    //Methods
    public BankTransfer transfer() throws Exception {
        if (this.text == null || this.text.length() == 0) throw  new EmptyTextException("[BankTransferFactory transfer] Cannot proccess empty text");
        BankTransfer bankTransfer = new BankTransfer();
        for (BankDataExtractor extractor : BankDataExtractorFactory.extractors()) extractor.extract(text, bankTransfer);
        return bankTransfer;
    }
}
