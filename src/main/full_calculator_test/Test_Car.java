import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.locators.GoogleChromeLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by New on 10.10.2014.
 */
public class Test_Car {

    WebDriver driver;
    Data data = new Data();
    Authorization authorization = new Authorization();
    WaitForElement waitForElement = new WaitForElement();
    Car car = new Car();


    @Before
    public void setUpBeforeClass() throws Exception{
       System.setProperty("webdriver.chrome.driver", "E:\\Job\\Тинькофф\\Test\\complexproperty\\src\\chromedriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        authorization.login(driver, data.url, data.username, data.password);
        waitForElement.waitFor(driver, "Марка");
        System.out.println("start");

    }

    @After
    public void tearDown() throws Exception {

        //driver.quit();
        System.out.println("stop");
    }

    @Test
    public void checkField (){
        //car.checkSelectedFromMandatoryList(driver, "Мощность двигателя (л.с.)", "111");
        car.fillInMandatoryField(driver, "Мощность двигателя (л.с.)", "111");
        System.out.println("doing");
    }
}
