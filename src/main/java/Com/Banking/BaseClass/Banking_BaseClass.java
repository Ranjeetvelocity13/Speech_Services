package Com.Banking.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.Banking.Configurations.ReadConfiguration;
import Com.Banking.Utilities.Banking_TestUtils;
import net.bytebuddy.utility.RandomString;

public class Banking_BaseClass {

	ReadConfiguration readconfig = new ReadConfiguration();

	public String BaseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String Password = readconfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("Browser")
	@BeforeMethod
	public void initialization(String Brwosername) throws InterruptedException {

		logger = logger.getLogger("23JulyAutomation Framework");
		PropertyConfigurator.configure("Log4j.properties");

		if (Brwosername.equals("Chrome")) { // True
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver = new ChromeDriver(); // Top open the browser
		} else if (Brwosername.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "/Users/ranjeetkendre/Downloads/msedgedriver");
			driver = new EdgeDriver();
		} else if (Brwosername.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		} else if (Brwosername.equals("IE")) {
			System.setProperty("webdriver.Ie.driver", "/Users/ranjeetkendre/Downloads/IEdriverserver");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Banking_TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(Banking_TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(BaseURL);

		Thread.sleep(3000);
		
	}

	public String getScreenshotAs(String TestCaseName) throws IOException {

		TakesScreenshot Ts = (TakesScreenshot) driver;

		File Source = Ts.getScreenshotAs(OutputType.FILE);

		String Random = RandomString.make(5);

		String Destination = System.getProperty("user.dir") + "/Screenshots/" + TestCaseName + " " + Random + ".png";

		FileUtils.copyFile(Source, new File(Destination));

		return Destination;
	}

	@AfterMethod
	public void TearDwon() throws InterruptedException {
		//Thread.sleep(2000);
		driver.close();

	}
}
