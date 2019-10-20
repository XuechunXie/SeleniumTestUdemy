package SeleniumTest.SeleniumTestUdemy.TestCases;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S9_Syncronization {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://gmail.com");
		
		driver.manage().window().maximize();
		//implicit wait
		//situation that can not handle: html has already been present in DOM, but doesn't visible on UI
		//example: password next click, ElementClickInterceptedException or ElementNotInteractableException
		//Solution: Use explicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Explicit wait declare
		//WebDriverWait wait = new WebDriverWait(driver,5);
		
		//Fluent wait, another form of explicit wait, has nothing to do with implicitwait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.withMessage("Michelle Fluent Wait Test")
				.ignoring(NoSuchElementException.class);
		//WebElement username = driver.findElement(By.id("identifierId123"));
		//username.sendKeys("michellexie684@gmail.com");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"identifierId\"]")))
				.sendKeys("michellexie684@gmail.com");
		
		WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));
		nextBtn.click();
		/*
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		//WebElement password = driver.findElement(By.name("password"));
		//password.sendKeys("fakePsw");
		
		//explicit wait call
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("fakePsw");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();;
		String errorMsg = driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]")).getText();
		System.out.println(errorMsg);
	}


}
