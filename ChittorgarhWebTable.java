package week4.day2.homework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

		System.out.println("SECURITY NAMES IN WEB TABLE");
		ArrayList<String> row1 = new ArrayList<String>();
		for(int i=2;i<rowSize;i++)
		{
			
			String securityValue = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr[" + i +"]/td[3]")).getText();	
		
			System.out.println(securityValue);
			row1.add(securityValue);
		}
	
				
		//5. Ensure whether there are duplicate Security names
		System.out.println();
		System.out.println("DUPLICATE SECURITY NAMES :");
		boolean flag=false;
		int size5 = row1.size();
		System.out.println(row1.size());
		
		for (int j=0;j<size5;j++) 
		{
		    for (int k=j+1;k<size5;k++)
		    {
		        if (row1.get(k).equals(row1.get(j)))
		        { 
		        	System.out.println(row1.get(k));
		        	System.out.println(row1.get(j));
		        	 flag=true;
		        	 break;
		           
		        }
		    }
		}
		if(flag==true)
			System.out.println(" Duplicates are present");
		else
			System.out.println("No duplicates present");
	
	}

}
