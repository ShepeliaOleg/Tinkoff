
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class MinNumber extends MainClass {

	private String min = new String("100 000");
	private String otherValue = "100 000"; //


	MainClass mainClass = new MainClass();
	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testBoundaryMinConstrElement() throws Exception {

		mainClass.login("https://cs18.salesforce.com/console", 
				"yuliya.chyrva@customertimes.com.a2dev", "qaz123wsx");
		Thread.sleep(7000);
		
		ArrayList<WebElement> e = (ArrayList<WebElement>) mainClass.driver.findElements(By.xpath("//button[contains(@class, '')]"));
		for (int i = 0; i < e.size(); i++){
			System.out.println(e.get(i).getAttribute("class").toString());
		}
		
		WebElement b = mainClass.driver.findElement(By.xpath("//em[contains(@class, 'x-btn-split')]/button"));
		b.click();
	}
}
