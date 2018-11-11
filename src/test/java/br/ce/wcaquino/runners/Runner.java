package br.ce.wcaquino.runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//Altera-se o caminho para executar uma ou todas as features
		features = "src/test/resources/features/",
		
		//Da forma baixo ele associa todas as features como uma só.
		glue = "br.ce.wcaquino.steps",
		tags = {"@unitários"},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		//pra validar se o mapeamento está correto. É mais rápido do que uma execução inteira.
		dryRun = false,
		//caso esteja faltando criar o método de algum passo, ele fará o teste falhar.
		strict = false
		)
public class Runner {

		
		}

