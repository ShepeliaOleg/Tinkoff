import static org.junit.Assert.*;

import java.awt.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.seleniumemulation.IsChecked;
import org.openqa.selenium.support.ui.Select;

public class MinNumber extends MainClass {

	private String min = new String("100 000");
	private String otherValue = "100 000"; //

	MainClass mainClass = new MainClass();
	SumInsured insured = new SumInsured ();
	WoodInTheCeilingSelect ceilingSelect = new WoodInTheCeilingSelect();

	@After
	public void tearDown() throws Exception {
		mainClass.driver.quit();
	}

	@Test
	public void testBoundaryMinConstrElement() throws InterruptedException {

		mainClass.testMain();
		
		/*WebElement selectElement = null;
		selectElement = mainClass.driver.findElement(By.tagName("select"));
		Select select = new Select(selectElement);
		select.selectByVisibleText("");*/
				
		
		insured.testMax();
		ceilingSelect.test();
		Thread.sleep(5000);

	}
}
