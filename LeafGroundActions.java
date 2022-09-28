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
		Thread.sleep(2000);
		builder.dragAndDropBy(ele, 450, 160).perform();
				
		//2. Drag and drop
		WebElement sourceEle = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement targetEle = driver.findElement(By.xpath("//div[@id='form:drop_content']"));
		Thread.sleep(2000);
		builder.dragAndDrop(sourceEle, targetEle).perform();
		Thread.sleep(2000);
		
		// 3. Draggable columns
		
		//WebElement colSource = driver.findElement(By.xpath("//th[@aria-label='Category']"));
		//WebElement colTarget = driver.findElement(By.xpath("//th[@aria-label='Quantity']"));
		WebElement colSource = driver.findElement(By.xpath("//span[text()='Category']"));
		WebElement colTarget = driver.findElement(By.xpath("//span[text()='Name']"));
		
		Thread.sleep(3000);
		builder.dragAndDrop(colSource, colTarget).perform();
		Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();
		System.out.println("Confirmation message after draggable columns  :"+text2);
					
		// 4. Draggable rows
		
		WebElement rowSource = driver.findElement(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-sortable']/tr[8]"));
		WebElement rowTarget = driver.findElement(By.xpath("//tbody[@class='ui-datatable-data ui-widget-content ui-sortable']/tr[3]"));
		Thread.sleep(3000);
		builder.dragAndDrop(rowSource, rowTarget).perform();
		Thread.sleep(2000);
		
		String text = driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();
		System.out.println("Confirmation message after draggable rows  : "+text);
		
		// 5. Resize image
		
		WebElement resize = driver.findElement(By.xpath("//h4[text()='Resize Image']/following-sibling::div"));
		builder.dragAndDropBy(resize, 15,15).perform();
		Thread.sleep(3000);
		
		// 6. Progress Bar
		WebElement progressStart = driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only mr-2']"));
		builder.click(progressStart).perform();
		Thread.sleep(3000);
		
		String textProgress = driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();
		System.out.println("Confirmation message after draggable rows  : "+textProgress);
		Thread.sleep(2000);
		
		WebElement progressCancel = driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-button-outlined']"));
		builder.click(progressCancel).perform();
		Thread.sleep(2000);
		
		// 7. Range Slider
		WebElement min = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		WebElement max = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
		System.out.println(min.getLocation());
		System.out.println(max.getLocation());
		Thread.sleep(1000);
		builder.dragAndDropBy(min, 14, 0).perform();
		Thread.sleep(3000);
		builder.dragAndDropBy(max,-13, 0).perform();
		Thread.sleep(3000);

	}

}
