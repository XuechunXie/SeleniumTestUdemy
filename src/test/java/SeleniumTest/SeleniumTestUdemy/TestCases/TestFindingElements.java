package SeleniumTest.SeleniumTestUdemy.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {

	public static void main(String[] args) {
		/*Note1: 8 useful locators
		 * id,name,cssSelector,xpath,className,tagName,linkText,partialLinkText
		 * The most frequently used one are cssSelector and xpath
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
 
		WebElement username = driver.findElement(By.id("identifierId"));
		username.sendKeys("michellexie684@gmail.com");
		WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));
		nextBtn.click();
	}

}
