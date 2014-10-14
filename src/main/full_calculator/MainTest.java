
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
        Data data = new Data();
        Authorization authorization = new Authorization();
        WaitForElement waitForElement = new WaitForElement();
        Car car = new Car();

        authorization.login(driver, data.url, data.username, data.password);
        waitForElement.waitFor(driver, "Марка");
        authodriver.goToDriverTab(driver);
        waitForElement.waitFor(driver, "Отчество");
        authodriver.addNewDriver(driver);
        authodriver.fillInMandatoryField(driver, "Фамилия", "Рандомчиковnew");
        authodriver.fillInMandatoryField(driver, "Отчество", "Рандомчиковnew");
        authodriver.fillInMandatoryField(driver, "Имя", "Рандомчиковnew");
        authodriver.enterDate(driver, "Дата рождения", "21.05.1986");
        authodriver.selectFromNotMandatoryField(driver, "Семейное положение", "Гражданский брак");
        authodriver.selectFromMandatoryField(driver, "Пол", "Женский");

        //authodriver.addValueFromTable(driver, "Доступные категории", 3);
        authodriver.fillInMandatoryField(driver, "Номер", "785421");
        authodriver.fillInMandatoryField(driver, "Серия", "1111");
        authodriver.chooseDateForCategory(driver);




    }
}
