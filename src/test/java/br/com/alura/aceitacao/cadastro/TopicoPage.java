package br.com.alura.aceitacao.cadastro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TopicoPage {
	
	private ChromeDriver browser;

	public TopicoPage(ChromeDriver browser) {
		this.browser = browser;
	}
	
	public CadastroPage clicarNoLinkDeCadastro() {
		WebElement linkDeCadastro = browser.findElement(By.linkText("CADASTRE-SE"));
		linkDeCadastro.click();
		
		return new CadastroPage(browser);
	}
	
}
