package Tests.Booking_Journey;


import Constants.Utils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class test_003_booking_j_ie11_paypal {

    String actual;
    String expected;
    String outcome;

    @Test
    public void booking_journey_ie11_paypal() {

//        //IE 11
//        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        System.setProperty("webdriver.ie.driver", "C:\\Users\\Hsefein\\Downloads\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
//
//        WebDriver driver = new InternetExplorerDriver(ieCapabilities);

        // FIREFOX
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.17.0-win32\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();


        try
        {
            // GET VERSION
//            System.out.println("Version: " + AppVersion.AppVersion);
//            System.out.println();

            // NAVIGATE TO AFFILIATE URL
            driver.navigate().to("http://public.htxdev.com/en/?ref=htx");

            // WAIT FOR
            Utils.wait(4);

            // CONDITIONS: BOOK 2 ADULTS, 1 CHILD, 1 INFANT, MAJORCA TO ALCUDIA, PAY BY PAYPAL

            // FROM AIRPORT: MAJORCA
            driver.findElement(By.id("pickup_name")).sendKeys("Majorca");

            // WAIT FOR
            Utils.wait(4);

            // SELECT MAJORCA
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(3);

            // TO AIRPORT: ALCUDIA
            driver.findElement(By.id("dropoff_name")).sendKeys("Alcudiamar");

            // WAIT FOR
            Utils.wait(3);

            // SELECT ALCUDIA
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(4);


//            // GET CURRENT DATE:
//            String currArrivaleDate = driver.findElement(By.id("pickupdate")).getAttribute("value").toString();
//            Calendar cal = Calendar.getInstance();
//
//            // ADD 12 DAYS TO CURRENT ARRIVAL DATE
//            cal.add(Calendar.MONTH, +1);
//            System.out.println(cal.getTime());
//
//            // WAIT IN SECONDS
//            try {
//                TimeUnit.SECONDS.sleep(4);
//            } catch (Exception e) {
//                System.out.println(e);
//            }

            // CHANGE ARRIVAL DATE
            driver.findElement(By.id("pickupdate")).click();

            // WAIT FOR
            Utils.wait(2);

            // CLICK > IN CALENDER
            driver.findElement(By.xpath("//*[@id=\"pickupdatepicker\"]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]/span")).click();

            // WAIT FOR
            Utils.wait(2);

            // SELECT 15 OF THE MONTH
            driver.findElement(By.xpath("//*[@id=\"pickupdatepicker\"]/div/ul/li[1]/div/div[1]/table/tbody/tr[3]/td[7]")).click();

            // WAIT FOR
            Utils.wait(2);

            // CLICK CONTINUE
            driver.findElement(By.xpath("//*[@id=\"transfer_search\"]/section/div[2]/div/fieldset[3]/div[1]/div[3]/div[3]/button")).click();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println(e);
            }


            // 1 CHILD
            driver.findElement(By.id("children")).sendKeys("1");

            // WAIT FOR
            Utils.wait(2);
            // 1 INFANT
            driver.findElement(By.id("infants")).sendKeys("1");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK BOOK NOW
            driver.findElement(By.id("js-booknow-btn")).click();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                System.out.println(e);
            }

            // VERIFY OUT DETAILS
            actual = driver.findElement(By.xpath("//*[@id=\"bookingSummaryScroll\"]/div[1]/dl[1]/dd[1]")).getText();
            expected = "Majorca - Palma Airport, (PMI), Spain (Balearic Islands) to Alcudiamar Botel, 1, Paseo Marítimo, Alcudia, Spain";

            // WAIT FOR
            Utils.wait(2);

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
            System.out.println(outcome + " OUT: " + expected);
            System.out.println();

            // VERIFY RETURN DETAILS
            actual = driver.findElement(By.xpath("//*[@id=\"bookingSummaryScroll\"]/div[1]/dl[2]/dd[1]")).getText();
            expected = "Alcudiamar Botel, 1, Paseo Marítimo, Alcudia, Spain to Majorca - Palma Airport, (PMI), Spain (Balearic Islands)";

            // WAIT FOR
            Utils.wait(2);

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
            System.out.println(outcome + " RETURN: " + expected);
            System.out.println();

            // VERIFY NUMBER OF PEOPLE
            actual = driver.findElement(By.xpath("//*[@id=\"bookingSummaryScroll\"]/div[2]/dl/dd")).getText();
            expected = "2 Adults,\n" +
                    "1 Children (3-11),\n" +
                    "1 Infants (0-2)";

            // WAIT FOR
            Utils.wait(2);

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
            System.out.println(outcome + " RETURN: " + expected);
            System.out.println();


            // WAIT FOR
            Utils.wait(2);

            // SELECT SHUTTLE TRANSFER
            driver.findElement(By.xpath("//*[@id=\"product_567220\"]/article/div/div/footer/div[2]/button")).click();

            // WAIT FOR
            Utils.wait(15);


            // START THE BOOKING PROCESS

            // ENTER EMAIL ADDRESS
            driver.findElement(By.id("email")).sendKeys("john@gmail.com");

            // WAIT FOR
            Utils.wait(2);

            //  CONFIRM EMAIL
            driver.findElement(By.id("confirmemail")).sendKeys("john@gmail.com");

            // WAIT FOR
            Utils.wait(2);

            // TITLE
            driver.findElement(By.id("title")).sendKeys("Mr");

            // WAIT FOR
            Utils.wait(2);

            // FIRST NAME
            driver.findElement(By.id("firstname")).sendKeys("John");

            // WAIT FOR
            Utils.wait(2);

            // SURNAME
            driver.findElement(By.id("surname")).sendKeys("Smith");

            // WAIT FOR
            Utils.wait(2);

            // MOBILE NUMBER
            driver.findElement(By.id("mobile")).sendKeys("07777200000");

            // WAIT FOR
            Utils.wait(3);

            // OUTBOUND FLIGHT
            driver.findElement(By.id("arrivalflightno")).sendKeys("BA755");

            // WAIT FOR
            Utils.wait(2);

            // DEPARTURE AIRPORT
            WebElement airport = driver.findElement(By.id("fromairportcode"));
            airport.click();
            airport.sendKeys("lon");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // INBOUND FLIGHT
            driver.findElement(By.id("departureflightno")).sendKeys("LF55");

            // WAIT FOR
            Utils.wait(6);

            // ACCOMMODATION NAME, ADDRESS LINE 2
            driver.findElement(By.id("arrivaladdress2")).sendKeys("Spain");

            // WAIT FOR
            Utils.wait(4);

            // SELECT PAYPAL PAYMENT
            driver.findElement(By.id("paypalpayment")).click();

            // WAIT FOR
            Utils.wait(2);

            // ADDRESS LINE 1
            driver.findElement(By.id("accountaddress1")).sendKeys("1");

            // WAIT FOR
            Utils.wait(3);

            // ADDRESS LINE 2
            driver.findElement(By.id("accountaddress2")).sendKeys("Kings Way");

            // WAIT FOR
            Utils.wait(3);

            // POST CODE
            driver.findElement(By.id("accountpostcode")).sendKeys("BN2 1KK");

            // WAIT FOR
            Utils.wait(4);

            // VERIFY PAYPAL BUTTON IS AVAILABLE
            Boolean actual1 = driver.findElement(By.id("paypal_submit")).isEnabled();
            Boolean expected1 = true;

            // WAIT FOR
            Utils.wait(20);

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
//        finally
//        {
//            driver.quit();
//        }
    }

}
