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

public class test_005_google_airport_with_dates {

    String actual;
    String expected;
    String outcome;

    @Test
    public void google_airport_with_dates() {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        try
        {
            // GET VERSION
//            System.out.println("Version: " + Constants.AppVersion);
//            System.out.println();

            driver.navigate().to("http://public.htxdev.com/en/transfers/spain-mainland/barcelona-airport?bookingtypeid=1&adults=2&pickupdate=2017-06-21&pickuphour=15&pickupmin=15&pickupdatetime=2017-06-21T14%3A00&returndate=2017-06-24&returnhour=16&returnmin=45&returndatetime=2017-06-24T14%3A00&airportid=32&airportgroupid=1&airportgatewaytype=AIR&airporturl=barcelona-airport&airportgroupurl=spain-mainland&pickup=32&fromtype=AIR&fromcode=32&totype=RST");

            // WAIT FOR
            Utils.wait(3);

            // VERIFY PAGE IS LOADED
            actual = driver.getCurrentUrl();
            expected = "http://public.htxdev.com/en/transfers/spain-mainland/barcelona-airport?bookingtypeid=1&adults=2&pickupdate=2017-06-21&pickuphour=15&pickupmin=15&pickupdatetime=2017-06-21T14%3A00&returndate=2017-06-24&returnhour=16&returnmin=45&returndatetime=2017-06-24T14%3A00&airportid=32&airportgroupid=1&airportgatewaytype=AIR&airporturl=barcelona-airport&airportgroupurl=spain-mainland&pickup=32&fromtype=AIR&fromcode=32&totype=RST";

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
            expected = "Making your Barcelona Airport transfer easier";

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

            // VERIFY ARRIVAL DATE IS -8 DAYS FROM TODAY

            // GET TODAY'S DATE AND ADD -8
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, -8);
            date = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            actual = driver.findElement(By.id("pickupdate")).getAttribute("value");
            expected = sdf.format(date) + " at 15:15";

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


            // VERIFY RETURN DATE IS +3 DAYS FROM ARRIVAL

            // GET TODAY'S DATE AND ADD 3
            cal.setTime(date);
            cal.add(Calendar.DATE, 3);
            date = cal.getTime();

            actual = driver.findElement(By.id("returndate")).getAttribute("value");
            expected = sdf.format(date) + " at 16:45";

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
