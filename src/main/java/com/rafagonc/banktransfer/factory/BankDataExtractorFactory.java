package com.rafagonc.banktransfer.factory;

import com.rafagonc.banktransfer.extractors.contract.BankDataExtractor;
import com.rafagonc.banktransfer.extractors.implementations.*;
import com.rafagonc.banktransfer.models.Bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santander on 3/13/17.
 */
public class BankDataExtractorFactory {

    public static List<BankDataExtractor> extractors() {
        ArrayList list = new ArrayList();
        list.add(new WhatsAppNameExtractor());
        list.add(new CPFExtractor());
        list.add(new CNPJExtractor());
        list.add(new AgencyExtractor());
        list.add(new AccountExtractor());
        for (Bank bank: Bank.values()) {
            list.add(new BankExtractor(bank));
        }
        list.add(new ValueExtractor());
        list.add(new WeakAccountExtractor());
        //list.add(new DescriptiveValueExtractor());
        list.add(new LooseValueExtractor());
        return list;
    }
}
