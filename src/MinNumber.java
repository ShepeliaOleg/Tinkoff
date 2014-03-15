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
		driver.get("https://c.cs18.visual.force.com/apex/complexProductCalculator?customerId=00111000008mL7yAAE&recordType=Travel"); //адрес URL
		driver.findElement(By.id("username")).sendKeys("yuliya.chyrva@customertimes.com.a2dev"); // логин
		driver.findElement(By.id("password")).sendKeys("qaz123wsx"); // пароль
		driver.findElement(By.id("Login")).click(); // вход в систему
		Thread.sleep(5000);
		
		WebElement label = driver.findElement(By.xpath("//label[contains(text(), 'Дата подачи документов на визу')]/.."));
		String split [] = label.getAttribute("id").split(":");
		WebElement field = driver.findElement(By.xpath("//input[contains(@id, '"+split[4]+"')]"));
		field.click();
		
		WebElement datePicker = driver.findElement(By.xpath("//div[contains(@id, 'datePicker')]"));
		WebElement month = driver.findElement(By.xpath("//select[contains(@title, 'Месяц')]/option[contains(text(), 'Июнь')]"));
		month.click();
		WebElement year = driver.findElement(By.xpath("//select[contains(@title, 'Год')]/option[contains(text(), '2015')]"));
		year.click();
		ArrayList<WebElement> day = (ArrayList<WebElement>)driver.findElements(By.xpath("//tr[contains(@id, 'calRow1')]/td"));
		
		for (int i = 0; i < day.size(); i++){
			System.out.println(day.get(i).getText());
		}
		day.get(4).click();
		Thread.sleep(7000);
		
	}
}
