package com.santander.core.factory;

import com.santander.core.BankDataExtractor;
import com.santander.core.extractors.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santander on 3/13/17.
 */
public class BankDataExtractorFactory {

    public static List<BankDataExtractor> extractors() {
        ArrayList list = new ArrayList();
        list.add(new CPFExtractor());
        list.add(new AccountExtractor());
        list.add(new AgencyExtractor());
        list.add(new ValueExtractor());
        return list;
    }
}
