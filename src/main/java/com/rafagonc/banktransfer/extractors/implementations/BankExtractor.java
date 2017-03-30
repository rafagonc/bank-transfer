package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.extractors.contract.BankDataExtractor;
import com.rafagonc.banktransfer.result.BankTransfer;
import com.rafagonc.banktransfer.models.Bank;

/**
 * Created by Santander on 3/14/17.
 */
public class BankExtractor extends RegexDataExtractor implements BankDataExtractor {

    //Properties
    private Bank bank;

    //Constructor
    public BankExtractor(Bank bank) {
        super(bank.getRegex());
        this.bank = bank;
    }

    //Methods
    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (result != null) {
            transfer.setBank(this.bank.getName());
        }
        return result;
    }

    //Getters and Setters
    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
