package SeleniumThree;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBrowser {

	public static void main(String[] args) {
		/*
		 * Whenever you are working on a selenium project, you need to guarantee 3 things:
		 * 1. Latest Selenium jar file
		 * 2. Latest Browser version
		 * 3. Latest Browser executable file
		 * Note: browser version should be consistent with executable file
		 */
		
		/*
		//configuaration of Firefox
		System.setProperty("webdriver.gecko.driver", "D:\\WorkSpace\\AutomationTest\\SeleniumWorkspace\\selenium_prerequist\\executables\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://way2automation.com");
		
		
		
		//configuration of Chrome
		System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\AutomationTest\\SeleniumWorkspace\\selenium_prerequist\\executables\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://way2automation.com");
		*/
		
		/* Download 32 bit windows IE instead of 64 bit windows IE, coz the latest is very slow
		 * 1.For error about protected mode, open IE setting-> Internet options-> security-> Enable Protected mode should all be enabled
		 * 2.For browser zoom level, Go to IE settings -> zoom--> select 100%
		 * instead of set this manually, we can use DesiredCapabilities as well 
		 */
		
		/*
		//used to adjust the explore settings, can be use in IE, Firefox,Chrome...
		//passed the capabilities into the web driver constructor
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
		*/
		
	
		//System.setProperty("webdriver.ie.driver", "D:\\WorkSpace\\AutomationTest\\SeleniumWorkspace\\selenium_prerequist\\executables\\IEDriverServer.exe");
		//InternetExplorerDriver driver = new InternetExplorerDriver(/*capabilities*/);
		
		//driver.get("https://way2automation.com");
		
		/*
		System.setProperty("webdriver.edge.driver", "D:\\WorkSpace\\AutomationTest\\SeleniumWorkspace\\selenium_prerequist\\executables\\MicrosoftWebDriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://way2automation.com");
		*/
		
		//Configuration of opera
		//usually is not working on windows, but works fine on Mac
		System.setProperty("webdriver.opera.driver", "D:\\WorkSpace\\AutomationTest\\SeleniumWorkspace\\selenium_prerequist\\executables\\operadriver.exe");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		OperaOptions options = new OperaOptions();
		options.setBinary("C:\\Users\\Xuechun Xie\\AppData\\Local\\Programs\\Opera\\64.0.3417.54\\opera.exe");
		capabilities.setCapability(OperaOptions.CAPABILITY, options);
		
		OperaDriver driver = new OperaDriver(options);
		driver.get("https://way2automation.com");		
	}

}
