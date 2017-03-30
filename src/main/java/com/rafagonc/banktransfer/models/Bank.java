package com.rafagonc.banktransfer.models;

/**
 * Created by Santander on 3/14/17.
 */
public enum Bank {
    Santander("Santander", "(Santander|santander)"),
    Itau("Itaú", "(itau|Itau|itaú|Itaú)"),
    Bradesco("Bradesco", "(bradesco|Bradesco)"),
    Caixa("Caixa","(caixa|Caixa)"),
    HSBC("HSBC","(hsbc|HSBC)"),
    BancoDoBrasil("Banco do Brasil","(banco\\sdo\\sbrasil|Banco\\sDo\\sBrasil|Banco\\sdo\\sBrasil|Banco\\sdo\\sbrasil|Banco\\sdo\\sBR|banco\\sdo\\sbr|Banco\\sdo\\sbr)");

    //Properties
    private String regex;
    private String name;

    //Constructor
    Bank(String name, String regex) {
        this.regex = regex;
        this.name = name;
    }

    //Getters And Setters
    public String getRegex() {
        return regex;
    }
    public void setRegex(String regex) {
        this.regex = regex;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
