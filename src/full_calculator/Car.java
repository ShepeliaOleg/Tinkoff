package full_calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumhq.jetty7.client.webdav.WebdavListener;

import java.util.ArrayList;

/**
 * Created by New on 09.10.2014.
 */
public class Car {


    public void goToTabCar (WebDriver driver){

        WebElement tabOfCar = driver.findElement(By.xpath("//*[contains(text(), 'Транспортное средство')]"));
        tabOfCar.click();
    }

    //Выбор из списка, обязательного для заполнения (есть отметка)
    public void chooseFromMandatoryList(WebDriver driver, String nameLabel, String nameElement){

        WebElement selectedElement = driver.findElement(By.xpath("//label[contains(text(), '"+ nameLabel +"')]/../" +
                "following-sibling::td[1]/div/select/option[contains(text(), '"+nameElement+"')]"));
        selectedElement.click();

    }

    //Выбор из списка, не обязательного для заполнения (нет отметки)
    public void chooseFromDataList (WebDriver driver, String nameLabel, String nameElement){

        WebElement selectedElement = driver.findElement(By.xpath("//label[contains(text(), '"+ nameLabel +"')]/../" +
                "following-sibling::td[1]/select/option[contains(text(), '"+ nameElement +"')]"));
        selectedElement.click();
    }

    //Заполнение обязательного инпутного поля (есть отметка)
    public void fillInMandatoryField (WebDriver driver, String nameLabel, String value){

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '" + nameLabel + "')]/../" +
                "following-sibling::td[1]/div/input[contains(@type, 'text')]"));
        field.sendKeys(Keys.chord(Keys.CONTROL, "A"), value);

    }

    //Заполнение не обязательного инпутного поля (нет отметки)
    public void fillInDataField (WebDriver driver, String nameLabel, String value){

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '" + nameLabel + "')]/../" +
                "following-sibling::td[1]/input[contains(@type, 'text')]"));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);

    }

    //Сначала лейбл, а потом чек-бокс в структуре
    public void clickOnCheckboxWithFirstOfLabel(WebDriver driver, String nameLabel){

        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(), '"+ nameLabel +"')]/../" +
                "following-sibling::td[1]/input[contains(@type, 'checkbox')]"));
        checkbox.click();
    }

    //Сначала чек-бокс, а потом лейбл в структуре
    public void clickOnCheckboxWithSecondOfLabel (WebDriver driver, String nameLabel){

        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(), '" + nameLabel + "')]/../" +
                "input[contains(@type, 'checkbox')]"));
        checkbox.click();
    }

    //Выбор из датапикера
    public void selectDate(WebDriver driver, String labelName, String monthName, int year, int index) throws Exception{

        Thread.sleep(2000);
        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../following-sibling::td[1]/span/div/input"));
        field.click();

        WebElement month = driver.findElement(By.xpath("//select[contains(@title, 'Месяц')]/option[contains(text(), '"+monthName+"')]"));
        month.click();

        String yearS = Integer.toString(year);
        WebElement yearN = driver.findElement(By.xpath("//select[contains(@title, 'Год')]/option[contains(text(), '"+yearS+"')]"));
        yearN.click();
        ArrayList<WebElement> day = (ArrayList<WebElement>)driver.findElements(By.xpath("//tr[contains(@id, 'calRow1')]/td"));
        day.get(index).click();

    }

    //Ввод значения в поле, в формате 20.09.2014
    public void enterDate (WebDriver driver, String labelName, String date){

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../following-sibling::td[1]/span/div/input"));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), date);
    }
}
