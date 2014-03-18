import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.jboss.netty.handler.codec.spdy.SpdyHeaders.Spdy2HttpNames;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// Имущество/Строение/Тип полиса - месячный, Регион имущества - Ивановская обл., Продукт - Дом.Комплексный
public class PropertyBuildingNotMoscow {
	
	public static void main (String []s) throws Exception{
		
		MainClass mainClass = new MainClass();
	
	mainClass.login("https://cs18.salesforce.com/apex/complexProductCalculator?quotationId=a0Z11000000A7obEAC",
			"yuliya.chyrva@customertimes.com.a2dev", "qaz123wsx");
		Thread.sleep(5000);
		
		// блок "Тарифные вопросы"
	mainClass.selectValue("Материал основного строения", "Деревянный");
		Thread.sleep(5000);
	mainClass.selectValue("Аренда?", "Сдаю");
		Thread.sleep(5000);
	mainClass.selectValue("Есть пристроенная баня?", "Да");
		Thread.sleep(5000);
	mainClass.selectValue("Характер проживания", "Сезонное");
		Thread.sleep(5000);
	mainClass.selectValue("Есть источник открытого огня?", "Да");
		Thread.sleep(5000);
	mainClass.fieldWithoutTheCheckbox(300000, "Страховая сумма (без НС)");
		Thread.sleep(5000);
		
		// блок "Основные покрытия"
	mainClass.fieldWithCheckbox("Конструктивные элементы", 500000);
	Thread.sleep(2000);
	mainClass.fieldWithCheckbox("Инженерное оборудование", 150000);
	Thread.sleep(2000);
	mainClass.fieldWithCheckbox("Внутренняя отделка", 60000);
	Thread.sleep(2000);
	mainClass.fieldWithCheckbox("Движимое имущество", 60000);
	Thread.sleep(5000);
	
	// блок "Основные риски"
	mainClass.Checkbox("Основные риски");
	
	// блок "Дополнительные риски, покрытия, опции"
	Thread.sleep(3000);
	mainClass.checkboxSelect("Страхование ваших расходов");
	Thread.sleep(3000);
	mainClass.checkboxWithField("Вспомогательные строения (баня, гараж и др.)");
	Thread.sleep(3000);
	mainClass.checkboxWithField("Прочие сооружения (забор, бассейн и др.)");
	Thread.sleep(3000);
	mainClass.checkboxWithField("Страхование от несчастных случаев");
	Thread.sleep(2000);
	mainClass.checkboxWithField("Гражданская ответственность арендатора");
	Thread.sleep(3000);
	mainClass.checkboxSelect("Неисправность сетей");
	Thread.sleep(2000);
	mainClass.checkboxSelect("Залив+");
	Thread.sleep(2000); 
	mainClass.checkboxSelect("Бой стекол");
	Thread.sleep(2000);
	mainClass.fieldWithCheckbox("Вспомогательные строения (баня, гараж и др.)", 70000);
	Thread.sleep(2000);
	mainClass.fieldWithCheckbox("Прочие сооружения (забор, бассейн и др.)", 90000);
	Thread.sleep(2000);
	mainClass.fieldWithCheckbox("Страхование от несчастных случаев", 350000);
	Thread.sleep(2000);
	mainClass.fieldWithCheckbox("Гражданская ответственность арендатора", 85000);
	Thread.sleep(3000);
	mainClass.checkboxWithField("Вспомогательные строения (баня, гараж и др.)");
	Thread.sleep(2000);
	mainClass.checkboxWithField("Страхование от несчастных случаев");
	Thread.sleep(3000);
	mainClass.checkboxWithField("Гражданская ответственность арендатора");
	Thread.sleep(2000);
	mainClass.checkboxWithField("Прочие сооружения (забор, бассейн и др.)");
	Thread.sleep(2000);
	mainClass.checkboxSelect("Неисправность сетей");
	Thread.sleep(2000);
	mainClass.checkboxSelect("Залив+");
	Thread.sleep(2000);
	mainClass.checkboxSelect("Бой стекол");
	Thread.sleep(2000);
	
	
	WebElement element = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Расходы при потере арендной платы')]/../../../td/input[contains(@type, 'text')]"));
	element.sendKeys(Keys.chord(Keys.CONTROL, "a"), "40000", Keys.ENTER);
	WebElement element2 = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Расходы по замене замков/дверей')]/../../../td/input[contains(@type, 'text')]"));
	element2.sendKeys(Keys.chord(Keys.CONTROL, "a"), "10000", Keys.ENTER);
	WebElement element1Checkbox = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Расходы при потере арендной платы')]/../../../td/input[contains(@type, 'checkbox')]"));
	element1Checkbox.click();
	WebElement element2Checkbox = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Расходы по замене замков/дверей')]/../../../td/input[contains(@type, 'checkbox')]"));
	element2Checkbox.click();
	
	// блок "Франшиза"
	mainClass.checkboxWithField("Франшиза");
	Thread.sleep(2000);
	mainClass.fieldWithCheckbox("Франшиза", 70000);
	Thread.sleep(2000);
	mainClass.checkboxWithField("Франшиза");
	
	}
	
	
}
