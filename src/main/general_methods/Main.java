import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by New on 21.10.2014.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Job\\Тинькофф\\Test\\complexproperty\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Authorization authorization = new Authorization();
        DataForAuthorization dataForAuthorization = new DataForAuthorization();
        BasicMethods basicMethods = new BasicMethods();
        WaitForElement waitForElement = new WaitForElement();

        authorization.login(driver, dataForAuthorization.url, dataForAuthorization.username, dataForAuthorization.password);
        waitForElement.waitFor(driver, "Транспортное средство");

        basicMethods.goToDriverTab(driver, "Сведения о страхователе");
        waitForElement.waitFor(driver, "Документ, удостоверяющий личность");
        basicMethods.selectFromMandatoryField(driver, "Гражданство");
        basicMethods.goToDriverTab(driver, "Транспортное средство");
        waitForElement.waitFor(driver, "Тип кузова");
        basicMethods.selectFromNotMandatoryField(driver, "Страна регистрации ТС");
        System.out.println("end");
    }
}
