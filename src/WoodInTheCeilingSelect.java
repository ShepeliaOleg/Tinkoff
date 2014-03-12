import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

// Есть дерево в перекрытиях?
public class WoodInTheCeilingSelect {

	MainClass mainClass = new MainClass();
	String expectedValua = "Да";
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		
		mainClass.testMain();
		
				mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Есть дерево в перекрытиях?')]/../../td/select/option[contains(text(), 'Да')]")).click();
	
				String actualValue= mainClass.driver.findElement(By.xpath("//label[contains(text(), 'Есть дерево в перекрытиях?')]/../../td/select/option[contains(text(), 'Да')]")).getText();
				System.out.println(actualValue);
				
		Assert.assertEquals(expectedValua, actualValue);
	}

}
