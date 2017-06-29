package Tests.White_Label;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class test_016_singapore_make_booking {

    String actual;
    String expected;
    String outcome;

    @Test
    public void singapore_make_booking() {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.17.0-win32\\geckodriver.exe");

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
            driver.navigate().to("http://public.htxdev.com/en/?ref=sia");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // MAXIMIZE BROWSER WINDOW
            driver.manage().window().maximize();

            // CONDITIONS: BOOK 2 ADULTS, 1 CHILD, 1 INFANT, MALTA TO VALLETTA, PAY BY VISA

            // FROM AIRPORT: ALICANTE
            driver.findElement(By.id("pickup_name")).sendKeys("Malta");

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
            driver.findElement(By.id("dropoff_name")).sendKeys("Ursulino Valletta");
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


            // CHECK KRISFLYER ON TOP
            actual = driver.findElement(By.xpath("/html/body/section/div/div/div/span")).getText();
            expected = "Earn 1.5 KrisFlyer Miles for every 1USD spent on airport transfers worldwide";

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
            System.out.println(outcome + " KrisFlyer on top - Search Page");
            System.out.println();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CHECK KRISFLYER ON FOOTER
            actual = driver.findElement(By.xpath("/html/body/main/div[3]/ul/li[4]/span")).getText();
            expected = "KrisFlyer miles are only earned when you have paid for and completed all booked journeys.";

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
            System.out.println(outcome + " KrisFlyer on footer - Search Page");
            System.out.println();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(3);
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

            // CHECK KRISFLYER APPEARS ON TOP
            actual = driver.findElement(By.xpath("/html/body/section/div/div/div/span")).getText();
            expected = "Earn 1.5 KrisFlyer Miles for every 1USD spent on airport transfers worldwide";

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
            System.out.println(outcome + " KrisFlyer on top - List Page");
            System.out.println();

            // CHECK KRISFLYER APPEARS ON FOOTER
            actual = driver.findElement(By.xpath("/html/body/main/div[3]/ul/li[6]/span")).getText();
            expected = "Non-KrisFlyer members may also enjoy conxxe's best rates on ground transfers.";

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
            System.out.println(outcome + " KrisFlyer on footer - List Page");
            System.out.println();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT SHUTTLE TRANSFER
            driver.findElement(By.xpath("/html/body/main/section[2]/div/div[1]/div/form[1]/article/div/div/footer/div[2]/button")).click();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(10);
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
            airport.sendKeys("sin");
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

            // SELECT VISA PAYMENT
            WebElement cardtype = driver.findElement(By.id("cardtype"));
            cardtype.click();
            cardtype.sendKeys("Visa");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // ENTER CARD NUMBER
            driver.findElement(By.id("cardnumber")).sendKeys("4444333322221111");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // ENTER CARD SECURITY NUMBER
            driver.findElement(By.id("cardsecuritynumber")).sendKeys("123");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT EXPIRY MONTH
            WebElement exmonth = driver.findElement(By.id("cardexpiremonth"));
            exmonth.click();
            exmonth.sendKeys("07");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT EXPIRY YEAR
            WebElement exyear = driver.findElement(By.id("cardexpireyear"));
            exyear.click();
            exyear.sendKeys("2019");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(4);
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

            // CHECK KRISFLYER APPEARS ON TOP
            actual = driver.findElement(By.xpath("/html/body/section/div/div/div/span")).getText();
            expected = "Earn 1.5 KrisFlyer Miles for every 1USD spent on airport transfers worldwide";

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
            System.out.println(outcome + " KrisFlyer on top - Booking Page");
            System.out.println();

            // CHECK KRISFLYER APPEARS ON FOOTER
            actual = driver.findElement(By.xpath("/html/body/main/div[5]/ul/li[2]/span")).getText();
            expected = "You must be an existing KrisFlyer member to earn miles. To enrol please visit www.krisflyer.com.";

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
            System.out.println(outcome + " KrisFlyer on footer - Booking Page");
            System.out.println();

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                System.out.println(e);
            }

            // ACCOMMODATION ADDRESS 1
            driver.findElement(By.id("arrivaladdress1")).sendKeys("1");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // ACCOMMODATION ADDRESS 2
            driver.findElement(By.id("arrivaladdress2")).sendKeys("Kings Way");

            // WAIT IN SECONDS
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }



            // CLICK PLACE ORDER NOW
            driver.findElement(By.id("submit-checkout-form")).click();
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (Exception e) {
                System.out.println(e);
            }


            // VERIFY CONFIRMATION PAGE IS DISPLAYED

            actual = driver.getCurrentUrl();
            expected = "https://public.htxdev.com/en/newbooking/confirmation";

            String bookingref = driver.findElement(By.xpath("/html/body/main/section[1]/div[1]/div/div[1]/h1/span")).getText();


            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CHECK KRISFLYER APPEARS ON FOOTER
            actual = driver.findElement(By.xpath("/html/body/main/div[2]/ul/li[2]/span")).getText();
            expected = "You must be an existing KrisFlyer member to earn miles. To enrol please visit www.krisflyer.com.";

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
            System.out.println(outcome + " KrisFlyer on footer - Confirmation Page");
            System.out.println();

            if (actual.equals(expected))
            {
                outcome = "PASS";
            }
            else
            {
                outcome = "FAIL";
            }
            System.out.println();
            System.out.println("Booking Ref: " + bookingref);
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
