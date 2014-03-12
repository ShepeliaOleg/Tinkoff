import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// Основные риски - рандомное проставления checkbox
public class TheMainRisksCheckbox {

	MainClass mainClass = new MainClass();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception{
	
		mainClass.testMain();

		ArrayList<WebElement> chekbox = (ArrayList<WebElement>) mainClass.driver.findElements(By.xpath("//div/h3[contains(text(), 'Основные ри')]/../../div/table/tbody/tr/td/input[contains(@type, 'checkbox')]"));
		for (int i = 0; i < chekbox.size(); i++){
			int index = (int)Math.floor(Math.random()*chekbox.size());
			chekbox.get(index).click();
			
		}
	}

}
