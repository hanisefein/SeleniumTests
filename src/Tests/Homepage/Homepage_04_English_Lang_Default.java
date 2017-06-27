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

public class Homepage_04_English_Lang_Default {
    String actual;
    String expected;
    String outcome;

    @Test
    public void english_language_default() {
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

            // VERIFY ENGLISH LANGUAGE IS THE DEFAULT
            actual = driver.getCurrentUrl();
            expected = "http://public.htxdev.com/en/";

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
            System.out.println("Default Language found: " + actual + " : " + outcome);
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
