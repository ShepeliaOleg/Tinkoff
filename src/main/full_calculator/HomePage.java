import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by New on 14.10.2014.
 */
public class HomePage {


       public void clickOnHomeElemant (WebDriver driver, String elementName) throws InterruptedException {

        //WebElement script = driver.findElement(By.xpath("//span[contains(text(), 'Скрипт')]/../../../em"));
        WebElement script = driver.findElement(By.xpath("//em/button/span/../.."));

        Actions actions = new Actions(driver);
        Dimension size = script.getSize();
        actions.moveToElement(script, size.getWidth() - 1, size.getHeight() - 1).click().build().perform();
        WebElement someElement = driver.findElement(By.xpath("//span[contains(text(), '" + elementName + "')]"));
        someElement.click();

    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\Job\\Тинькофф\\Test\\complexproperty\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Authorization authorization = new Authorization();
        DataForAuthorization data = new DataForAuthorization();
        authorization.login(driver, "https://cs18.salesforce.com/console", data.username, data.password);
        //authorization.login(driver, "https://cs18.salesforce.com/console", "kirill.vnukov@novaproject.com.dev", "qweqwe123");
        HomePage homePage = new HomePage();

        homePage.clickOnHomeElemant(driver, "Клиенты");

    }



}
