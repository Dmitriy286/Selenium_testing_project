import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class SeleniumTest {
    @Test
    public void testGoToProduct() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
//        WebElement button1 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[1]/button/a"));
        WebElement button1 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/button"));
        button1.click();

        WebElement text1 = driver.findElement(By.xpath("/html/body/div/div/div/h1"));

        String expected = "Mens Casual Premium Slim Fit T-Shirts";
        String actual = text1.getText();

        assertEquals(expected, actual);

        driver.close();

    }

    @Test
    public void testFilterSelection() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");

        //region вариант с action
        WebElement button0 = driver.findElement(By.xpath("/html/body/div/div/header/nav[1]/div[1]/button"));

        Actions action = new Actions(driver);
        action.moveToElement(button0).click().perform();

        WebElement button1 = driver.findElement(By.xpath("/html/body/div/div/header/nav[1]/div[1]/div/div[2]/a"));
        button1.click();
        //endregion

        //region вариант с JS скриптом
//        WebElement button1 = driver.findElement(By.xpath("/html/body/div/div/header/nav[1]/div[1]/div/div[2]/a"));
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", button1);
        //endregion

        WebElement checkbox1 = driver.findElement(By.xpath("/html/body/div/div/div/fieldset/form/div[5]/div[2]/input"));
        checkbox1.click();

        WebElement button2 = driver.findElement(By.xpath("/html/body/div/div/div/fieldset/form/button[1]"));
        button2.click();

//        WebElement cardsQuantity = driver.findElements(By.ByClassName("card")).size();

        List<WebElement> list = driver.findElements(By.className("card"));
        System.out.println("List of elements");
        System.out.println(list);

        int expected = 2;
        int actual = driver.findElements(By.className("card")).size();
//        int actual = list.size();
        System.out.println("actual:");
        System.out.println(actual);

        assertEquals(expected, actual);
        assertThat(expected, equalTo(actual));

        driver.close();

    }

//    public static void setup() {
//
////        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
//
//
//    }



}
