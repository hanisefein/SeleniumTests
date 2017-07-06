package Tests.Booking_Journey;


import Constants.Utils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class test_007_booking_j_pci_payment {

    String actual;
    String expected;
    String outcome;

    @Test
    public void booking_j_pci_payment() {

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
//            System.out.println("Version: " + AppVersion.AppVersion);
//            System.out.println();

            // NAVIGATE TO AFFILIATE URL
            driver.navigate().to("http://public.htxdev.com/en/?ref=ppcme");

            // WAIT FOR
            Utils.wait(4);

            // MAXIMIZE BROWSER WINDOW
            driver.manage().window().maximize();


            // CONDITIONS: RETURN BOOK 2 ADULTS, 1 CHILD, 1 INFANT,
            // MALTA TO VALETTA, PAY BY PCI


            // FROM AIRPORT: MALTA
            driver.findElement(By.id("pickup_name")).sendKeys("Malta");

            // WAIT FOR
            Utils.wait(4);

            // SELECT VALETTA
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(4);

            // TO AIRPORT: PLAYA DE LAS AMERICAS, ARONA
            driver.findElement(By.id("dropoff_name")).sendKeys("Valletta Merisi");

            // WAIT FOR
            Utils.wait(4);

            // SELECT
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(3);

            // CLICK BOOK NOW
            driver.findElement(By.id("js-booknow-btn")).click();

            // WAIT
            sleep(12000);

            // VERIFY OUT
            actual = driver.findElement(By.xpath("//*[@id=\"bookingSummaryScroll\"]/div[1]/dl[1]/dd[1]")).getText();
            expected = "Malta Airport, (MLA), Malta to Valletta Merisi Suites, Valletta, Valletta, Malta";

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
            System.out.println(outcome + " Expected outcome is : " + actual);
            System.out.println();

            // VERIFY RETURN
            actual = driver.findElement(By.xpath("//*[@id=\"bookingSummaryScroll\"]/div[1]/dl[2]/dd[1]")).getText();
            expected = "Valletta Merisi Suites, Valletta, Valletta, Malta to Malta Airport, (MLA), Malta";

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
            System.out.println(outcome + " Expected outcome is : " + actual);
            System.out.println();

            // WAIT
            Utils.wait(5);

            // SELECT SHUTTLE TRANSFER
            driver.findElement(By.xpath("//*[@id=\"product_553911\"]/article/div/div/footer/div[2]/button")).click();

            // WAIT
            sleep(12000);

            // START THE BOOKING PROCESS

            System.out.println("Form loaded...");

            // ENTER EMAIL ADDRESS
            driver.findElement(By.id("email")).sendKeys("john@gmail.com");

            // WAIT FOR
            Utils.wait(4);

            //  CONFIRM EMAIL
            driver.findElement(By.id("confirmemail")).sendKeys("john@gmail.com");

            // WAIT FOR
            Utils.wait(4);

            // TITLE
            driver.findElement(By.id("title")).sendKeys("Mr");

            // WAIT FOR
            Utils.wait(4);

            // FIRST NAME
            driver.findElement(By.id("firstname")).sendKeys("John");

            // WAIT FOR
            Utils.wait(4);

            // SURNAME
            driver.findElement(By.id("surname")).sendKeys("Smith");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // MOBILE NUMBER
            driver.findElement(By.id("mobile")).sendKeys("07777200000");

            // FILLED PASSENGER DETAILS
            System.out.println("Filled passenger details...");

            // WAIT
            Utils.wait(4);

            // OUTBOUND FLIGHT
            driver.findElement(By.id("arrivalflightno")).sendKeys("BA755");

            // WAIT
            Utils.wait(4);

            // DEPARTURE AIRPORT
            WebElement airport = driver.findElement(By.id("fromairportcode"));
            airport.click();

            airport.sendKeys("Fra");

            // FLUCHTNUMMER TERUGVLUCHT
            driver.findElement(By.id("departureflightno")).sendKeys("AB0123");

            // FILLED FLIGHT DETAILS
            System.out.println("Filled flight details...");

            // WAIT
            Utils.wait(4);

            // ACCOMMODATION DETAILS

            // ACCOMMODATION NAME
            driver.findElement(By.id("arrivalaccommodation")).sendKeys("Kings Hotel");

            // WAIT
            Utils.wait(4);

            // ADDRESS LINE 1
            driver.findElement(By.id("arrivaladdress1")).sendKeys("1");

            // WAIT
            Utils.wait(2);

            // ADDRESS LINE 2
            driver.findElement(By.id("arrivaladdress2")).sendKeys("Kings Way");

            // FILLED ACCOMMODATION DETAILS
            System.out.println("Filled accommodation details...");

            // WAIT
            Utils.wait(4);

            // SELECT VISA PAYMENT
            driver.findElement(By.id("cardpayment")).click();

            // WAIT
            Utils.wait(4);

            // ADDRESS LINE 1
            driver.findElement(By.id("accountaddress1")).sendKeys("1");

            // WAIT
            Utils.wait(4);

            // ADDRESS LINE 2
            driver.findElement(By.id("accountaddress2")).sendKeys("Kings Way");

            // WAIT FOR
            Utils.wait(4);

            // POST CODE
            driver.findElement(By.id("accountpostcode")).sendKeys("BN2 1KK");

            // WAIT FOR
            Utils.wait(4);

            // CLICK PLACE ORDER NOW
            driver.findElement(By.id("submit-checkout-form")).click();

            // WAIT FOR
            sleep(30000);

            // FILL IN PAYMENT DETAILS: CARD NUMBER
            driver.findElement(By.id("cardNumber")).sendKeys("4444333322221111");

            // WAIT
            Utils.wait(3);

            // FILL IN CARD HOLDER NAME
            driver.findElement(By.id("cardholderName")).sendKeys("Mr John Smith");

            // WAIT
            Utils.wait(3);

            // FILL EXPIRY DATE: MONTH
            WebElement month = driver.findElement(By.id("expiryMonth"));
            month.click();

            // WAIT
            Utils.wait(4);

            driver.findElement(By.xpath("")).sendKeys("04");



            // VERIFY CONFIRMATION PAGE IS DISPLAYED

            actual = driver.getCurrentUrl();
            expected = "https://public.htxdev.com/de/newbooking/confirmation";

            String bookingref = driver.findElement(By.xpath("/html/body/main/section[1]/div[1]/div/div[1]/h1/span")).getText();


            // WAIT FOR
            sleep(10000);

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
//        finally
//        {
//            driver.quit();
//        }
    }
}
