package tek.bdd.guardians.base;

import java.time.Duration;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import tek.bdd.guardians.config.ChromeBrowser;
import tek.bdd.guardians.config.Browser;
import tek.bdd.guardians.config.ChromeHeadless;
import tek.bdd.guardians.config.EdgeBrowser;
import tek.bdd.guardians.config.FireFoxBrowser;
import tek.bdd.guardians.utilities.ReadYamalFiles;

public class BaseSetup {

	private static WebDriver webDriver;
	private final ReadYamalFiles environmentVariables;
	public static Logger logger;

	public BaseSetup() {
//	we need the path to env_config.yml file and store it in a String variable
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\env_config.yml";

//	we need the path to the log4j.properties file and store it in a String variable
		String log4jPath = System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.properties";
//	we get an instacne of the project configuration file (env_config file)
		try {
			environmentVariables = ReadYamalFiles.getInstance(filePath);
		} catch (Exception e) {

			System.out.println("Failed for Load environment context. check possible file path errors");
			throw new RuntimeException("Failed to load env_config file: " + e.getMessage());
		}
//	initialize our logger
//	configure our log4j using the PropertyConfigurator class
		logger = logger.getLogger("logger_file");
		PropertyConfigurator.configure(log4jPath);

	}
//	This method will return an instance of WebDriver, 
//	it is same as in selenium we used the reference to WebDriver instance (driver)

	public WebDriver getDriver() {

		return webDriver;
	}

//	to get the environment configuration from the env_config file and setup browser 
//	when setting up browser, make sure to import your browser interface and browser classes
//	from the config package 
	public void setupBrowser() {
		HashMap uiProperties = environmentVariables.getYamalProperty("ui");
		String url = uiProperties.get("url").toString().toLowerCase();
		Browser browser;

		switch (uiProperties.get("browser").toString().toLowerCase()) {

		case "chrome":

			if ((boolean) uiProperties.get("headless")) {
				browser = new ChromeHeadless();
			} else {
				browser = new ChromeBrowser();

			}
			webDriver = browser.openBrowser(url);
			break;

		case "firefox":

			browser = new FireFoxBrowser();
			webDriver = browser.openBrowser(url);
			break;

		case "edge":
			browser = new EdgeBrowser();
			webDriver = browser.openBrowser(url);
			break;

		default:
			throw new RuntimeException("Browser name and config file did not match any of the cases");

		}

		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	}

//	close the browser(s)
	public void quitBrowser() {

		if (webDriver != null)
			webDriver.quit();
	}

}
