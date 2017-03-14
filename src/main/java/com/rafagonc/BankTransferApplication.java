package com.rafagonc;

import com.rafagonc.core.BankDataProcessor;
import com.rafagonc.core.result.BankTransfer;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BankTransferApplication {

	@RequestMapping("/")
	public BankTransfer proccess(@RequestParam(required = true) String text) {
		return new BankDataProcessor(text).transfer();
	}

	//Main
	public static void main(String[] args) {
		SpringApplication.run(BankTransferApplication.class, args);
	}
}
