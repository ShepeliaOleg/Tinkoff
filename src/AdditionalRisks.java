import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

//Дополнительные риски, покрытия, опции
public class AdditionalRisks {
	
	MainClass mainClass = new MainClass();
	private String valueCostsMin = "2 000";
	private String valueCostsMax = "20 000";
	private String costsMax = "15 000";
	private String otherValueCosts = "9 000" ;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception{
		mainClass.testMain();
		Thread.sleep(2000);
		
		
		//Страхование ваших расходов

		mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Страхование ваших расходов')]/../../td/input[contains(@type, 'checkbox')]")).click();
		Thread.sleep(3000);
		assertTrue(mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Расходы по замене дверных замков')]")).isDisplayed());
		
		String elementIdOne = mainClass.driver.findElement(By.xpath("//span/label[contains(text(),'Расходы по замене дверных замков')]/../../span")).getAttribute("id");
		String splitOne [] = elementIdOne.split(":");
		
				// Проверка минимального значения поля "Расходы по замене дверных замков"
				String costMin = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).getAttribute("value");
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).click();
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.CONTROL, Keys.HOME);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.SHIFT, Keys.END);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.BACK_SPACE, valueCostsMin);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				String actualValueCostsMin = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).getAttribute("value");
				assertEquals(costMin, actualValueCostsMin);
			
				// Проверка максимального значения поля "Расходы по замене дверных замков"
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).click();
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.CONTROL, Keys.HOME);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.SHIFT, Keys.END);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.BACK_SPACE, valueCostsMax);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				String actualValueCostsMax = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).getAttribute("value");
				assertEquals(costsMax, actualValueCostsMax);
				
				// Проверка произвольного значения поля "Расходы по замене дверных замков"
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).click();
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.CONTROL, Keys.HOME);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.SHIFT, Keys.END);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.BACK_SPACE, otherValueCosts);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				String actualValueCostsOther = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]")).getAttribute("value");
				assertEquals(otherValueCosts, actualValueCostsOther);
				
				// Проверка CheckBox "Расходы по замене дверных замков"
				WebElement elementFieldCosts = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]"));
				elementFieldCosts.isDisplayed();
				WebElement elementCheck = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitOne[4]+":"+splitOne[5]+"')][contains(@style, 'display: inline-block')]/../input[contains(@type, 'checkbox')]"));
				elementCheck.click();
				assertTrue(elementFieldCosts.isEnabled());
				Thread.sleep(2000);
				elementCheck.click();
				assertTrue(elementFieldCosts.isDisplayed());
				Thread.sleep(3000);
			
			
		//Страхование от несчастного случая
		String elementIdTwo = mainClass.driver.findElement(By.xpath("//span/label[contains(text(),'Страхование от несчастного случая')]/../../span")).getAttribute("id");
		String split [] = elementIdTwo.split(":");
		
		mainClass.driver.findElement(By.xpath("//input[contains(@name,'"+split[4]+":"+split[5]+"')][contains(@type, 'checkbox')]")).click();		
	

		Thread.sleep(3000);
	}

}
