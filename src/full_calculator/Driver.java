package full_calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by New on 04.09.2014.
 */


public class Driver {


    public void addDriver (WebDriver driver) throws InterruptedException {

        Thread.sleep(3000);
        WebElement tabDriver = driver.findElement(By.xpath("//*[contains(text(), 'Водители')]"));
        tabDriver.click();
        Thread.sleep(5000);
        WebElement addDriver = driver.findElement(By.xpath("//*[contains(@value, 'Добавить водителя')]"));

        addDriver.click();
    }

    public void fillInField (WebDriver driver, String labelName, String dataOfField) throws InterruptedException {

        Thread.sleep(2000);

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '" + labelName + "')]/../following-sibling::td[1]/div/input"));
        field.sendKeys(dataOfField);

    }

    public void fillInField2 (WebDriver driver, String labelName, String dataOfField) throws InterruptedException {

        Thread.sleep(2000);

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+dataOfField+"')]/../following-sibling::td/input"));
        field.sendKeys(dataOfField);

    }


    public void selectValue (WebDriver driver, String lableName, String selectedValue) throws Exception {

        WebElement select = driver.findElement(By.xpath("//label[contains(text(), '" + lableName
                + "')]/../following-sibling::td[1]/div/select/option[contains(text(), '" + selectedValue + "')]"));
        select.click();
    }


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


    public void enterDate (WebDriver driver, String labelName, String date){

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '"+labelName+"')]/../following-sibling::td[1]/span/div/input"));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), date);
    }

    public void chooseValueFromTable (WebDriver driver, String labelTable, int index ) throws Exception{

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.xpath("//label[contains(text(), '" + labelTable + "')]/../../select/option"));
        WebElement addButton = driver.findElement(By.xpath("//a/img[contains(@title, 'Add')]"));

            list.get(index).click();
            addButton.click();



    }

    public void chooseDateOfIssue (WebDriver driver){

        ArrayList <WebElement> years = (ArrayList<WebElement>) driver.findElements(By.xpath("//select[contains(@disabled, 'disabled')]/../../td[1]/div/select/option"));

        //int year = (int) Math.floor(Math.random()*(years.size()-1));
        int year = 1;
        years.get(year).click();

        ArrayList <WebElement> months = (ArrayList<WebElement>) driver.findElements(By.xpath("//select[contains(@disabled, 'disabled')]/../../td[2]/div/select/option"));

        months.remove(0);
        int month = (int) Math.floor(Math.random()*(months.size()-1));
        months.get(month).click();


    }
}
