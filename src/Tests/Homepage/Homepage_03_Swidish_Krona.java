package Tests.Homepage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class Homepage_03_Swidish_Krona {

    String actual;
    String expected;
    String outcome;

    @Test
    public void swidish_krona() {
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

            // SELECT CURRENCY SWEDISH KRONA
            WebElement currency = driver.findElement(By.id("dropdownMenu2"));
            currency.click();

            // WAIT 2 SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT SWEDISH KRONA
            driver.findElement(By.xpath("//*[@id=\"example-navbar-collapse\"]/ul/li[2]/section/ul/li[2]/ul/li[4]/ul/li[24]")).click();

            // WAIT 3 SECONDS
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            actual = driver.findElement(By.xpath("//*[@id=\"dropdownMenu2\"]/span[1]")).getText();
            expected = "kr";

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