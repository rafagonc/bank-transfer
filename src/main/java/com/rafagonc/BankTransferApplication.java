package com.rafagonc;

import com.rafagonc.core.APIUsage;
import com.rafagonc.core.BankDataProcessor;
import com.rafagonc.core.exceptions.APIDenyException;
import com.rafagonc.core.models.BankTransferRequest;
import com.rafagonc.core.models.BankTransferResponse;
import com.rafagonc.core.models.Performance;
import com.rafagonc.core.repository.APIConsumerRepository;
import com.rafagonc.core.repository.PerformanceRepository;
import com.rafagonc.core.result.BankTransfer;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired PerformanceRepository performanceRepository;
	@Autowired APIConsumerRepository apiConsumerRepository;

	@RequestMapping(value = "/" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BankTransferResponse proccess(@Valid @RequestBody BankTransferRequest bankTransferRequest, HttpServletRequest request) throws APIDenyException {

		APIUsage.track(bankTransferRequest.getMaster_key(), bankTransferRequest.getText(), apiConsumerRepository);

		BankTransfer transfer = BankDataProcessor.transfer(bankTransferRequest.getText());

		Performance.analyze(transfer, performanceRepository);

		return new BankTransferResponse(transfer, request);
	}



	//Main
	public static void main(String[] args) {
		SpringApplication.run(BankTransferApplication.class, args);


	}
}
