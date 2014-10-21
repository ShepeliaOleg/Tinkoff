
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

/**
 * Created by New on 09.10.2014.
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        /*System.setProperty("webdriver.chrome.driver", "E:\\Job\\Тинькофф\\Test\\complexproperty\\src\\chromedriver.exe");
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        Driver authodriver = new Driver();
        DataForAuthorization data = new DataForAuthorization();
        Authorization authorization = new Authorization();
        WaitForElement waitForElement = new WaitForElement();
        Car car = new Car();

        authorization.login(driver, data.url, data.username, data.password);
        waitForElement.waitFor(driver, "Марка");

        car.addNewCar(driver);
*/

        MainTest mainTest = new MainTest();
        System.out.println(mainTest.generateRandomMask(1, 3));
        System.out.println(mainTest.randomDate());
        //mainTest.generateRandomMask(1, 1);


    }

    public String generateRandomMask(int min, int max) {
        Random rand = new Random();
        char[] list1 = new char[]{'A', 'B', 'C', 'E', 'H', 'K', 'M', 'O', 'P', 'T', 'X', 'Y'};
        char[] list2 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        StringBuilder l1 = new StringBuilder();
        StringBuilder l2 = new StringBuilder();
        StringBuilder l3 = new StringBuilder();
        StringBuilder l4 = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            int randomL = rand.nextInt((11 - 0) + 1) + 0;
            l1.append(list1[randomL]);

        }
            for (int i1 = 0; i1 < 3; i1++) {
                int randomL2 = rand.nextInt((9 - 0) + 1) + 0;
                l2.append(list2[randomL2]);
        }
        String value1 = l1.toString();
        String value2 = l2.toString();

        for (int i = 0; i < 2; i++) {
            int randomL3 = rand.nextInt((11 - 0) + 1) + 0;
            l3.append(list1[randomL3]);
        }
            for (int i1 = 0; i1 < 3; i1++) {
                int randomL4 = rand.nextInt((9 - 0) + 1) + 0;
                l4.append(list2[randomL4]);
         }
        String value3 = l3.toString();
        String value4 = l4.toString();


    return value1 + value2 + value3 + value4;
    }


    public String randomDate (){

        int day = (int) Math.floor(Math.random() * (28-1+1))+1;
        int mounth = (int) (Math.floor(Math.random() * (12 - 1 + 1))+1);
        int year = (int) (Math.floor(Math.random()* (2000 - 1945 + 1 )) + 1945);

        String dayS = String.valueOf(day);
        String mounthS = String.valueOf(mounth);
        String yearS = String.valueOf(year);

        return dayS + "." + mounthS + "." + yearS;
    }
}

