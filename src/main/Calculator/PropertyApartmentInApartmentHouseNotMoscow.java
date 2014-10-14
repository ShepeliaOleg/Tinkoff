

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class PropertyApartmentInApartmentHouseNotMoscow {
	
	// Имущество/Квартира в многокв. доме/Тип полиса - месячный, Регион имущества - Ленинградская обл., Продукт - Квартира.Комплексный
	public static void main(String[] args) throws Exception{
		MainClass mainClass = new MainClass();
		
		mainClass.login("https://c.cs18.visual.force.com/apex/complexProductCalculator?quotationId=a0Z11000000A89wEAC",
				"yuliya.chyrva@customertimes.com.a2dev", "qaz123wsx");
			Thread.sleep(5000);
			
			// блок "Тарифные вопросы"
		mainClass.selectValue("Аренда?", "Сдаю");
			Thread.sleep(5000);
		mainClass.selectValue("Есть дерево в перекрытиях?", "Да");
			Thread.sleep(5000);
		mainClass.fieldWithoutTheCheckbox(400000, "Страховая сумма (без НС)");
		
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
		Thread.sleep(3000);
		
			// блок "Дополнительные риски, покрытия, опции"
		mainClass.checkboxSelect("Неисправность сетей");
		Thread.sleep(2000);
		mainClass.checkboxSelect("Залив+");
		Thread.sleep(2000); 
		mainClass.checkboxSelect("Бой стекол");
		Thread.sleep(2000);
		mainClass.checkboxSelect("Страхование ваших расходов");
		Thread.sleep(7000);
		
		mainClass.checkboxWithField("Страхование от несчастного случая");
		Thread.sleep(2000);
		mainClass.checkboxWithField("Гражданская ответственность арендатора");
		Thread.sleep(3000);
		mainClass.checkboxWithField("Гражданская ответственность при эксплуатации");
		Thread.sleep(3000);
		mainClass.fieldWithCheckbox("Страхование от несчастного случая", 350000);
		Thread.sleep(2000);
		mainClass.fieldWithCheckbox("Гражданская ответственность при эксплуатации", 100000);
		Thread.sleep(2000);
		mainClass.fieldWithCheckbox("Гражданская ответственность арендатора", 150000);
		
		WebElement element = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Расходы при потере арендной платы')]/../../../td/input[contains(@type, 'text')]"));
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"), "40000", Keys.ENTER);
		WebElement element2 = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Расходы по замене дверных замков')]/../../../td/input[contains(@type, 'text')]"));
		element2.sendKeys(Keys.chord(Keys.CONTROL, "a"), "10000", Keys.ENTER);
		WebElement element1Checkbox = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Расходы при потере арендной платы')]/../../../td/input[contains(@type, 'checkbox')]"));
		element1Checkbox.click();
		WebElement element2Checkbox = mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Расходы по замене дверных замков')]/../../../td/input[contains(@type, 'checkbox')]"));
		element2Checkbox.click();
		
		mainClass.checkboxSelect("Страхование ваших расходов");
		Thread.sleep(3000);
		mainClass.checkboxWithField("Страхование от несчастного случая");
		Thread.sleep(2000);
		mainClass.checkboxWithField("Гражданская ответственность арендатора");
		Thread.sleep(3000);
		mainClass.checkboxWithField("Гражданская ответственность при эксплуатации");
		Thread.sleep(3000);
		
			// блок "Франшиза"
		mainClass.checkboxWithField("Франшиза");
		Thread.sleep(2000);
		mainClass.fieldWithCheckbox("Франшиза", 70000);
		Thread.sleep(2000);
		mainClass.checkboxWithField("Франшиза");
		
		
		
			Thread.sleep(5000);

	}

}
