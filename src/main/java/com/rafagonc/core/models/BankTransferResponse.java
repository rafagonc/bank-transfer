package com.rafagonc.core.models;

import com.rafagonc.core.result.BankTransfer;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by rafagonc on 27/03/17.
 */
public class BankTransferResponse implements Serializable {

    private BankTransfer transfer;
    private String path;
    private String status;

    public BankTransferResponse(BankTransfer transfer, HttpServletRequest request) {
        this.transfer = transfer;
        this.path = (request != null)? request.getPathInfo():null;
        this.status = 200;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
