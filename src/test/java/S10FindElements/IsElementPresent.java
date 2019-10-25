package S10FindElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsElementPresent {
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//isDisplayed() means if the element show on the page, checking the visibility
		boolean isDisplay = driver.findElement(By.id("searchLanguage")).isDisplayed();
		System.out.println(isDisplay);
		
		//isPresent(), no this method in WebDriver, means if the element present in HTML DOM,may or may not display on page
		//element exist in HTML DOM
		boolean isPresent = isPresent(By.xpath("//*[@id=\"searchLanguage\"]"));
		System.out.println(isPresent);
		
		//Element doesn't exist in HTML DOM
		boolean isNotPresent = isPresent(By.xpath("//*[@id=\"searchLanguageIAMNOTEXIST\"]"));
		System.out.println(isNotPresent);
	}
	
	//use only xpath to search
	//public static boolean isPresent(String locator) {
	//use all kinds of locators
	public static boolean isPresent(By by) {
		/*
		try {
			//driver.findElement(By.xpath(locator));
			 driver.findElement(by);
			return true;
		}catch(Throwable t) {
			return false;
		}*/
		
		//int size = driver.findElements(By.xpath(locator)).size();
		int size = driver.findElements(by).size();
		if(size == 0) {
			return false;
		}else {
			return true;
		}
	}

}
