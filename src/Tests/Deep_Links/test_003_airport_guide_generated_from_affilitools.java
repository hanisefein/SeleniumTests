package Tests.Deep_Links;


import Constants.Utils;
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

public class test_003_airport_guide_generated_from_affilitools {

    String actual;
    String expected;
    String outcome;

    @Test
    public void airport_guide_generated_from_affilitools() {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        try
        {
            // GET VERSION
//            System.out.println("Version: " + Constants.AppVersion);
//            System.out.println();

            driver.navigate().to("http://public.htxdev.com/en/incoming/?IATA=ALC&htx_src=deeplink&currency=GBP&ref=htx");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // VERIFY PAGE IS LOADED
            actual = driver.getCurrentUrl();
            expected = "https://public.htxdev.com/en/transfers/spain-mainland/costa-blanca-alicante-airport?bookingtypeid=1&adults=2&search_source=deeplink&pickupdate=2017-07-02&pickuphour=12&pickupmin=00&pickupdatetime=2017-07-02T12%3A00&returndate=2017-07-12&returnhour=12&returnmin=00&returndatetime=2017-07-12T12%3A00&airportid=3&airportgroupid=1&airportgatewaytype=AIR&airporturl=costa-blanca-alicante-airport&airportgroupurl=spain-mainland&pickup=3&fromtype=AIR&fromcode=3&totype=RST";

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

            // WAIT FOR
            Utils.wait(3);

            // VERIFY SEARCH TOOL HEADERS SHOWS ROUTE MAJORCA TO ALCUDIA
            actual = driver.findElement(By.xpath("//*[@id=\"transfer_search\"]/section/div[1]/section/div/h1")).getText();
            expected = "Making your Alicante Airport transfer easier";

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

            // WAIT FOR
            Utils.wait(3);

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
