package com.rafagonc.banktransfer;

import com.rafagonc.banktransfer.exceptions.EmptyTextException;
import com.rafagonc.banktransfer.extractors.contract.BankDataExtractor;
import com.rafagonc.banktransfer.extractors.implementations.WhatsAppNameExtractor;
import com.rafagonc.banktransfer.factory.BankDataExtractorFactory;
import com.rafagonc.banktransfer.result.BankTransfer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        for (BankDataExtractor extractor : BankDataExtractorFactory.extractors()) {
            String result = extractor.extract(text, bankTransfer);
            if (result != null) {
                Pattern pattern = Pattern.compile(extractor.getRegex());
                text = removeIfEquals(extractor.getRegex(), text, result);
            }
        }
        return bankTransfer;
    }

    private String removeIfEquals(String regex, String text, String result) {
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(text);
        while (matcher.find()) {
            String find = matcher.group();
            if (find.equals(result) && matcher.start() > 0) {
                return text.substring(0,matcher.start()) + text.substring(matcher.end(), text.length());
            }
        }
        return text;
    }
}
