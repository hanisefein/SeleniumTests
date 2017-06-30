package Tests;

import Constants.AppVersion;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FirstTest
{

    String actual;
    String expected;
    String outcome;

    @Test
    public void Test1()
    {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://www.holidaytaxis.com");

        try {

            // to maximize screen
            driver.manage().window().maximize();

            // check if social facebook img is there
            actual = driver.findElement(By.xpath("/html/body/main/section[7]/div/article/div[2]/a[1]/img")).getTagName();
            expected = "img";

            // comparing actual with expected outcome
            assertThat(actual, equalTo(expected));

            if (actual.equals(expected)) {
                outcome = "PASS";
            } else {
                outcome = "FAIL";
            }
            System.out.println("Version " + AppVersion.AppVersion);
            System.out.println();

            System.out.println(outcome + " found social " + expected + " Facebook");
            System.out.println();

            // check if social twitter img found
            actual = driver.findElement(By.xpath("/html/body/main/section[7]/div/article/div[2]/a[2]/img")).getTagName();
            expected = "img";

            // comparing actual with expected outcome
            assertThat(actual, equalTo(expected));

            if (actual.equals(expected)) {
                outcome = "PASS";
            } else {
                outcome = "FAIL";
            }
            System.out.println(outcome + " found social " + expected + " Twitter");
            System.out.println();

            // check if social google plus img found
            actual = driver.findElement(By.xpath("/html/body/main/section[7]/div/article/div[2]/a[3]/img")).getTagName();
            expected = "img";

            // comparing actual with expected outcome
            assertThat(actual, equalTo(expected));

            if (actual.equals(expected)) {
                outcome = "PASS";
            } else {
                outcome = "FAIL";
            }
            System.out.println(outcome + " found social " + expected + " Google Plus");
            System.out.println();
            System.out.println("TEST PASS");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            driver.quit();
        }

    }

}
