import static org.junit.Assert.*;

import javax.swing.RepaintManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

//Дополнительные риски, покрытия, опции
public class AdditionalRisks {
	
	MainClass mainClass = new MainClass();
	
	// переменные для проверки "Страхование ваших расходов"
	private String valueCostsMin = "2 000";
	private String valueCostsMax = "20 000";
	private String costsMax = "15 000";
	private String otherValueCosts = "9 000" ;
	
	//переменные для проверки "Страхование от несчастного случая"
	private String valueAccidentMin = "50 000";
	private String accidentMax = "2 000 000";
	private String valueAccidentMax = "15 550 000";
	private String otherValueAccident = "1 550 000";
	
	//переменные для проверки "Страхование от несчастного случая"
	private String valueResponsibilityMin = "25 001";
	private String valueResponsibilityMax = "1 150 000";
	private String responsibilityMax = "1 000 000";
	private String otherValueResponsibility = "680 000";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
	//mainClass.driver.quit();
	}

	@Test
	public void test() throws Exception{
		mainClass.testLogin();
	
		Thread.sleep(2000);
		
		
		//Страхование ваших расходов

		mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Страхование ваших расходов')]/../../td/input[contains(@type, 'checkbox')]")).click();
		Thread.sleep(3000);
		assertTrue(mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Расходы по замене дверных замков')]")).isDisplayed());
		
		String labelIdCosts = mainClass.driver.findElement(By.xpath("//span/label[contains(text(),'Расходы по замене дверных замков')]/../../span")).getAttribute("id");
		String splitCosts [] = labelIdCosts.split(":");
		
				// Проверка минимального значения поля "Расходы по замене дверных замков"
				String costMin = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).getAttribute("value");
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).click();
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.CONTROL, Keys.HOME);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.SHIFT, Keys.END);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.BACK_SPACE, valueCostsMin);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				String actualValueCostsMin = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).getAttribute("value");
				assertEquals(costMin, actualValueCostsMin);
			
				// Проверка максимального значения поля "Расходы по замене дверных замков"
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).click();
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.CONTROL, Keys.HOME);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.SHIFT, Keys.END);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.BACK_SPACE, valueCostsMax);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				String actualValueCostsMax = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).getAttribute("value");
				assertEquals(costsMax, actualValueCostsMax);
				
				// Проверка произвольного значения поля "Расходы по замене дверных замков"
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).click();
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.CONTROL, Keys.HOME);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.SHIFT, Keys.END);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.BACK_SPACE, otherValueCosts);
				mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				String actualValueCostsOther = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]")).getAttribute("value");
				assertEquals(otherValueCosts, actualValueCostsOther);
				
				// Проверка CheckBox "Расходы по замене дверных замков"
				WebElement elementFieldCosts = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]"));
				elementFieldCosts.isDisplayed();
				WebElement elementCheckCosts = mainClass.driver.findElement(By.xpath("//input[contains(@id,'"+splitCosts[4]+":"+splitCosts[5]+"')][contains(@style, 'display: inline-block')]/../input[contains(@type, 'checkbox')]"));
				elementCheckCosts.click();
				assertTrue(elementFieldCosts.isEnabled());
				Thread.sleep(2000);
				elementCheckCosts.click();
				assertTrue(elementFieldCosts.isDisplayed());
				Thread.sleep(3000);
			
			
		//Страхование от несчастного случая
		String labelIdAccident = mainClass.driver.findElement(By.xpath("//span/label[contains(text(),'Страхование от несчастного случая')]/../../span")).getAttribute("id");
		String splitAccident [] = labelIdAccident.split(":");
		
		WebElement elementCheckboxAccident = mainClass.driver.findElement(By.xpath("//input[contains(@name,'"+splitAccident[4]+":"+splitAccident[5]+"')][contains(@type, 'checkbox')]"));
		WebElement accident = mainClass.driver.findElement(By.xpath("//input[contains(@name,'"+splitAccident[4]+":"+splitAccident[5]+"')][contains(@id,'"+splitAccident[4]+":"+splitAccident[5]+"')]"));
		elementCheckboxAccident.click();
		
				// Проверка минимального значения поля "Страхование от несчастного случая"
				String accidentMin = accident.getAttribute("value");
				accident.sendKeys(Keys.chord(Keys.CONTROL, "a"), valueAccidentMin);
				accident.sendKeys(Keys.ENTER);
				assertEquals(accidentMin, accident.getAttribute("value")); // проверка на равенство минимального значения с текущим
				
				// Проверка максимального значения поля "Страхование от несчастного случая" 
				accident.sendKeys(Keys.chord(Keys.CONTROL, "a"), valueAccidentMax);
				accident.sendKeys(Keys.ENTER);
				assertEquals(accidentMax, accident.getAttribute("value"));
				
				// Проверка произвольного значения поля "Страхование от несчастного случая" 
				accident.sendKeys(Keys.chord(Keys.CONTROL, "a"), otherValueAccident);
				accident.sendKeys(Keys.ENTER);
				assertEquals(otherValueAccident, accident.getAttribute("value"));
				
				// Проверка CheckBox "Страхование от несчастного случая"
				elementCheckboxAccident.click();
				assertTrue(accident.isEnabled());
				elementCheckboxAccident.click();
				assertTrue(accident.isDisplayed());
				
		// Гражданская ответственность при эксплуатации
		String labelIdResponsibility = mainClass.driver.findElement(By.xpath("//span/label[contains(text(),'Гражданская ответственность при эксплуатации')]/../../span")).getAttribute("id");
		String splitResponsibility [] = labelIdResponsibility.split(":");
				
		WebElement checkboxResponsibility = mainClass.driver.findElement(By.xpath("//input[contains(@name,'"+splitResponsibility[4]+":"+splitResponsibility[5]+"')][contains(@type, 'checkbox')]"));
		WebElement responsibility = mainClass.driver.findElement(By.xpath("//input[contains(@name,'"+splitResponsibility[4]+":"+splitResponsibility[5]+"')][contains(@id,'"+splitResponsibility[4]+":"+splitResponsibility[5]+"')]"));
		checkboxResponsibility.click();
		assertTrue(responsibility.isDisplayed()); // проверка на отображения поля на странице
		
				// Проверка минимального значения поля "Гражданская ответственность при эксплуатации"
				String responsibilityMin = responsibility.getAttribute("value");
				responsibility.sendKeys(Keys.chord(Keys.CONTROL, "a"), valueResponsibilityMin, Keys.ENTER);
				assertEquals(responsibilityMin, responsibility.getAttribute("value"));
						
				// Проверка максимального значения поля "Гражданская ответственность при эксплуатации"
				responsibility.sendKeys(Keys.chord(Keys.CONTROL, "a"), responsibilityMax, Keys.ENTER);
				assertEquals(responsibilityMax, responsibility.getAttribute("value"));
				
				// Проверка произвольного значения поля "Гражданская ответственность при эксплуатации"
				responsibility.sendKeys(Keys.chord(Keys.CONTROL, "a"), otherValueResponsibility, Keys.ENTER);
				assertEquals(otherValueResponsibility, responsibility.getAttribute("value"));
				
				// Проверка CheckBox "Гражданская ответственность при эксплуатации"
				checkboxResponsibility.click();
				assertTrue(responsibility.isEnabled());
				checkboxResponsibility.click();assertTrue(responsibility.isDisplayed());
		
				// Checkbox
				WebElement faultNetworks = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Неисправность сетей')]/../following-sibling::td/input[contains(@type, 'checkbox')]"));
				faultNetworks.click();
				WebElement bayPlus = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Залив+')]/../following-sibling::td/input[contains(@type, 'checkbox')]"));
				bayPlus.click();
				WebElement fightGlasses = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Бой стекол')]/../following-sibling::td/input[contains(@type, 'checkbox')]"));
				fightGlasses.click();	
				
	// Франшиза
		WebElement franshuza = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Франшиза')]/../../following-sibling::td/input[contains(@type, 'checkbox')]"));
		franshuza.click();
	Thread.sleep(3000);
	}

}
