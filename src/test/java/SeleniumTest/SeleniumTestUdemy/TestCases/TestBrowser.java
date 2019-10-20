package SeleniumTest.SeleniumTestUdemy.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {
	public static String browser = ""; //from excel
	public static WebDriver driver;
	public static void main(String[] args) {
		/* Note1: 3 important things
		 * Whenever you are working on a selenium project, you need to guarantee 3 things:
		 * 1. Latest Selenium jar file
		 * 2. Latest Browser version
		 * 3. Latest Browser executables file
		 * Note: browser version should be consistent with executable file
		 */
			
		/*Note2: WebDriverManager 
		 * configuration of Chrome if the executable file is under the root, than
		 * setProperty can be deleted 
		 * Instead of download the executable file, we can use webdrivermanager to
		 * Automatically manage Selenium WebDriver binaries in runtime for Java
		 */
		//System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\AutomationTest\\SeleniumWorkspace\\selenium_prerequist\\executables\\chromedriver.exe" );
		
		
		/*Note3: WebDriver using to switch browsers
		*ChromeDriver driver = new ChromeDriver();
		*The reason of using WebDriver instead of ChromeDriver is
		*coz the methods that use is from WebDriver(Interface)
		*by using it we can switch to different browsers
		*/
		
		if(browser.contentEquals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.contentEquals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}else {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();	
		}
		

		driver.get("https://way2automation.com");
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close(); // close the current focus window
		driver.quit(); // the current focus window + close all the related window in same session
		
		
	}

}
