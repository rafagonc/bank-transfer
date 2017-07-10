package com.rafagonc.banktransfer.result;

import java.io.Serializable;

/**
 * Created by Santander on 3/13/17.
 */
public class BankTransfer implements Serializable {

    private String cpf;
    private String value;
    private String account;
    private String agency;
    private String name;
    private String bank;
    private String cnpj;

    //Getters and Setters
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf.replace(".","").replace("-","").replace("/","");
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value.replace("$","").replace("R","").replace(" ","");
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        if (account != null) {
            this.account = account.replace(".","");
        }
    }
    public String getAgency() {
        return agency;
    }
    public void setAgency(String agency) {
        this.agency = agency;
    }
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
