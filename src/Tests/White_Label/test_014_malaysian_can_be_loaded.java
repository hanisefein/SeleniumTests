package Tests.White_Label;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class test_014_malaysian_can_be_loaded {

    String actual;
    String expected;
    String outcome;

    @Test
    public void malaysian_can_be_loaded() {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        try
        {
            // GET VERSION
//            System.out.println("Version: " + Constants.AppVersion);
//            System.out.println();

            // NAVIGATE TO AFFILIATE URL
            driver.navigate().to("http://public.htxdev.com/en/?ref=mala");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // VERIFY DISPLAY AFFILIATE LOGO IS DISPLAYED
            Boolean actual1 = driver.findElement(By.xpath("//*[@id=\"toggleIcon\"]/div[2]/div[2]/a/img")).isDisplayed();
            Boolean expected1 = true;

            assertThat(actual1, equalTo(expected1));

            if (actual1 == expected1)
            {
                outcome = "PASS";
            }
            else
            {
                outcome = "FAIL";
            }
            System.out.println();
            System.out.println(outcome);
            System.out.println();

            if (outcome.equals("PASS"))
            {
                System.out.println("TEST PASSED");
            }
            else
            {
                System.out.println("TEST FAILED");
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
