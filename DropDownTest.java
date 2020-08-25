package DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class DropDownTest {

    public static void main(String[] args) throws InterruptedException {

        String path = System.getProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://testuserautomation.github.io/DropDown/");

        //inspect over the Drop Down menu
        WebElement selectCitiesObj = driver.findElement(By.xpath("//select[@name='Cities']"));
        Select selectFromDropDownObj = new Select(selectCitiesObj);

        //select by index , index will start from 0 for first value
        selectFromDropDownObj.selectByIndex(0);
        // Wait for 2 sec
        Thread.sleep(2000);

        //select by value, value to be found in HTML DOM
        selectFromDropDownObj.selectByValue("Texas");
        // Wait for 3 sec
        Thread.sleep(3000);

        //select by Text given in the dropDownList
        selectFromDropDownObj.selectByVisibleText("CA");
        // Wait for 3 sec
        Thread.sleep(3000);

        //getOptions : to get all the options from the drop-down
        List <WebElement> allOptionsObj = selectFromDropDownObj.getOptions();

        for (WebElement getAllOptions : allOptionsObj)
            System.out.println(getAllOptions.getText());

        // For "Multi Select DropDown :Choose Bills to Pay"
        //isMultiple : Is it multi select drop-down if no then it returns false:
        boolean isSuccess = selectFromDropDownObj.isMultiple();
        System.out.println("\n" + isSuccess);

        //MultiSelect DropDown at Once
        WebElement selectBillsObj = driver.findElement(By.xpath("//select[@id='Bill']"));
        Select selectBillFromDropDownObj = new Select(selectBillsObj);
        selectBillFromDropDownObj.selectByValue("Travel");
        System.out.println(selectBillFromDropDownObj.getFirstSelectedOption().getText());
        selectBillFromDropDownObj.selectByIndex(2); // Select CreditCard
        //selectBillFromDropDownObj.selectByIndex(3); // Select DebitCard

        // Print a Log In message to the screen
        System.out.println("\nSuccessfully Done");

        // Maximize Browser
        driver.manage().window().maximize();

        // Wait for 5 sec
        Thread.sleep(5000);

        // Close the browser
        driver.close();
    }
}