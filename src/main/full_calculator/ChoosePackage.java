

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by New on 03.10.2014.
 */
public class ChoosePackage {

    WebDriver driver;
    Authorization authorization = new Authorization();
    DataForAuthorization data = new DataForAuthorization();


    public void test (WebDriver driver, String lableName, int numberOfColumn) throws InterruptedException {

        authorization.login(driver, data.url, data.username, data.password);

        WebElement buttonSave = driver.findElement(By.xpath("//input[contains(@type, 'submit')][contains(@value, 'Сохранить')]"));
        buttonSave.click();
        Thread.sleep(100000);

        WebElement checkbox = driver.findElement(By.xpath("//*[contains(text(), '"+lableName+"')]/following-sibling::td["+numberOfColumn+"]/span/input[contains(@type, 'checkbox')]"));
        checkbox.click();

        List<WebElement> elementList = driver.findElements(By.xpath("//*[contains(text(), '"+lableName+"')]/following-sibling::td["+numberOfColumn+"]/span/select/option"));

        for (WebElement element : elementList){

            System.out.println(element.getText());
        }

    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = new FirefoxDriver();
        ChoosePackage choosePackage = new ChoosePackage();
        choosePackage.test(webDriver, "Страховка от", 3);
        //choosePackage.chooseCheckbox(webDriver);


        System.out.println("olol");

    }

    public  void chooseCheckbox (WebDriver driver) throws InterruptedException {

        authorization.login(driver, data.url, data.username, data.password);

        WebElement buttonSave = driver.findElement(By.xpath("//input[contains(@type, 'submit')][contains(@value, 'Сохранить')]"));
        buttonSave.click();
        Thread.sleep(100000);

        List <WebElement> webElements = driver.findElements(By.xpath("//descendant::input[@type='checkbox'][contains(@disabled, 'disabled')=true]"));
        System.out.println(webElements.size());

        for (WebElement element : webElements) {
            element.click();
        }
    }
}
