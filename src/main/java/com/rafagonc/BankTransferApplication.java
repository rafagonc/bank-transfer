package com.rafagonc;

import com.rafagonc.core.APIUsage;
import com.rafagonc.core.BankDataProcessor;
import com.rafagonc.core.models.Performance;
import com.rafagonc.core.repository.PerformanceRepository;
import com.rafagonc.core.result.BankTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BankTransferApplication {

	@Autowired PerformanceRepository performanceRepository;

	@RequestMapping("/")
	public BankTransfer proccess(@RequestParam(required = true) String text,
								 @RequestParam(required = true) String master_key) {

		APIUsage.track(master_key, text);

		BankTransfer transfer = BankDataProcessor.transfer(text);

		Performance.analyze(transfer, performanceRepository);

		return transfer;
	}

	//Main
	public static void main(String[] args) {
		SpringApplication.run(BankTransferApplication.class, args);
	}
}
