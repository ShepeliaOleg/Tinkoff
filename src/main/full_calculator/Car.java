

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by New on 09.10.2014.
 */
public class Car {


    /**
     * Метод предназначен для перехода на вкладку "Транспортное средство"
     * @param driver передать WebDriver
     */
    public void goToCarTab(WebDriver driver){

        WebElement tabOfCar = driver.findElement(By.xpath("//*[contains(text(), 'Транспортное средство')]"));
        tabOfCar.click();
    }

    /**
     * Метод предназначен для добавления новго транспортного средства
     * @param driver передать WebDriver
     */
    public void addNewCar (WebDriver driver) throws InterruptedException {
        WebElement addCar = driver.findElement(By.xpath("//*[contains(@value, 'Добавить транспортное средство')]"));
        addCar.click();
        Thread.sleep(5000);
    }

     /**
     * Метод предназначен для выбора конкретных значений с обязательного для заполнения поля (есть соответствующая отметка возле поля)
     * @param driver передать WebDriver
     * @param nameLabel передать имя лейбла (название поля, над которым будет выполнятся действие)
     * @param selectedValue передать стринговое значение, которое будет найдено в списке и выбрано
     */
    public void selectFromMandatoryField(WebDriver driver, String nameLabel, String selectedValue){

        WebElement selectedElement = driver.findElement(By.xpath("//label[contains(text(), '"+ nameLabel +"')]/../" +
                "following-sibling::td[1]/div/select/option[contains(text(), '"+selectedValue+"')]"));
        selectedElement.click();

    }


    /**
     * Метод предназначен для выбора конкретных значений с не обязательного для заполнения поля (нет соответствующая отметка возле поля)
     * @param driver передать WebDriver
     * @param nameLabel передать имя лейбла (название поля, над которым будет выполнятся действие)
     * @param selectedValue передать стринговое значение, которое будет найдено в списке и выбрано
     */
    public void selectFromNotMandatoryField(WebDriver driver, String nameLabel, String selectedValue){

        WebElement selectedElement = driver.findElement(By.xpath("//label[contains(text(), '"+ nameLabel +"')]/../" +
                "following-sibling::td[1]/select/option[contains(text(), '"+ selectedValue +"')]"));
        selectedElement.click();
    }


    /**
     * Метод предназначен для заполнения обязательного поля (поле типа input)
     * @param driver передать WebDriver
     * @param nameLabel передать имя лейбла (название поля, над которым будет выполнятся действие)
     * @param value передать стринговое значение, которое будет введено в поле
     */
    public void fillInMandatoryField (WebDriver driver, String nameLabel, String value){

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '" + nameLabel + "')]/../" +
                "following-sibling::td[1]/div/input[contains(@type, 'text')]"));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);

        String actualResult = field.getAttribute("value");
        String expectedResult = value;
        Assert.assertEquals(expectedResult, actualResult);

    }

    //Заполнение не обязательного инпутного поля (нет отметки)

    /**
     * Метод предназначен для заполнения не обязательного поля (поле типа input)
     * @param driver передать WebDriver
     * @param nameLabel передать имя лейбла (название поля, над которым будет выполнятся действие)
     * @param value передать стринговое значение, которое будет введено в поле
     */
    public void fillInNotMandatoryField (WebDriver driver, String nameLabel, String value){

        WebElement field = driver.findElement(By.xpath("//label[contains(text(), '" + nameLabel + "')]/../" +
                "following-sibling::td[1]/input[contains(@type, 'text')]"));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);

        String actualResult = field.getAttribute("value");
        String expectedResult = value;
        Assert.assertEquals(expectedResult, actualResult);

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
