package com.rafagonc.banktransfer.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import java.io.Serializable;

/**
 * Created by rafagonc on 27/03/17.
 */
public class BankTransferRequest implements Serializable {

    //getters and setters
    @NotEmpty
    @SafeHtml
    private String text;

    //constructors
    public BankTransferRequest() {
    }

    public BankTransferRequest(String text, String master_key) {
        this.text = text;
    }

    //getters and setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
