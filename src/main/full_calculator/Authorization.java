import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by New on 04.09.2014.
 */
public class Authorization {


    /**
     * Метод предназначен для авторизации в системе SalesForce
     * @param driver передать WebDriver
     * @param url передать url
     * @param username передать логин
     * @param password передать пароль
     */
    public void login(WebDriver driver, String url, String username, String password) throws InterruptedException { // вход в систему

        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get(url); //адрес URL
        Thread.sleep(4000);
        driver.findElement(By.id("username")).sendKeys(username); // логин
        driver.findElement(By.id("password")).sendKeys(password); // пароль
        driver.findElement(By.id("Login")).click(); // вход в систему
        }


}
