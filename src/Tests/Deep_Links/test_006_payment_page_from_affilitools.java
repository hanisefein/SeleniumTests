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

public class test_006_payment_page_from_affilitools {

    String actual;
    String expected;
    String outcome;

    @Test
    public void payment_page_from_affilitools() {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        try
        {
            // GET VERSION
//            System.out.println("Version: " + AppVersion.AppVersion);
//            System.out.println();

            driver.navigate().to("http://public.htxdev.com/en/incoming/?productid=568849&bookingtypecode=RTN&departuredatetime=2017-08-22 15:15&arrivaldatetime=2017-08-21 10:55&pax=2,1,1&htx_src=deeplink&currency=GBP&ref=htx");

            // WAIT FOR
            Utils.wait(3);

            // VERIFY PAGE IS LOADED
            actual = driver.getCurrentUrl();
            expected = "https://public.htxdev.com/en/newbooking?bookingtypeid=1&adults=2&children=1&infants=1&search_source=deeplink&pickupdate=2017-08-21&pickuphour=10&pickupmin=55&pickupdatetime=2017-08-21T10%3A55&returndate=2017-08-22&returnhour=15&returnmin=15&returndatetime=2017-08-22T15%3A15&resortid=63&airportid=10&airportgroupid=2&airportgatewaytype=AIR&fromtype=AIR&fromcode=10&totype=RST&tocode=63&travelling=2017-08-21T10%3A55%3A00&returning=2017-08-22T15%3A15%3A00&pickup=10&dropoff=63&airporturl=tenerife-south-airport-reina-sofia&airportgroupurl=spain-canary-islands&productid=568849&submit=0&currencycode=GBP&price=28.5&oldprice=0&shuttle_transfer=1";

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

            // VERIFY ARRIVING DETAILS
            actual = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[1]/dl[1]/dd[1]")).getText();
            expected = "Tenerife - South Airport (Reina Sofia) to Costa Adeje";

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
            System.out.println(outcome + " Expected Arriving details is displayed");
            System.out.println();

            // WAIT 3 SECONDS
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // GET TODAY'S DATE AND ADD +52
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, +52);
            date = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            // VERIFY ARRIVING DATE
            actual = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[1]/dl[1]/dd[2]/strong[1]")).getText();
            expected = sdf.format(date);

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
            System.out.println(outcome + " Expected Arriving date is displayed");
            System.out.println();

            // WAIT FOR
            Utils.wait(3);

            // VERIFY ARRIVING DATE
            actual = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[1]/dl[1]/dd[2]/strong[2]")).getText();
            expected = "10:55";

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
            System.out.println(outcome + " Expected Arriving time is displayed");
            System.out.println();

            // WAIT FOR
            Utils.wait(3);

            // VERIFY DEPARTING DETAILS
            actual = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[1]/dl[2]/dd[1]")).getText();
            expected = "Costa Adeje to Tenerife - South Airport (Reina Sofia)";

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
            System.out.println(outcome + " expected departing details");
            System.out.println();

            // GET TODAY'S DATE AND ADD +1
            cal.setTime(date);
            cal.add(Calendar.DATE, 1);
            date = cal.getTime();

            actual = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[1]/dl[2]/dd[2]/strong[1]")).getText();
            expected = sdf.format(date);

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


            // VERIFY DEPARTING TIME
            actual = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[1]/dl[2]/dd[2]/strong[2]")).getText();
            expected = "15:15";

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
            System.out.println(outcome + " Expected departing time: " + actual);
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
