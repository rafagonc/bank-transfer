package com.rafagonc.core;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import java.io.Serializable;

/**
 * Created by rafagonc on 26/03/17.
 */
public class BankTransferRequest implements Serializable {

    //getters and setters
    @NotEmpty
    @SafeHtml
    private String text;
    private String master_key;

    //constructors
    public BankTransferRequest() {
    }
    public BankTransferRequest(String text, String master_key) {
        this.text = text;
        this.master_key = master_key;
    }

    //getters and setters
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getMaster_key() {
        return master_key;
    }
    public void setMaster_key(String master_key) {
        this.master_key = master_key;
    }
}
