import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by New on 21.10.2014.
 */
public class BasicMethods {

    /**
     * Метод предназначен для перехода на вкладку указанную вкладку
     * @param driver передать WebDriver
     */
    public void goToDriverTab(WebDriver driver, String tabName) throws InterruptedException {
        Thread.sleep(3000);
        WebElement tabDriver = driver.findElement(By.xpath("//*[contains(text(), '"+ tabName +"')]"));
        tabDriver.click();
       }


    /**
     * Метод предназначен для заполнения обязательного поля (поле типа input)
     * @param driver передать WebDriver
     * @param labelName указать имя лейбла (название поля, над которым будет выполнятся действие)
     * @param dataOfField указать стринговое значение, которое будет введено в поле
     */
    public void fillInMandatoryField(WebDriver driver, String labelName, String dataOfField) throws InterruptedException {

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '" + labelName + "')]/../following-sibling::td[1]/div/input"));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), dataOfField);
        String actualRezult = field.getText();
        Assert.assertEquals(dataOfField, actualRezult);
    }

    /**
     * Метод предназначен для заполнения не обязательного поля (поле типа input)
     * @param driver передать WebDriver
     * @param labelName указать имя лейбла (название поля, над которым будет выполнятся действие)
     * @param dataOfField указать стринговое значение, которое будет введено в поле
     */
    public void fillInNotMandatoryField(WebDriver driver, String labelName, String dataOfField) throws InterruptedException {

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+ labelName +"')]/../following-sibling::td/input"));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), dataOfField);
        String actualResult = field.getText();
        Assert.assertEquals(dataOfField, actualResult);

    }

    /**
     * Метод предназначен для выбора конкретных значений с обязательного для заполнения поля (есть соответствующая отметка возле поля)
     * @param driver  передать WebDriver
     * @param lableName  указать имя лейбла (название поля, над которым будет выполнятся действие)
     */
    public void selectFromMandatoryField(WebDriver driver, String lableName) {

        List <WebElement> valueList = driver.findElements(By.xpath("//label[contains(text(), '" + lableName
                + "')]/../following-sibling::td[1]/div/select/option"));
        WebElement selectedValue = valueList.get((int) Math.floor(Math.random()* (valueList.size()-1)));
        selectedValue.click();

    }

    /**
     * Метод предназначен для выбора конкретных значений с не обязательного для заполнения поля (нет соответствующая отметка возле поля)
     * @param driver  передать WebDriver
     * @param lableName  указать имя лейбла (название поля, над которым будет выполнятся действие)
     */
    public void selectFromNotMandatoryField(WebDriver driver, String lableName) {

       List <WebElement> valueList = driver.findElements(By.xpath("//label[contains(text(), '" + lableName + "')]/../" +
                "following-sibling::td[1]/select/option"));
        /*WebElement selecedValue = valueList.get((int) Math.floor(Math.random()*(valueList.size()-1)));
        selecedValue.click();*/
        for (WebElement element : valueList) {
            System.out.println(element);
        }

    }

    /**
     * Метод предназначен для ввода значения Даты в обязательное, для заполнения поле (есть соответствующая отметка возле поля)
     * @param driver передать WebDriver
     * @param labelName указать имя лейбла (название поля, над которым будет выполнятся действие)
     * @param date указать стринговое значение даты, в формате ДД.ММ.ГГГГ
     */
    public void enterDate (WebDriver driver, String labelName, String date){

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../following-sibling::td[1]/span/div/input"));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), date);
    }


    /**
     * Метод предназначен для добавления значения из одной таблицы в другую
     * @param driver передать WebDriver
     * @param labelTable указать имя таблицы, с которой будет добавляться значение
     * @param index указать целочисленное значение от 0 до 14 (по этому индексу будет выбрано значение из таблицы)
     */
    public void addValueFromTable(WebDriver driver, String labelTable, int index) {

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.xpath("//label[contains(text(), '" + labelTable + "')]/../../select/option"));

        WebElement addButton = driver.findElement(By.xpath("//a/img[contains(@title, 'Add')]"));

        list.get(index).click();
        addButton.click();

    }


}
