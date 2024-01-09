package stepdefinitions;

import java.io.IOException;
import java.time.Duration;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import utilities.Driver;

@ExtendWith(TestResultLogger.class)
public class Hooks {
	@Before
	public  void setUp() {
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Driver.getDriver().get("https://beymen.com.tr");
	}

	@After
	public  void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			pages.BasePage.getScreenshot(scenario.getName());
		}
		Driver.closeDriver();
	}
}
