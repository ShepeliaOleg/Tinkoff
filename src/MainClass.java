import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.internal.remote.SlavePool;


public class MainClass {
	
	protected WebDriver driver;
	
	
	
	public static void main (String [] s) throws Exception{
		MainClass mainClass = new MainClass();
		mainClass.login("https://c.cs18.visual.force.com/apex/complexProductCalculator?customerId=00111000009hC2aAAE&recordType=Travel",
						"yuliya.chyrva@customertimes.com.a2dev", "qaz123wsx");
		Thread.sleep(5000);
		mainClass.dateNew("Дата начала действия полиса", "Август", "2014", 10);
		mainClass.dateNew("Дата подачи документов на визу", "Январь", "2016", 15);
		mainClass.dateNew2("Дата окончания действия полиса", "Март", "2018", 5);
	}

	
	public void login(String url, String username, String password) throws InterruptedException { // вход в систему
		driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get(url); //адрес URL
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys(username); // логин
		driver.findElement(By.id("password")).sendKeys(password); // пароль
		driver.findElement(By.id("Login")).click(); // вход в систему
		Thread.sleep(5000);
		
	}

	public void fieldWithoutTheCheckbox (int cost/*будущее значение поля*/, String label) throws Exception{ // поле без checkbox рядом
	
		String minORmaxORother = Integer.toString(cost); // приведение значения типа Int к типу String
		WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+label+"')]/../../following-sibling::td/input[contains(@type, 'text')]"));
		field.sendKeys(Keys.chord(Keys.CONTROL, "a"), minORmaxORother, Keys.ENTER);
		
		Thread.sleep(2000);
		
	}
	
	public void Checkbox (String nameLableOfBlock/*имя блока*/)throws Exception{ // поиск и отметка Checkbox в блоке
		
		ArrayList<WebElement> chekbox = (ArrayList<WebElement>) driver
				.findElements(By
						.xpath("//div/h3[contains(text(), '"+nameLableOfBlock+"')]/../../div/table/tbody/tr/td/input[contains(@type, 'checkbox')]"));
		for (int i = 0; i < chekbox.size(); i++){
			int index = (int)Math.floor(Math.random()*chekbox.size());
			chekbox.get(index).click();
		}
	}
	
	public void fieldWithCheckbox (String nameLable /*имя лейбла рядом с полем*/, int cost/*будущее значение поля*/) throws Exception { // поле рядом с checkbox 
		
		String minORmaxORother = Integer.toString(cost);
		WebElement labelId = driver.findElement(By.xpath("//span/label[contains(text(),'"+nameLable+"')]/../../span"));
		String split [] = labelId.getAttribute("id").toString().split(":");
		WebElement field = driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]"));
		field.sendKeys(Keys.chord(Keys.CONTROL, "a"), minORmaxORother, Keys.ENTER);
		
	}

	public void selectValue (String nameLabel/*имя лейбла рядом из списком*/, String selectValue /*имя елемента списка*/) throws Exception { // выбор елемента из выпадающего списка
		
		WebElement select = driver
				.findElement(By
						.xpath("//label[contains(text(), '"+nameLabel+"')]/../../td[1]/select/option[contains(text(), '"
								+ selectValue + "')]"));
		select.click();
	}

	public void save() throws Exception{ // сохранение введенных данных на странице калькулятора
		ArrayList<WebElement> save = (ArrayList<WebElement>) driver
				.findElements(By
						.xpath("//input[contains(@type, 'button')][contains(@value, 'Сохранить')]"));
		save.get(0).click();
		
	}
	
	public void list (String labelTable /*имя лейбла возле таблицы*/, int index /*индекс значения, которое будет выбрано в таблице(списке)*/) throws Exception{ // выбор и перенос значения из таблицы
		
		ArrayList<WebElement> list = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//label[contains(text(), '"
						+ labelTable + "')]/../../select/option"));
		list.get(index).click();
		WebElement addButton = driver.findElement(By.xpath("//a/img[contains(@title, 'Add')]"));
		addButton.click();
	}

	public void date(String nameLabel/*имя лейбла*/, String monthName, int year, int index) throws Exception{ // установка даты
		
		WebElement label = driver.findElement(By.xpath("//label[contains(text(), '"+nameLabel+"')]/.."));
		String split [] = label.getAttribute("id").split(":");
		WebElement field = driver.findElement(By.xpath("//input[contains(@id, '"+split[4]+"')]"));
		field.click();
		
		WebElement datePicker = driver.findElement(By.xpath("//div[contains(@id, 'datePicker')]"));
		WebElement month = driver.findElement(By.xpath("//select[contains(@title, 'Месяц')]/option[contains(text(), '"+monthName+"')]"));
		month.click();
		
		String yearS = Integer.toString(year);
		WebElement yearN = driver.findElement(By.xpath("//select[contains(@title, 'Год')]/option[contains(text(), '"+yearS+"')]"));
		yearN.click();
		ArrayList<WebElement> day = (ArrayList<WebElement>)driver.findElements(By.xpath("//tr[contains(@id, 'calRow1')]/td"));
		day.get(index).click();
		
	}

	public void checkboxWithField (String label) throws Exception{ // отметка checkbox возле поля
		WebElement labelId = driver.findElement(By.xpath("//span/label[contains(text(),'"+label+"')]/../../span"));
		String split [] = labelId.getAttribute("id").toString().split(":");
		WebElement field = driver.findElement(By.xpath("//input[contains(@name,'"+split[4]+":"+split[5]+"')][contains(@type, 'checkbox')]"));
		field.click();
		Thread.sleep(3000);
	}

	public void checkboxSelect (String label){ // отметка checkbox, который не открывает дополнительных полей
		WebElement element = driver.findElement(By.xpath("//label[contains(text(), '"+label+"')]/../following-sibling::td/input[contains(@type, 'checkbox')]"));
		element.click();
	}

	// заполнение поля у которого нет в структуре SPAN 
	public void field1(String labelName, int number) {
		String num = Integer.toString(number);
		WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../following-sibling::td[1]/input[contains(@type, 'text')]"));
		field.sendKeys(Keys.chord(Keys.CONTROL, "a"), num);
	}
	
	// отметка чек-бокса у которого в структуре есть SPAN
	public void checkbox2 (String labelName) {
		WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../../following-sibling::td[1]/input[contains(@type, 'checkbox')]"));
		checkbox.click();
	}
	
	// заполнение поля у которого в структуре есть SPAN
	public void field2(String lableName, int number) {
		String num = Integer.toString(number);
		WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+lableName+"')]/../../following-sibling::td[1]/input[contains(@type, 'text')]"));
		field.sendKeys(Keys.chord(Keys.CONTROL, "a"), num);
		
	}
	
	// отметка чек-бокса у которого нет в структуре нет SPAN
	public void checkbox1(String labelName) {
		WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../following-sibling::td[1]/input[contains(@type, 'checkbox')]"));
		checkbox.click();
		
	}
	
	// выбор из выпадающего списка
	public void select(String labelName, String option) {
		WebElement select = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../following-sibling::td[1]/select/option[contains(text(), '"+option+"')]"));
		select.click();
	}
	
	// выбор из таблицы и добавление элемента в другую таблицу
	public void selectTable(String labelName, String optionWithTable) {
		WebElement select = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../following-sibling::select[1]/option[contains(text(), '"+optionWithTable+"')]"));
		select.click();
		WebElement addButton = driver.findElement(By.xpath("//img[contains(@title, 'Add')]"));
		addButton.click();
	}
	
	// установка даты в календаре, у которого в структуре есть SPAN
	public void dateNew(String labelName, String month, String year, int dayIndex) {
		WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../../following-sibling::td[1]/span/input[contains(@type, 'text')]"));
		field.click();
		WebElement monthSelect = driver.findElement(By.xpath("//select[contains(@title, 'Месяц')]/option[contains(text(), '"+month+"')]"));
		monthSelect.click();
		WebElement yearSelect = driver.findElement(By.xpath("//select[contains(@title, 'Год')]/option[contains(text(), '"+year+"')]"));
		yearSelect.click();
		ArrayList<WebElement> daySelect = (ArrayList<WebElement>)driver.findElements(By.xpath("//td[contains(@class, 'weekday')]"));
		daySelect.get(dayIndex).click();
		
	}
	// установка даты в календаре, у которого в структуре нет SPAN
	private void dateNew2 (String labelName, String month, String year, int dayIndex) {
		WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../following-sibling::td[1]/span/input[contains(@type, 'text')]"));
		field.click();
		WebElement monthSelect = driver.findElement(By.xpath("//select[contains(@title, 'Месяц')]/option[contains(text(), '"+month+"')]"));
		monthSelect.click();
		WebElement yearSelect = driver.findElement(By.xpath("//select[contains(@title, 'Год')]/option[contains(text(), '"+year+"')]"));
		yearSelect.click();
		ArrayList<WebElement> daySelect = (ArrayList<WebElement>)driver.findElements(By.xpath("//td[contains(@class, 'weekday')]"));
		daySelect.get(dayIndex).click();
	}
}
