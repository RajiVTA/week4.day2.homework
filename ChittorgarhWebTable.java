package week4.day2.homework;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittorgarhWebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	
		//	1. Launch https:https://www.chittorgarh.com/
		
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		// 2. Click on Stock Market
		driver.findElement(By.xpath("//a[@id='navbtn_stockmarket']")).click();
		
		//3. Click on NSE bulk Deals
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
		//4. Get all the Security names
		
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']/tbody/tr"));
		int rowSize = row.size();
		System.out.println("Total number of rows :"+rowSize);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//flashcard-close[@role='button']")).click();

		for(int i=1;i<rowSize;i++)
		{
			
			String securityValue = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr[" + i +"]/td[3]")).getText();	
		
			System.out.println(securityValue);
		}
		
		//5. Ensure whether there are duplicate Security names
		
		Set<String>Security=new LinkedHashSet<String>();
		for(String s:Security)
		{
			Security.add(s);
		}
		int securitySize=Security.size();
		if(rowSize==securitySize)
			System.out.println("No duplicates present");
		else
			System.out.println("Duplicates are present");
	}

}
