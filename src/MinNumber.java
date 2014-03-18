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

	WebDriver driver;
	
	@After
	public void tearDown() throws Exception {
	driver.quit();
	}

	@Test
	public void testBoundaryMinConstrElement() throws InterruptedException, ParseException {

		driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://cs18.salesforce.com/apex/complexProductCalculator?quotationId=a0Z11000000A7obEAC"); //адрес URL
		driver.findElement(By.xpath("//input[contains(@id, 'username')]")).sendKeys("yuliya.chyrva@customertimes.com.a2dev"); // логин
		driver.findElement(By.xpath("//input[contains(@id, 'password')]")).sendKeys("qaz123wsx"); // пароль
		driver.findElement(By.id("Login")).click(); // вход в систему
		Thread.sleep(5000);
		
		WebElement select = driver
				.findElement(By
						.xpath("//label[contains(text(), 'Аренда?')]/../../td/select/option[contains(text(), 'Сдаю')]"));
		select.click();
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.xpath("//label[contains(text(), 'Страхование ваших расходов')]/../following-sibling::td/input[contains(@type, 'checkbox')]"));
		element.click();
		Thread.sleep(6000);
		String element3 = driver.findElement(By.xpath("//span/label[contains(text(),'Расходы при потере арендной платы')]/../../span")).getAttribute("id");
		
		String[] split = element3.split(":");
		WebElement element4 = driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]"));
		element4.isDisplayed();
		element4.sendKeys(Keys.chord(Keys.CONTROL, "a"), "30000");
	}
}
