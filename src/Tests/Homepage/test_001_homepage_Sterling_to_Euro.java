package Tests.Homepage;

import Constants.Constants;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class test_001_homepage_Sterling_to_Euro {

    String actual;
    String expected;
    String outcome;

    @Test
    public void change_sterling_to_euro() {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        try
        {
            // GET VERSION
//            System.out.println("Version: " + Constants.AppVersion);
//            System.out.println();

            driver.navigate().to("http://public.htxdev.com/en/?ref=htx");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // VERIFY CURRENCY IS £ STERLING
            actual = driver.findElement(By.xpath("//*[@id=\"dropdownMenu2\"]/span[1]")).getText();
            expected = "£";

            assertThat(actual, equalTo(expected));

            if (actual.equals(expected))
            {
                outcome = "PASS";
            }
            else
            {
                outcome = "FAIL";
            }
            System.out.println();
            System.out.println(outcome + " Default Currency found is: " + actual);
            System.out.println();

            // SELECT CURRENCY US
            WebElement currency = driver.findElement(By.id("dropdownMenu2"));
            currency.click();

            // WAIT 2 SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT US
            driver.findElement(By.xpath("//*[@id=\"example-navbar-collapse\"]/ul/li[2]/section/ul/li[2]/ul/li[1]")).click();

            // WAIT 3 SECONDS
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            actual = driver.findElement(By.xpath("//*[@id=\"example-navbar-collapse\"]/ul/li[2]/section/ul/li[2]/ul/li[1]")).getText();
            expected = "€\n" +
                    "Euro";

            assertThat(actual, equalTo(expected));

            if (actual.equals(expected))
            {
                outcome = "PASS";
            }
            else
            {
                outcome = "FAIL";
            }

            System.out.println();
            System.out.println(outcome + " Currency changed to: " + actual);
            System.out.println();


            if (outcome.equals("PASS"))
            {
                System.out.println("PASSED TEST");
            }
            else
            {
                System.out.println("FAILED TEST");
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            driver.quit();
        }
    }
}
