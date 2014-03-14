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


public class MainClass {
	
	protected WebDriver driver;
	
	
	
	public static void main (String [] s) throws Exception{
		MainClass mainClass = new MainClass();
		mainClass.login("https://c.cs18.visual.force.com/apex/complexProductCalculator?customerId=00111000008mL7yAAE&recordType=Travel",
						"yuliya.chyrva@customertimes.com.a2dev", "qaz123wsx");
	mainClass.list("Доступные страны", 5);
	mainClass.date("Дата подачи документов на визу", "20.03.2014");
	mainClass.selectValue("Валюта", "USD");
	}

	
	public void login(String url, String username, String password) throws InterruptedException { // вход в систему
		driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get(url); //адрес URL
		driver.findElement(By.id("username")).sendKeys(username); // логин
		driver.findElement(By.id("password")).sendKeys(password); // пароль
		driver.findElement(By.id("Login")).click(); // вход в систему
		Thread.sleep(5000);
		
	}

	public void fieldWithoutTheCheckbox (int cost/*будущее значение поля*/) throws Exception{ // поле без checkbox рядом
	
		String minORmaxORother = Integer.toString(cost); // приведение значения типа Int к типу String
		WebElement field = driver.findElement(By.xpath("//label[contains(text(), 'Страховая сумма (без НС)')]/../../following-sibling::td/input[contains(@type, 'text')]"));
		field.sendKeys(Keys.chord(Keys.CONTROL, "a"), minORmaxORother, Keys.ENTER);
		
		Thread.sleep(2000);
		
	}
	
	public void testCheckbox (String nameLableOfBlock/*имя блока*/)throws Exception{ // поиск и отметка Checkbox в блоке
		
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
						.xpath("//label[contains(text(), '"+nameLabel+"')]/../../td/select/option[contains(text(), '"
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

	public void date(String nameLabel/*имя лейбла рядом с полем установки даты*/, String date/*указать дату "ДД.ММ.ГГГГ"*/) throws Exception{ // установка даты
		//String date = "20.03.2014"; // указать необходимое значение даты в формате ДД.ММ.ГГГГ
		//String nameLabel = "Дата начала действия полиса"; // имя лейбла рядом с полем установки даты
		WebElement label = driver.findElement(By.xpath("//label[contains(text(), '"+nameLabel+"')]/.."));
		String split [] = label.getAttribute("id").split(":");
		WebElement field = driver.findElement(By.xpath("//input[contains(@id, '"+split[4]+"')]"));
		field.sendKeys(Keys.chord(Keys.CONTROL, "a"), date);
		
	}
}
