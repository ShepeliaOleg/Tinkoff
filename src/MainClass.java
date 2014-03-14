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
		mainClass.testLogin();
		mainClass.selectValue();
	}

	
	public WebDriver testLogin() throws InterruptedException {
		driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://cs18.salesforce.com/apex/complexProductCalculator?quotationId=a0Z110000009e0UEAQ"); //адрес URL
		driver.findElement(By.id("username")).sendKeys("yuliya.chyrva@customertimes.com.a2dev"); // логин
		driver.findElement(By.id("password")).sendKeys("qaz123wsx"); // пароль
		driver.findElement(By.id("Login")).click(); // вход в систему
		return driver;
		
	}

	public void fieldWithoutTheCheckbox () throws Exception{ // поле без checkbox рядом
		int cost = 500000; // минимально или максимальное, или произвольное значение
		String minORmaxORother = Integer.toString(cost); // приведение значения типа Int к типу String
		WebElement field = driver.findElement(By.xpath("//label[contains(text(), 'Страховая сумма (без НС)')]/../../following-sibling::td/input[contains(@type, 'text')]"));
		field.sendKeys(Keys.chord(Keys.CONTROL, "a"), minORmaxORother, Keys.ENTER);
		
		Thread.sleep(2000);
		
	}
	
	public void testCheckbox ()throws Exception{ // поиск и отметка Checkbox в блоке
		String nameLableOfBlock = "Основные риски"; // имя блока
		ArrayList<WebElement> chekbox = (ArrayList<WebElement>) driver
				.findElements(By
						.xpath("//div/h3[contains(text(), '"+nameLableOfBlock+"')]/../../div/table/tbody/tr/td/input[contains(@type, 'checkbox')]"));
		for (int i = 0; i < chekbox.size(); i++){
			int index = (int)Math.floor(Math.random()*chekbox.size());
			chekbox.get(index).click();
		}
	}
	
	public void fieldWithCheckbox () throws Exception { // поле рядом с checkbox 
		String nameLable = "Конструктивные элементы"; // имя лейбла рядом с полем
		int cost = 500000; // минимально или максимальное, или произвольное значение
		String minORmaxORother = Integer.toString(cost);
		WebElement labelId = driver.findElement(By.xpath("//span/label[contains(text(),'"+nameLable+"')]/../../span"));
		String split [] = labelId.getAttribute("id").toString().split(":");
		WebElement field = driver.findElement(By.xpath("//input[contains(@id,'"+split[4]+":"+split[5]+"')]"));
		field.sendKeys(Keys.chord(Keys.CONTROL, "a"), minORmaxORother, Keys.ENTER);
		
	}

	public void selectValue () throws Exception { // выбор елемента из выпадающего списка
		String nameLabel = "Есть дерево в перекрытиях?"; // имя лейбла рядом из списком
		String selectValue = "Да"; // имя елемента списка, который нужно выбрать
		WebElement select = driver
				.findElement(By
						.xpath("//label[contains(text(), '"+nameLabel+"')]/../../td/select/option[contains(text(), '"
								+ selectValue + "')]"));
		select.click();
	}
}
