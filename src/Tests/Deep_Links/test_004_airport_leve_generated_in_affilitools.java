package Tests.Deep_Links;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Hsefein on 29/06/2017.
 */
public class test_004_airport_leve_generated_in_affilitools {

    String actual;
    String expected;
    String outcome;

    @Test
    public void airport_level_generated_in_affilitools() {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        try
        {
            // GET VERSION
//            System.out.println("Version: " + Constants.AppVersion);
//            System.out.println();

            driver.navigate().to("http://public.htxdev.com/en/incoming/?IATA=ALC&resortid=13&bookingtypecode=RTN&htx_src=deeplink&currency=GBP&ref=htx");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // VERIFY PAGE IS LOADED
            actual = driver.getCurrentUrl();
            expected = "https://public.htxdev.com/en/airport-transfers/costa-blanca-alicante-airport/benidorm?&airportgroupid=1&pickup=3&dropoff=13&bookingtypeid=1&totype=RST&fromtype=AIR&pickupdate=2017-07-02&pickuphour=12&pickupmin=00&pickupdatetime=2017-07-02T12:00&returndate=2017-07-12&returnhour=12&returnmin=00&returndatetime=2017-07-12T12:00&adults=2&children=&infants=&search_source=deeplink&bookingtypeid=1&re-calculate=true&search_results_display=&iframe_width=";

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
            expected = "Making your Alicante Airport transfer to Benidorm easier";

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

            // VERIFY ARRIVAL DATE IS +3 DAYS FROM TODAY

            // GET TODAY'S DATE AND ADD 3
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, 3);
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
