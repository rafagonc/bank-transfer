package com.rafagonc;

import com.rafagonc.banktransfer.BankTransferFactory;
import com.rafagonc.banktransfer.models.BankTransferRequest;
import com.rafagonc.banktransfer.models.BankTransferResponse;
import com.rafagonc.banktransfer.result.BankTransfer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class BankTransferApplication {


	@RequestMapping(value = "/" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BankTransferResponse proccess(@Valid @RequestBody BankTransferRequest bankTransferRequest, HttpServletRequest request) throws Exception {
		BankTransfer transfer = BankTransferFactory.transfer(bankTransferRequest.getText());
		return new BankTransferResponse(transfer, request);
	}



	//Main
	public static void main(String[] args) {
		SpringApplication.run(BankTransferApplication.class, args);
	}
}
