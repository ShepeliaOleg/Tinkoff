

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

// Внутренняя отделка
public class Trim {
	
	MainClass mainClass = new MainClass();
	private String max = "2 000 000";
	private String otherValueMax = "6 000 000";
	private String min = "50 000";
	private String otherValueMin = "9 000";
	private String otherValue = "352 000";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception{
		mainClass.login("https://cs18.salesforce.com/apex/complexProductCalculator?quotationId=a0Z110000009e0UEAQ", "yuliya.chyrva@customertimes.com.a2dev", "qaz123wsx");
		
		String elementId = mainClass.driver.findElement(By.xpath("//span/label[contains(text(),'Внутренняя отделка')]/../../span")).getAttribute("id");
		
		String split [] = elementId.split(":");
		
		// Проверка максимального значения
		mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.CONTROL, Keys.HOME);
		mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.SHIFT, Keys.END);
		mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.BACK_SPACE, otherValueMax, Keys.ENTER);
		Thread.sleep(2000);
		
		String actualValueMax = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).getAttribute("value");
		assertEquals(max, actualValueMax);
		Thread.sleep(3000);
		//------------------------------------------------------------
		
		// Проверка минимального значения
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.CONTROL, Keys.HOME);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.SHIFT, Keys.END);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]"+ "")).sendKeys(Keys.BACK_SPACE, otherValueMin);
				Thread.sleep(2000);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]"+ "")).sendKeys(Keys.ENTER);
				String actualValueMin = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).getAttribute("value");
				assertEquals(min, actualValueMin);
				Thread.sleep(3000);
		//-----------------------------------------------------------------------------------
		
		// Проверка произвольного значения
					mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.CONTROL, Keys.HOME);
					mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.SHIFT, Keys.END);
					mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).sendKeys(Keys.BACK_SPACE, otherValue, Keys.ENTER);
					Thread.sleep(2000);
					String actualValue = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).getAttribute("value");
					assertEquals(otherValue, actualValue);
					Thread.sleep(3000);
		//----------------------------------------------------------------------------------------
					
		// Проверка CheckBox
							mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]/../input[contains(@type,'checkbox')]")).click();
							Thread.sleep(1000);
							assertTrue(mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).isEnabled());
							Thread.sleep(1000);
							mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]/../input[contains(@type,'checkbox')]")).click();
							assertTrue(mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]")).isDisplayed());
							assertEquals(otherValue, actualValue);
	}

}
