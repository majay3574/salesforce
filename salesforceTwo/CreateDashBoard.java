package salesforceTwo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateDashBoard {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chrome_options = new ChromeOptions();
		chrome_options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(chrome_options);
		driver.manage().window().maximize();
		
		driver.get("https://qeagle-dev-ed.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
	    driver.findElement(By.id("Login")).click();
	    
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	    driver.findElement(By.xpath("//button[text()='View All']")).click();

	   
	   driver.findElement(By.xpath("//div[@class='slds-accordion__summary']")).click();
	   driver.findElement(By.xpath("//p[text()='Dashboards']/ancestor::li")).click();
	    

	   driver.findElement(By.xpath("//div[text()='New Dashboard']/ancestor::a")).click();
	   
	   driver.switchTo().defaultContent();
	   WebElement frame =driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe"));
       driver.switchTo().frame(frame);
	   driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by Ajay ");
	 

	   driver.findElement(By.id("submitBtn")).click();
	   driver.switchTo().defaultContent();

	   
	    Thread.sleep(10000);
		WebElement second = driver.findElement(By.xpath("//div[@class='dashboardContainer']//iframe"));
		driver.switchTo().frame(second);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String title = driver.getTitle();
		
		
		driver.findElement(By.xpath("//button[text()='Done']")).click();
        String title2= driver.getTitle();
		System.out.println();
        if(title.equals(title2)) {
        	System.out.println("The New Dashboard is created Successfully");
        
        }

   

	}

}
