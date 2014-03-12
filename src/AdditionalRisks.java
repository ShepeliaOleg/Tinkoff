import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class AdditionalRisks {
	
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
		
		mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Страхование ва')]/../../td/input[contains(@type, 'checkbox')]")).click();
		Thread.sleep(3000);
	}

}
