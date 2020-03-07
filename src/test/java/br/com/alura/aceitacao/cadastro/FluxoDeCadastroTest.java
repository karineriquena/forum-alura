package br.com.alura.aceitacao.cadastro;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

public class FluxoDeCadastroTest {
	
	ChromeDriver browser;
	
	@Before
	public void antes() {
		System.setProperty("webdriver.chrome.driver","./chromedriver");
		browser = new ChromeDriver();
	}
	
	@After
	public void depois() {
		browser.close();
	}

	@Ignore
	@Test
	public void deve_ser_capaz_de_criar_uma_conta() {
		browser.get("http://localhost:8080/alura-forum/");
		
		Faker faker = new Faker();
		String nome = faker.superhero().name();
		String email = faker.internet().emailAddress();
		String senha = faker.internet().password();
		
		TopicoPage topicoPage = new TopicoPage(browser);
		CadastroPage cadastroPage = topicoPage.clicarNoLinkDeCadastro();
		
		cadastroPage.preencherFormulario(nome, email, senha);
		
		HomePage homePage = cadastroPage.submeterCadastro();
		
		Assert.assertTrue(homePage.contem(nome));
	}

}
