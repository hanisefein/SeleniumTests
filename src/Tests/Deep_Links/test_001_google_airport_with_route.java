package Tests.Deep_Links;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class test_001_google_airport_with_route {

    String actual;
    String expected;
    String outcome;

    @Test
    public void google_airport_with_route() {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        try
        {
            // GET VERSION
//            System.out.println("Version: " + Constants.AppVersion);
//            System.out.println();

            driver.navigate().to("http://public.htxdev.com/en/airport-transfers/majorca-palma-airport/alcudia/?gclid=CJi48prHpc4CFdQ_GwodWu0BNA");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // VERIFY PAGE IS LOADED
            actual = driver.getCurrentUrl();
            expected = "http://public.htxdev.com/en/airport-transfers/majorca-palma-airport/alcudia/?gclid=CJi48prHpc4CFdQ_GwodWu0BNA";

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
            System.out.println(outcome + " Page loaded");
            System.out.println();

            // WAIT 3 SECONDS
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // VERIFY SEARCH TOOL HEADERS SHOWS ROUTE MAJORCA TO ALCUDIA
            actual = driver.findElement(By.xpath("//*[@id=\"transfer_search\"]/section/div[1]/section/div/h1")).getText();
            expected = "Making your Majorca - Palma Airport transfer to Alcudia (Not Including Old Town) easier";

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
            System.out.println(outcome + " Expected header is displayed");
            System.out.println();

            // WAIT 3 SECONDS
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // VERIFY ARRIVAL DATE IS +7 DAYS FROM TODAY

            // GET TODAY'S DATE AND ADD 7
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, 7);
            date = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            actual = driver.findElement(By.id("pickupdate")).getAttribute("value");
            expected = sdf.format(date) + " at 12:00";

            assertThat(actual, equalTo(expected));

            if(actual.equals(expected))
            {
                outcome = "PASS";
            }
            else
            {
                outcome = "FAIL";
            }

            System.out.println();
            System.out.println(outcome + " Expected FROM date: " + actual);
            System.out.println();


            // VERIFY RETURN DATE IS +10 DAYS FROM ARRIVAL

            // GET TODAY'S DATE AND ADD 10
            cal.setTime(date);
            cal.add(Calendar.DATE, 10);
            date = cal.getTime();

            actual = driver.findElement(By.id("returndate")).getAttribute("value");
            expected = sdf.format(date) + " at 12:00";

            assertThat(actual, equalTo(expected));

            if(actual.equals(expected))
            {
                outcome = "PASS";
            }
            else
            {
                outcome = "FAIL";
            }

            System.out.println();
            System.out.println(outcome + " Expected TO date: " + actual);
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
