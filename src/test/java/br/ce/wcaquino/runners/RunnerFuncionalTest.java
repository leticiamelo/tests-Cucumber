package br.ce.wcaquino.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//Altera-se o caminho para executar uma ou todas as features
		features = "src/test/resources/features/",
		
		//Da forma baixo ele associa todas as features como uma só.
		glue = "br.ce.wcaquino.steps",
		tags = {"@funcionais"},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		//pra validar se o mapeamento está correto. É mais rápido do que uma execução inteira.
		dryRun = true,
		//caso esteja faltando criar o método de algum passo, ele fará o teste falhar.
		strict = false
		)
public class RunnerFuncionalTest {

		@BeforeClass
		
		public static void reset(){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\erica.castro\\Documents\\Pessoais\\Curso de Selenium\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    driver.get("http://srbarriga.herokuapp.com");
		    driver.findElement(By.id("email")).sendKeys("erica.lety@hotmail.com");
		    driver.findElement(By.id("senha")).sendKeys("123");
		    driver.findElement(By.tagName("button")).click();
		    driver.findElement(By.linkText("reset")).click();
		    driver.quit();
		}
}
