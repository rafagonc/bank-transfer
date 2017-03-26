package com.rafagonc;

import com.rafagonc.core.result.BankTransfer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankTransferApplicationTests {

	@Autowired BankTransferApplication application;

	@Test
	public void test1() {
		String text =
				"Jorge Brito Gibelli David\n" +
				"Banco do Brasil\n" +
				"Ag. 2947-5\n" +
				"Cc. 19.945-1\n" +
				"Cpf 441073838/06\n" +
				"Valor: R$ 170,00 (arredondei por causa das taxas do banco)\n" +
				"Quando depositar manda o comprovante aqui, pra ficar mais fácil o controle";

		BankTransfer bankTransfer = application.proccess(text,"");

		assert bankTransfer.getCpf().equals("44107383806");
		assert bankTransfer.getAccount().equals("19945-1");
		assert bankTransfer.getAgency().equals("2947-5");
		assert bankTransfer.getBank().equals("Banco do Brasil");
		assert bankTransfer.getValue().equals("170,00");
	}

	@Test
	public void test2() {
		String text =
				"Paschoal Bianco Filho\n" +
						"Agência 7865-4\n" +
						"Conta 0015181-5\n" +
						"CPF 417371778-46\n" +
						"Bradesco";

		BankTransfer bankTransfer = application.proccess(text,"");
		assert bankTransfer.getCpf().equals("41737177846");
		assert bankTransfer.getAccount().equals("0015181-5");
		assert bankTransfer.getAgency().equals("7865-4");
		assert bankTransfer.getBank().equals("Bradesco");
	}

	@Test
	public void test3() {
		String text = "Banco do Brasil. Agência 1881-3. Conta corrente 14.940-3. CPF 026.701.109-16";

		BankTransfer bankTransfer = application.proccess(text,"");

		assert bankTransfer.getCpf().equals("02670110916");
		assert bankTransfer.getAccount().equals("14940-3");
		assert bankTransfer.getAgency().equals("1881-3");
		assert bankTransfer.getBank().equals("Banco do Brasil");

	}


	@Test
	public void test4() {
		String text = "Banco do BR\n" +
				"Cc: 8209-0\n" +
				"Ag: 4227-7\n" +
				"Guilherme Leao de Azevedo Soter\n" +
				"Cpf: 443.478.078-64";

		BankTransfer bankTransfer = application.proccess(text,"");

		assert bankTransfer.getCpf().equals("44347807864");
		assert bankTransfer.getAccount().equals("8209-0");
		assert bankTransfer.getAgency().equals("4227-7");
		assert bankTransfer.getBank().equals("Banco do Brasil");
	}

	@Test
	public void test5() {
		String text = "Banco do BR\n" +
				"4227-7\n" +
				"28209-0\n" +
				"Guilherme Leao de Azevedo Soter\n" +
				"443.478.078-64";

		BankTransfer bankTransfer = application.proccess(text,"");

		assert bankTransfer.getCpf().equals("44347807864");
		assert bankTransfer.getAccount().equals("28209-0");
		assert bankTransfer.getAgency().equals("4227-7");
		assert bankTransfer.getBank().equals("Banco do Brasil");
	}

}
