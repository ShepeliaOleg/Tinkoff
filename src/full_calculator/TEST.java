package full_calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by New on 09.10.2014.
 */
public class TEST {


    public static void main(String[] args) throws Exception {
        final WebDriver driver = new FirefoxDriver();


        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //final WebDriver driver = new ChromeDriver();


        driver.get("https://cs18.salesforce.com/apex/AutoProductCalculator?customerId=0011100000b4RcZAAU&region=77");
        driver.manage().window().maximize();
        WebElement searchField;
        WebElement text;


        driver.findElement(By.id("username")).sendKeys("nikolay.pecherskiy@customertimes.com.buat");
        driver.findElement(By.id("password")).sendKeys("poqw0912");
        driver.findElement(By.id("Login")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElement(By.xpath("//*[contains(@value, 'Сохранить')]")).click();

        //waitForElementVisible(By.xpath("//*[@class='packageTableHeader']"),30);

        Thread.sleep(80000);
        System.out.print("load!!!!");
        TEST test = new TEST();
        test.FieldInput(driver);
    }

    /*public void setCheckbox(WebDriver driver, String text, String id_position) throws Exception {

        String testString = driver.findElement(By.xpath("//*[contains(text(), 'Страховка ')]//..//span")).getAttribute("id");
        String[] id_position = testString.split(":");

        System.out.println(id_position[1]);*/

    public void FieldInput(WebDriver driver) throws Exception {

        //xpathspan = "//span/label[contains(text(),'";
        Thread.sleep(5000);
        String spanid = driver.findElement(By.xpath("//*[contains(text(), 'Страховка ')]//..//span")).getAttribute("id");
        String[] split = spanid.split(":");
        WebElement FieldInput = driver.findElement(By.xpath("//span[contains(@id,'" + split[7] + "')]"));
        FieldInput.sendKeys(Keys.SPACE);
        // System.out.println("FieldName: " + label + ": " +FieldInput.getAttribute("value"));
        System.out.println(split);
        System.out.println(split[7]);

        System.out.println("End!!!!");
    }

}
