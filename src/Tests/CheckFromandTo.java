package Tests;

import Constants.AppVersion;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CheckFromandTo {

    String actual;
    String expected;
    String outcome;

    @Test
    public void Check_From_and_To()
    {

            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();

            // START THE TESTING PROCESS
            try {

            // GET VERSION
            System.out.println("Version: " + AppVersion.AppVersion);
            System.out.println();

            driver.navigate().to("http://holidaytaxis.com");

            driver.manage().window().maximize();

            // PICK UP LOCATION: VEN
            driver.findElement(By.id("pickup_name")).sendKeys("ven");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT VENICE
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT DROP OFF LOCATION
            driver.findElement(By.id("dropoff_name")).sendKeys("city");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT VENICE CITY CENTRE
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // CLICK BOOK NOW
            driver.findElement(By.id("js-booknow-btn")).click();
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CHECK RESULT
            actual = driver.findElement(By.xpath("//*[@id=\"bookingSummaryScroll\"]/div[1]/dl[1]/dd[1]")).getText();
            expected = "Venice Marco Polo Airport, (VCE), Italy to Venice City Centre, Italy";

            assertThat(actual, equalTo(expected));
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println();

             // REPORT OUTCOME
            if (actual.equals(expected)) {
                outcome = "PASS";
            } else {
                outcome = "FAIL";
            }
            System.out.println(outcome);
            System.out.println();

            System.out.println("Expected Outcome: " + actual);
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
