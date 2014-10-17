
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by New on 09.10.2014.
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Job\\Тинькофф\\Test\\complexproperty\\src\\chromedriver.exe");
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        Driver authodriver = new Driver();
        DataForAuthorization data = new DataForAuthorization();
        Authorization authorization = new Authorization();
        WaitForElement waitForElement = new WaitForElement();
        Car car = new Car();

        authorization.login(driver, data.url, data.username, data.password);
        waitForElement.waitFor(driver, "Марка");

        car.addNewCar(driver);




    }
}
