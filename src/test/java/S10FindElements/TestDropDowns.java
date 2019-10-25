package S10FindElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropDowns {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.get("https://www.wikipedia.org");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//use $$("[name='country']") in window console to see if the name is unique
		//The below code works for http://way2automation.com/way2auto_jquery/index.php
		//driver.findElement(By.name("country")).sendKeys("Hong Kong");
		
		////but not working for https://www.wikipedia.org/ sometimes,
		//ex if we send Eesti, it will select ES, instead of ET
		//Solution: use class Select
		//driver.findElement(By.id("searchLanguage")).sendKeys("Eesti");
		
		Select select = new Select(driver.findElement(By.id("searchLanguage")));
		//Select have 3 select functions:selectByVisibleText(), selectByValue();selectByIndex().
		select.selectByVisibleText("Eesti");
		
		//for some language we can't type, we use selectByValue()/selectByIndex()
		select.selectByValue("fa");
		select.selectByIndex(0);
		
		/******************************************************************************
		 * Print out all the lists' elements
		 */
		
		List<WebElement> values = driver.findElements(By.tagName("option"));
		//use $$("options") in window console to see how many they are
		System.out.println("Total values are: "+values.size());
		
		for(int i = 0; i < values.size(); i++) {
			WebElement webElem = values.get(i);
			String lang = webElem.getAttribute("lang");
			String value = webElem.getAttribute("value");
			String text = webElem.getText();
			System.out.println("value = " + value+",lang = "+lang+", text = "+text);
		}
		

		/******************************************************************************
		 * Print out all the links on the page
		 */
		System.out.println("**********************Print PAGE Links***************************");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement link: links) {
			System.out.println(link.getText()+"--URL IS---"+link.getAttribute("herf"));
		}
		
		/******************************************************************************
		 * Print out the links under a specific block
		 * You can use the same way to deal with dropdown list
		 */
		System.out.println("**********************Print BLOCK Links***************************");
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[8]/div[3]"));
		List<WebElement> blockLinks = block.findElements(By.tagName("a"));
		System.out.println(blockLinks.size());
		for(WebElement blockLink: blockLinks) {
			
			System.out.println(blockLink.getText()+"--URL IS---"+blockLink.getAttribute("herf"));
		}
	}

}
