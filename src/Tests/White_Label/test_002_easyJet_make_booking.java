package Tests.White_Label;

import Constants.Constants;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class test_002_easyJet_make_booking {

    String actual;
    String expected;
    String outcome;

    @Test
    public void easyJet_make_booking() {

        //Firefox
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.17.0-win32\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hsefein\\Downloads\\chromedriver_win32\\chromedriver.exe");
//
//        // CHROME BROWSER
//        WebDriver driver = new ChromeDriver();

        try
        {
            // GET VERSION
//            System.out.println("Version: " + Constants.AppVersion);
//            System.out.println();

            // NAVIGATE TO AFFILIATE URL
            driver.navigate().to("http://public.htxdev.com/en/?ref=ezy");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // MAXIMIZE BROWSER WINDOW
            driver.manage().window().maximize();

            // CONDITIONS: BOOK 2 ADULTS, 1 CHILD, 1 INFANT, MAJORCA TO ALCUDIA, PAY BY PAYPAL

            // FROM AIRPORT: MAJORCA
            driver.findElement(By.id("pickup_name")).sendKeys("Majorca");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT MAJORCA
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // TO AIRPORT: ALCUDIA
            driver.findElement(By.id("dropoff_name")).sendKeys("Alcudiamar");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT ALCUDIA
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }


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

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK > IN CALENDER
            driver.findElement(By.xpath("//*[@id=\"pickupdatepicker\"]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]/span")).click();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT 15 OF THE MONTH
            driver.findElement(By.xpath("//*[@id=\"pickupdatepicker\"]/div/ul/li[1]/div/div[1]/table/tbody/tr[3]/td[7]")).click();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println(e);
            }

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

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                System.out.println(e);
            }

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

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

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

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

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

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

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


            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT SHUTTLE TRANSFER
            driver.findElement(By.xpath("//*[@id=\"product_567220\"]/article/div/div/footer/div[2]/button")).click();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (Exception e) {
                System.out.println(e);
            }


            // START THE BOOKING PROCESS

            // ENTER EMAIL ADDRESS
            driver.findElement(By.id("email")).sendKeys("john@gmail.com");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            //  CONFIRM EMAIL
            driver.findElement(By.id("confirmemail")).sendKeys("john@gmail.com");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // TITLE
            driver.findElement(By.id("title")).sendKeys("Mr");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // FIRST NAME
            driver.findElement(By.id("firstname")).sendKeys("John");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SURNAME
            driver.findElement(By.id("surname")).sendKeys("Smith");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // MOBILE NUMBER
            driver.findElement(By.id("mobile")).sendKeys("07777200000");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // OUTBOUND FLIGHT
            driver.findElement(By.id("arrivalflightno")).sendKeys("BA755");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

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
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT PAYPAL PAYMENT
            driver.findElement(By.id("paypalpayment")).click();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // ADDRESS LINE 1
            driver.findElement(By.id("accountaddress1")).sendKeys("1");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // ADDRESS LINE 2
            driver.findElement(By.id("accountaddress2")).sendKeys("Kings Way");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // POST CODE
            driver.findElement(By.id("accountpostcode")).sendKeys("BN2 1KK");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }


            // VERIFY PAYPAL BUTTON IS AVAILABLE
            Boolean actual1 = driver.findElement(By.id("paypal_submit")).isEnabled();
            Boolean expected1 = true;

            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (Exception e) {
                System.out.println(e);
            }

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
