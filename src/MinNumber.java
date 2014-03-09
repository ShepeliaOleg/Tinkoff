import static org.junit.Assert.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.seleniumemulation.IsChecked;


public class MinNumber extends MainClass{
	
	
	private String min = new String ("100 000"); 
	private String otherValue = "100 000"; // произвольное значение
	
	MainClass mainClass = new MainClass();
	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testBoundaryMinConstrElement() throws InterruptedException {
		
		mainClass.testMain()
					.findElement(By.id("phSearchInput")).sendKeys("aa");
		mainClass.driver.findElement(By.id("phSearchButton")).click();
		Thread.sleep(5000);
	 

		 
	   
	}
}
