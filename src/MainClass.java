import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MainClass {
	
	protected WebDriver driver;
	private String url;
	public static void main (String [] s) throws InterruptedException{
		MainClass mainClass = new MainClass();
		mainClass.testMain();
	}

	
	public WebDriver testMain() throws InterruptedException {
		driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://cs18.salesforce.com/apex/complexProductCalculator?quotationId=a0Z110000009e0UEAQ");
		driver.findElement(By.id("username")).sendKeys("yuliya.chyrva@customertimes.com.a2dev");
		driver.findElement(By.id("password")).sendKeys("qaz123wsx");
		driver.findElement(By.id("Login")).click();
		return driver;
		
	}

}
