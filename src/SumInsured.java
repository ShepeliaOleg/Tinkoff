import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class SumInsured {

	MainClass mainClass = new MainClass();
	private String max = "10 000 000";
	private String min = "300 000";
	private String xpath = "//span/label[contains(text(),'Страховая сумма (без НС)')]/../../span";
	private String otherValueMax = "100 000 000";
	private String otherValueMin = "20";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
	}

	@Test
	public void testMax() throws InterruptedException {
		
		mainClass.testMain();
		System.out.println(mainClass.driver.getCurrentUrl().toString());
		
		String elementId = mainClass.driver.findElement(By.xpath("//span/label[contains(text(),'Страховая сумма (без НС)')]/../../span")).getAttribute("id");
		
		String split [] = elementId.split(":");
				
		// Проверка максимального значения
		mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.CONTROL, Keys.HOME);
		mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.SHIFT, Keys.END);
		mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.BACK_SPACE, otherValueMax, Keys.ENTER);
		mainClass.driver.findElement(By.xpath("//label [contains(text(),'Страховая сумма по покрытиям')]")).click();
		Thread.sleep(2000);
		String actualValue = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).getAttribute("value");
		String actualValueSpan = mainClass.driver.findElement(By.xpath("//label [contains(text(),'Страховая сумма по')]/../../td/span")).getText();
		System.out.println(actualValue);
		System.out.println(actualValueSpan);
		Assert.assertEquals(max, actualValue); // проверка максимального значения поля "Страховая сумма (без НДС)"
		Assert.assertEquals(actualValue, actualValueSpan); // проверка значения поля "Страховая сумма по покрытиям", которое равное значению поля "Страховая сумма (без НС)"
				
		Thread.sleep(3000);
		//----------------------------------------------------------------------------
		
		// Проверка минимального значения значения
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.CONTROL, Keys.HOME);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.SHIFT, Keys.END);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.BACK_SPACE, otherValueMin, Keys.ENTER);
				mainClass.driver.findElement(By.xpath("//label [contains(text(),'Страховая сумма по')]/../../td/span")).click();
				Thread.sleep(2000);
				
				String actualValueMin = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).getAttribute("value");
				String actualValueSpanMin = mainClass.driver.findElement(By.xpath("//label [contains(text(),'Страховая сумма по')]/../../td/span")).getText();
				System.out.println(actualValueMin);
				System.out.println(actualValueSpanMin);
				Assert.assertEquals(min, actualValueMin); // проверка минимального значения поля "Страховая сумма (без НДС)"
				Assert.assertEquals(actualValueMin, actualValueSpanMin); // проверка значения поля "Страховая сумма по покрытиям", которое равное значению поля "Страховая сумма (без НС)"
						
				Thread.sleep(3000);
		
		
	

	
	}

}
