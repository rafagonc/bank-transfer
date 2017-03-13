package com.santander;

import com.santander.core.BankDataProcessor;
import com.santander.core.BankTransfer;

public class Main {

    public static void main(String[] args) {

        String text = "$30,00 \n 430.350.348-77 \n 00710-4 \n 9670";
        BankDataProcessor processor = new BankDataProcessor(text);
        BankTransfer transfer = processor.transfer();

        System.out.println(transfer.getCpf());
        System.out.println(transfer.getValue());
        System.out.println(transfer.getAccount());
        System.out.println(transfer.getAgency());

    }

}
