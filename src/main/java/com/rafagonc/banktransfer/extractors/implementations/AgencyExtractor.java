package com.rafagonc.banktransfer.extractors.implementations;

import com.rafagonc.banktransfer.extractors.contract.BankDataExtractor;
import com.rafagonc.banktransfer.result.BankTransfer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by Santander on 3/13/17.
 */
public class AgencyExtractor extends RegexDataExtractor implements BankDataExtractor {

    public AgencyExtractor() {
        super("\\b(?<!(\\/|\\\\))[0-9]{4}(-[0-9]{1})?\\b", "agencia", "Agencia", "agência", "Agência", "Ag", "ag", "Ag.", "ag.");
    }

    @Override
    public String extract(String text, BankTransfer transfer) {
        String result = super.extract(text, transfer);
        if (this.trust) {
            transfer.setAgency(result);
            return result;
        }

        List<String> agencies = (List<String>) this.matches;
        if (agencies.size() == 0) return null;
        else {
            for (String s : agencies) {
                if (s.length() == 4) {
                    transfer.setAgency(s);
                    return s;
                }
            }
            transfer.setAgency(agencies.get(0));
            return agencies.get(0);
        }

    }
}
