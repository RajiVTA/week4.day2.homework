package week4.day2.homework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLTags {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	
		//	1. Launch https://html.com/tags/table/
		
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Get the count of number of rows
		
		List<WebElement> tot = driver.findElements(By.tagName("tr"));
		
		int size = tot.size();
		System.out.println("Total number of rows :"+size);
		
		// 3. Get the count of number of columns
		List<WebElement> tot1 = driver.findElements(By.tagName("th"));
		
		int size1 = tot1.size();
		System.out.println("Total number of columns :"+size1);
		
	

	}

}
