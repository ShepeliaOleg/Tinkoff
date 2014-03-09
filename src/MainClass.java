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
	

	
	public WebDriver testMain() {
		driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		driver.get("https://c.cs18.visual.force.com/apex/complexProductCalculator?quotationId=a0Z110000009JLOEA2");
		driver.findElement(By.id("username")).sendKeys("yuliya.chyrva@customertimes.com.a2dev");
		driver.findElement(By.id("password")).sendKeys("qaz123wsx");
		driver.findElement(By.id("Login")).click();
		return driver;
		
	}

}
