package br.com.alura.aceitacao.cadastro;

import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	private ChromeDriver browser;

	public HomePage(ChromeDriver browser) {
		this.browser = browser;
	}
	
	public boolean contem(String nome) {
		return browser.getPageSource().contains(nome);
	}
		
}
