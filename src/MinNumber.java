import static org.junit.Assert.*;

import java.awt.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.openqa.selenium.support.ui.Select;

public class MinNumber extends MainClass {

	private String min = new String("100 000");
	private String otherValue = "100 000"; //


	MainClass mainClass = new MainClass();
	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testBoundaryMinConstrElement() throws Exception {

		mainClass.login("https://cs18.salesforce.com/console", 
				"yuliya.chyrva@customertimes.com.a2dev", "qaz123wsx");
		Thread.sleep(7000);
		
		ArrayList<WebElement> e = (ArrayList<WebElement>) mainClass.driver.findElements(By.xpath("//button[contains(@class, '')]"));
		for (int i = 0; i < e.size(); i++){
			System.out.println(e.get(i).getAttribute("class").toString());
		}
		
		WebElement b = mainClass.driver.findElement(By.xpath("//em[contains(@class, 'x-btn-split')]/button"));
		b.click();
	}
}
