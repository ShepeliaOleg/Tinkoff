package full_calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by New on 04.09.2014.
 */
public class FullCalculatorTest {

    public WebDriver driver;
    Driver methods = new Driver();
    Authorization authorization = new Authorization();
    Data data = new Data();

    @Before
    public void setUpBeforeClass() throws InterruptedException {
    driver = new FirefoxDriver();
    authorization.login(driver,data.url, data.username, data.password);
    }

    @After
    public void tearDown() {

    }

   /* @Test
    public void firstM () throws Exception {

        methods.addDriver(driver);
        Thread.sleep(2000);
        methods.fillInField(driver, "Отчество", "Иванович2");
        methods.fillInField(driver, "Имя", "Иван2");
        methods.fillInField(driver, "Серия", "MS");
        methods.fillInField(driver, "Номер", "123456");
        methods.selectValue(driver, "Пол", "Женский");

        //methods.selectValue(driver, "Семейное положение", "Разведен/Разведена");

        methods.enterDate(driver, "Дата рождения", "04.06.1986");
        methods.fillInField(driver, "Фамилия", "Иванов2");
        methods.chooseValueFromTable(driver, "Доступные категории", 3);
        methods.chooseDateOfIssue(driver);


    }*/

    @Test
    public void test (){

    }
}
