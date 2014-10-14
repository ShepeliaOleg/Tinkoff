

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by New on 09.10.2014.
 */
public class WaitForElement {

    /**
     * Метод предназначен для ожидания загрузки страницы (ожидание проиходит до момента появления переденного названия элемента на странице)
     * @param driver передать WebDriver
     * @param nameElement передать название элемента, который должен находится на странице
     */
    public void waitFor (WebDriver driver, String nameElement) throws InterruptedException {
        if (driver.getPageSource().contains(nameElement) != true){
          for (int i = 0; i < 50; i++)
            Thread.sleep(2000);
        }
    }
}
