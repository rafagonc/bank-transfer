package com.rafagonc.core.models;

import com.rafagonc.core.result.BankTransfer;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by rafagonc on 27/03/17.
 */
public class BankTransferResponse implements Serializable {

    private BankTransfer transfer;
    private String method;
    private String status;

    public BankTransferResponse(BankTransfer transfer, HttpServletRequest request) {
        this.transfer = transfer;
        this.method = (request != null)? request.getMethod():null;
        this.status = "200";
    }
    public BankTransferResponse() {
    }

    //getters and setteers
    public BankTransfer getTransfer() {
        return transfer;
    }

    public void setTransfer(BankTransfer transfer) {
        this.transfer = transfer;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
