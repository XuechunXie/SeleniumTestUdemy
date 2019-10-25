package S10FindElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		/*
		//use $x("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[1]") to find the shortest path
		 
		 //**********************Ways to check all the boxes**********************************************************
		//Solution1:
		driver.findElement(By.xpath("//div[4]/input[1]")).click();
		driver.findElement(By.xpath("//div[4]/input[2]")).click();
		driver.findElement(By.xpath("//div[4]/input[3]")).click()
		driver.findElement(By.xpath("//div[4]/input[4]")).click();
		
		
		
		//Solution2: if we know the size of the checkbox
		for(int i = 1; i <= 4; i++) {
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
		}
		
		//Solution3: if we don't know the size of the checkbox
		int i = 1;
		while(isPresent(By.xpath("//div[4]/input["+i+"]"))) {
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
			i++;
		}
		*/
		
		//Solution4: recommended solution,optimize
		WebElement block = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));

		List<WebElement>  checkboxes = block.findElements(By.name("sports"));
		System.out.println("Total checkboxes are:" + checkboxes.size());
		for(WebElement checkbox: checkboxes) {
			checkbox.click();
		}
	}
	public static boolean isPresent(By by) {
		int size = driver.findElements(by).size();
		if(size == 0) {
			return false;
		}
		return true;
	}
}
