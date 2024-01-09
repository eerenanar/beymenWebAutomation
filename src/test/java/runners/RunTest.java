package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
		plugin ={"html:target/cucumber-reports.html",
                "json:target/json-reports/Pcucumber1.json"},
		features ="src/test/resources/Features",
		glue ="stepdefinitions",
		tags = ""
		)

public class RunTest extends AbstractTestNGCucumberTests {

	/*@Override
	@DataProvider (parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}*/
    // Runner class'inin body'sine hicbir kod yazmiyoruz
    // bu class icin onemli olan kullanacagimiz 2 adet notasyon

    //dryRun=false yazildiginda belirlenen tag'la etiketlenen tum scenario'lari sirasiyla calistirir
    //dryRun=true dedigimizde ise kodlari calistirmadan eksik stepler olup olmadigini kontrol eder
    // ve varsa bize eksik stepleri rapor eder
}
