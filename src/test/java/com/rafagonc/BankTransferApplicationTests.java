package com.rafagonc;

import com.rafagonc.banktransfer.models.BankTransferRequest;
import com.rafagonc.banktransfer.result.BankTransfer;
import org.junit.Assert;
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
	public void test1() throws Exception {
		String text =
				"Jorge Brito Gibelli David\n" +
				"Banco do Brasil\n" +
				"Ag. 2947-5\n" +
				"Cc. 19.945-1\n" +
				"Cpf 441073838/06\n" +
				"Valor: R$ 170,00 (arredondei por causa das taxas do banco)\n" +
				"Quando depositar manda o comprovante aqui, pra ficar mais fácil o controle";


		BankTransferRequest bankTransferRequest = new BankTransferRequest(text,"");

		BankTransfer bankTransfer = application.proccess(bankTransferRequest,null).getTransfer();

		Assert.assertTrue(bankTransfer.getCpf().equals("44107383806"));
		Assert.assertTrue(bankTransfer.getAccount().equals("19945-1"));
		Assert.assertTrue(bankTransfer.getAgency().equals("2947-5"));
		Assert.assertTrue(bankTransfer.getBank().equals("Banco do Brasil"));
		Assert.assertTrue(bankTransfer.getValue().equals("170,00"));

	}

	@Test
	public void test2() throws Exception  {
		String text =
				"Paschoal Bianco Filho\n" +
						"Agência 7865-4\n" +
						"Conta 0015181-5\n" +
						"CPF 417371778-46\n" +
						"Bradesco";

		BankTransferRequest bankTransferRequest = new BankTransferRequest(text,"");

        BankTransfer bankTransfer = application.proccess(bankTransferRequest,null).getTransfer();

		Assert.assertTrue(bankTransfer.getAccount().equals("0015181-5"));
		Assert.assertTrue(bankTransfer.getCpf().equals("41737177846"));
		Assert.assertTrue(bankTransfer.getAgency().equals("7865-4"));
		Assert.assertTrue(bankTransfer.getBank().equals("Bradesco"));
	}

	@Test
	public void test3() throws Exception  {
		String text = "Banco do Brasil. Agência 1881-3. Conta corrente 14.940-3. CPF 026.701.109-16";

		BankTransferRequest bankTransferRequest = new BankTransferRequest(text,"");

        BankTransfer bankTransfer = application.proccess(bankTransferRequest,null).getTransfer();

		Assert.assertTrue(bankTransfer.getCpf().equals("02670110916"));
		Assert.assertTrue(bankTransfer.getAccount().equals("14940-3"));
		Assert.assertTrue(bankTransfer.getAgency().equals("1881-3"));
		Assert.assertTrue(bankTransfer.getBank().equals("Banco do Brasil"));

	}


	@Test
	public void test4() throws Exception  {
		String text = "Banco do BR\n" +
				"Cc: 8209-0\n" +
				"Ag: 4227-7\n" +
				"Guilherme Leao de Azevedo Soter\n" +
				"Cpf: 443.478.078-64";

		BankTransferRequest bankTransferRequest = new BankTransferRequest(text,"");

        BankTransfer bankTransfer = application.proccess(bankTransferRequest,null).getTransfer();

		Assert.assertTrue(bankTransfer.getCpf().equals("44347807864"));
		Assert.assertTrue(bankTransfer.getAccount().equals("8209-0"));
		Assert.assertTrue(bankTransfer.getAgency().equals("4227-7"));
		Assert.assertTrue(bankTransfer.getBank().equals("Banco do Brasil"));

	}

	@Test
	public void test6() throws Exception  {
		String text = "Banco do BR\n" +
				"Cc: 007104\n" +
				"Ag: 4227-7\n" +
				"Guilherme Leao de Azevedo Soter\n" +
				"Cpf: 443.478.078-64";

		BankTransferRequest bankTransferRequest = new BankTransferRequest(text,"");

        BankTransfer bankTransfer = application.proccess(bankTransferRequest,null).getTransfer();

		System.out.print(bankTransfer.getAccount());

		Assert.assertTrue(bankTransfer.getCpf().equals("44347807864"));
		Assert.assertTrue(bankTransfer.getAccount().equals("007104"));
		Assert.assertTrue(bankTransfer.getAgency().equals("4227-7"));
		Assert.assertTrue(bankTransfer.getBank().equals("Banco do Brasil"));
	}

	@Test
	public void test5() throws Exception  {
		String text = "Banco do BR\n" +
				"4227-7\n" +
				"28209-0\n" +
				"Guilherme Leao de Azevedo Soter\n" +
				"443.478.078-64";

		BankTransferRequest bankTransferRequest = new BankTransferRequest(text,"");

        BankTransfer bankTransfer = application.proccess(bankTransferRequest,null).getTransfer();

		Assert.assertTrue(bankTransfer.getAccount().equals("28209-0"));
		Assert.assertTrue(bankTransfer.getCpf().equals("44347807864"));
		Assert.assertTrue(bankTransfer.getAgency().equals("4227-7"));
		Assert.assertTrue(bankTransfer.getBank().equals("Banco do Brasil"));
	}

	@Test
	public void test7() throws Exception  {
		String text = "Banco do BR\n" +
				"4227-7\n" +
				"28209-0\n" +
				"Guilherme Leao de Azevedo Soter\n" +
				"443.478.078-64 \n" +
				"130 reais";

		BankTransferRequest bankTransferRequest = new BankTransferRequest(text,"");

		BankTransfer bankTransfer = application.proccess(bankTransferRequest,null).getTransfer();

		Assert.assertTrue(bankTransfer.getAccount().equals("28209-0"));
		Assert.assertTrue(bankTransfer.getCpf().equals("44347807864"));
		Assert.assertTrue(bankTransfer.getAgency().equals("4227-7"));
		Assert.assertTrue(bankTransfer.getBank().equals("Banco do Brasil"));
		Assert.assertTrue(bankTransfer.getValue().equals("130"));
	}

	@Test
	public void test8() throws Exception  {
		String text = "Bradesco \n" +
				"4227\n" +
				"282090\n" +
				"44347807864 \n" +
				"130,00";

		BankTransferRequest bankTransferRequest = new BankTransferRequest(text,"");

		BankTransfer bankTransfer = application.proccess(bankTransferRequest,null).getTransfer();

		Assert.assertTrue(bankTransfer.getAccount().equals("282090"));
		Assert.assertTrue(bankTransfer.getCpf().equals("44347807864"));
		Assert.assertTrue(bankTransfer.getAgency().equals("4227"));
		Assert.assertTrue(bankTransfer.getBank().equals("Bradesco"));
		Assert.assertTrue(bankTransfer.getValue().equals("130,00"));
	}

	@Test
	public void test9() throws Exception  {
		String text = "Bradesco \n" +
				"4227\n" +
				"282090\n" +
				"71.547.608/0001-89 \n" +
				"130,00";

		BankTransferRequest bankTransferRequest = new BankTransferRequest(text,"");

		BankTransfer bankTransfer = application.proccess(bankTransferRequest,null).getTransfer();

		Assert.assertTrue(bankTransfer.getAccount().equals("282090"));
		Assert.assertTrue(bankTransfer.getCnpj().equals("71547608000189"));
		Assert.assertTrue(bankTransfer.getAgency().equals("4227"));
		Assert.assertTrue(bankTransfer.getBank().equals("Bradesco"));
		Assert.assertTrue(bankTransfer.getValue().equals("130,00"));
	}



}
