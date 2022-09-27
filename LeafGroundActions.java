package week4.day2.homework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundActions {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder=new Actions (driver);
		
		
		// 1. Drag me Around
		WebElement ele = driver.findElement(By.xpath("//div[@id='form:conpnl']"));
		Thread.sleep(4000);
		builder.dragAndDropBy(ele, 450, 160).perform();
				
		//2. Drag and drop
		WebElement sourceEle = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement targetEle = driver.findElement(By.xpath("//div[@id='form:drop_content']"));
		Thread.sleep(5000);
		builder.dragAndDrop(sourceEle, targetEle).perform();
		

	}

}
