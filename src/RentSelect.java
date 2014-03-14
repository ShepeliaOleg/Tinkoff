import static org.junit.Assert.*;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.noneDSA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//Аренда?
public class RentSelect {

	MainClass class1 = new MainClass ();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
		class1.driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		class1.login("https://cs18.salesforce.com/apex/complexProductCalculator?quotationId=a0Z110000009e0UEAQ", "yuliya.chyrva@customertimes.com.a2dev", "qaz123wsx");
		
		
		class1.driver.findElement(By.xpath("//label[contains(text(), 'Аренда')]/../../td/select/option[contains(text(), 'Сдаю')]")).click();
		Thread.sleep(5000);
	
	}

}
