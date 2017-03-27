package com.rafagonc;

import com.rafagonc.core.APIUsage;
import com.rafagonc.core.BankDataProcessor;
import com.rafagonc.core.BankTransferRequest;
import com.rafagonc.core.models.Performance;
import com.rafagonc.core.repository.PerformanceRepository;
import com.rafagonc.core.result.BankTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class BankTransferApplication {

	@Autowired PerformanceRepository performanceRepository;

	@RequestMapping(value = "/" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BankTransfer proccess(@Valid @RequestBody BankTransferRequest request) {

		APIUsage.track(request.getMaster_key(), request.getText());

		BankTransfer transfer = BankDataProcessor.transfer(request.getText());

		Performance.analyze(transfer, performanceRepository);

		return transfer;
	}

	//Main
	public static void main(String[] args) {
		SpringApplication.run(BankTransferApplication.class, args);
	}
}
