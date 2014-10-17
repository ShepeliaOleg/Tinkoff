
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by New on 04.09.2014.
 */


public class Driver {

    /**
     * Метод предназначен для перехода на вкладку "Водители"
     * @param driver передать WebDriver
     */
    public void goToDriverTab(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        WebElement tabDriver = driver.findElement(By.xpath("//*[contains(text(), 'Водители')]"));
        tabDriver.click();
        Thread.sleep(7000);
    }

    /**
     * Метод предназначен для создания нового водителя (нажатие на кнопку "Добавить водителя")
     * @param driver передать WebDriver
     */
    public void addNewDriver (WebDriver driver) throws InterruptedException {
        WebElement addDriver = driver.findElement(By.xpath("//*[contains(@value, 'Добавить водителя')]"));
        addDriver.click();
        Thread.sleep(5000);
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

    }

    /**
     * Метод предназначен для выбора конкретных значений с обязательного для заполнения поля (есть соответствующая отметка возле поля)
     * @param driver  передать WebDriver
     * @param lableName  указать имя лейбла (название поля, над которым будет выполнятся действие)
     * @param selectedValue  указать стринговое значение, которое будет найдено в списке и выбрано
     */
    public void selectFromMandatoryField(WebDriver driver, String lableName, String selectedValue) {

        WebElement select = driver.findElement(By.xpath("//label[contains(text(), '" + lableName
                + "')]/../following-sibling::td[1]/div/select/option[contains(text(), '" + selectedValue + "')]"));
        select.click();
    }

    /**
     * Метод предназначен для выбора конкретных значений с не обязательного для заполнения поля (нет соответствующая отметка возле поля)
     * @param driver  передать WebDriver
     * @param lableName  указать имя лейбла (название поля, над которым будет выполнятся действие)
     * @param selectedValue  указать стринговое значение, которое будет найдено в списке и выбрано
     */
    public void selectFromNotMandatoryField(WebDriver driver, String lableName, String selectedValue) {

        WebElement select = driver.findElement(By.xpath("//label[contains(text(), '" + lableName
                + "')]/../following-sibling::td[1]/select/option[contains(text(), '" + selectedValue + "')]"));
        select.click();
    }


    /**
     * Метод предназначен для выбора значения даты, используя datepicker, в обязательном для заполнения поле (есть соответствующая отметка возле поля)
     * @param driver передать WebDriver
     * @param labelName указать имя лейбла (название поля, над которым будет выполнятся действие)
     * @param monthName указать стринговое значение месяца, в формате "Февраль"
     * @param year указать целочисленное значение года, в формате "2014"
     * @param index указать целочисленное значение от 0 до 12 (по этому индексу будет выбрано число)
     *
     */
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

    /**
     * Метод предназначен для заполнения полей даты, в блоке "Водительское удостоверение категории B"
     * @param driver передать WebDriver
     */
    public void chooseDateForCategory(WebDriver driver){

        ArrayList <WebElement> years = (ArrayList<WebElement>) driver.findElements(By.xpath("//select[contains(@disabled, 'disabled')]/../../td[1]/div/select/option"));

        int year = 4;
        years.get(year).click();

        ArrayList <WebElement> months = (ArrayList<WebElement>) driver.findElements(By.xpath("//select[contains(@disabled, 'disabled')]/../../td[2]/div/select/option"));

        months.remove(0);
        int month = (int) Math.floor(Math.random()*(months.size()-1));
        months.get(month).click();


    }
}
