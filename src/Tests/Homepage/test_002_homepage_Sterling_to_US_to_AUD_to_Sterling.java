package Tests.Homepage;


import Constants.Utils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class test_002_homepage_Sterling_to_US_to_AUD_to_Sterling {

    String actual;
    String expected;
    String outcome;

    @Test
    public void serling_to_us_to_aud_to_sterling() {


        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.17.0-win32\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        try
        {
            // GET VERSION
//            System.out.println("Version: " + Constants.AppVersion);
//            System.out.println();

            driver.navigate().to("http://public.htxdev.com/en/?ref=htx");

            Utils.wait(4);

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
            System.out.println("Found currency: " + actual + " : " + outcome);

            // WAIT 3 SECONDS
            Utils.wait(3);

            // CHANGE CURRENCY TO AUD
            WebElement currency2 = driver.findElement(By.id("dropdownMenu2"));
            currency2.click();

            // WAIT 3 SECONDS
            Utils.wait(3);

            // SELECT AUD
            driver.findElement(By.xpath("//*[@id=\"example-navbar-collapse\"]/ul/li[2]/section/ul/li[2]/ul/li[4]/ul/li[1]")).click();

            // WAIT 3 SECONDS
            Utils.wait(3);

            actual = driver.findElement(By.xpath("//*[@id=\"dropdownMenu2\"]/span[1]")).getText();
            expected = "AUD";

            assertThat(actual, equalTo(expected));

            if (actual.equals(expected))
            {
                outcome = "PASS";
            }
            else
            {
                outcome = "FAIL";
            }
            System.out.println("Found currency: " + actual + " : " + outcome);

            // CHANGE BACK TO STERLING £

            // WAIT
            Utils.wait(3);

            // CHANGE CURRENCY TO AUD
            WebElement currency3 = driver.findElement(By.id("dropdownMenu2"));
            currency3.click();

            // WAIT 3 SECONDS
            Utils.wait(3);

            // SELECT AUD
            driver.findElement(By.xpath("//*[@id=\"example-navbar-collapse\"]/ul/li[2]/section/ul/li[2]/ul/li[2]")).click();

            // WAIT 3 SECONDS
            Utils.wait(3);

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
            System.out.println("Found currency: " + actual + " : " + outcome);
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
