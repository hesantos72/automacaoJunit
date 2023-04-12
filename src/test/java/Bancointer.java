import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bancointer {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		// codigo para indicar o navegar
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	
		//comando para chamar o driver dentro do meu Before
		driver =new ChromeDriver();
		driver.get("https://www.4devs.com.br/gerador_de_pessoas");
		driver.manage() .window() .maximize();
		driver.findElement(By.cssSelector("#bt_gerar_pessoa")).click();
		Thread.sleep(1000);
		String nome = driver.findElement(By.id("nome")).getText();
		System.out.println(nome);
		String celular = driver.findElement(By.id("celular")).getText();
		System.out.println(celular);
		String email = driver.findElement(By.id("email")).getText();
		System.out.println(email);
		String cpf = driver.findElement(By.id("cpf")).getText();
		System.out.println(cpf);
		String dataNascimento = driver.findElement(By.id("data_nasc")).getText();
		System.out.println(dataNascimento);
	
		
		
	
		
	    driver.get("https://www.bancointer.com.br/");
		driver.manage() .window() .maximize();
		
		driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
		driver.findElement(By.cssSelector("#gatsby-focus-wrapper > div > header > section > div > div > div > div > div.styles__LogoNIcons-sc-1gbjc3e-6.gjJzHM > div.styles__SearchNFlags-sc-1gbjc3e-8.yVPnY > div.styles__ButtonsWrapper-sc-1gbjc3e-9.PKrxs > button:nth-child(1)")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("nome")).sendKeys(nome);
		driver.findElement(By.id("celular")).sendKeys(celular);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("cpf")).sendKeys(cpf);
		driver.findElement(By.id("dataNascimento")).sendKeys(dataNascimento);
		driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div:nth-child(6) > div > label")).click();
	    driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div.col-12.text-center > button")).click();
	}
	
	

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		String texto = driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center.sent > div > p")).getText();
	    System.out.println(texto);
	    assertEquals(texto,"Prontinho! Recebemos os seus dados.");
	}

}