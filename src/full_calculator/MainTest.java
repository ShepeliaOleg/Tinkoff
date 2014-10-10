package full_calculator;

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
        Data data = new Data();
        Authorization authorization = new Authorization();
        WaitForElement waitForElement = new WaitForElement();
        Car car = new Car();

        authorization.login(driver, data.url, data.username, data.password);
        waitForElement.waitFor(driver, "Марка");
        //car.goToTabCar(driver);

        //car.fillInMandatoryField(driver, "Мощность двигателя (л.с.)", "111");
        car.fillInDataField(driver, "Объем двигателя (куб. см)", "47");
        car.enterDate(driver, "Дата выдачи документа ТС", "24.07.1987");
        car.clickOnCheckboxWithFirstOfLabel(driver, "Сдается в прокат/аренду");
        car.clickOnCheckboxWithSecondOfLabel(driver, "Нестандартная категория");



    }
}
