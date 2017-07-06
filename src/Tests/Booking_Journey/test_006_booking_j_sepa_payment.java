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

public class test_006_booking_j_sepa_payment {

    String actual;
    String expected;
    String outcome;

    @Test
    public void booking_j_sepa_payment() {

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
            driver.navigate().to("http://public.htxdev.com/en/?ref=htde");

            // WAIT FOR
            Utils.wait(4);

            // MAXIMIZE BROWSER WINDOW
            driver.manage().window().maximize();


            // CONDITIONS: RETURN BOOK 2 ADULTS, 1 CHILD, 1 INFANT,
            // TENERIFE TO PLAYA DE LAS AMERICAS, PAY BY SEPA


            // FROM AIRPORT: BARCELONA
            driver.findElement(By.id("pickup_name")).sendKeys("Tenerife");

            // WAIT FOR
            Utils.wait(4);

            // SELECT MAJORCA
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(4);

            // TO AIRPORT: PLAYA DE LAS AMERICAS, ARONA
            driver.findElement(By.id("dropoff_name")).sendKeys("Playa de las");

            // WAIT FOR
            Utils.wait(4);

            // SELECT
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(3);

            // CLICK BOOK NOW
            driver.findElement(By.id("js-booknow-btn")).click();

            // WAIT FOR
            Utils.wait(9);

            // CHANGE LANGUAGE TO: DUTCH
            WebElement lang = driver.findElement(By.id("dropdownMenu1"));
            lang.click();

            // WAIT FOR
            Utils.wait(4);

            // SELECT GERMAN LANG
            driver.findElement(By.xpath("//*[@id=\"langDropdown\"]/ul/li[4]/a")).click();

            // WAIT FOR
            sleep(12000);

            // CLICK BOOK NOW AGAIN
            driver.findElement(By.id("js-booknow-btn")).click();

            // WAIT FOR
            Utils.wait(5);

            // SELECT JETZT BUCHEN
            driver.findElement(By.xpath("/html/body/main/section[2]/div/div[1]/div/form[1]/article/div/div/footer/div[2]/button")).click();

            // WAIT
            sleep(12000);

            // VERIFY AANKOMST
            actual = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[1]/dl[1]/dd[1]")).getText();
            expected = "Teneriffa-Süd (Reina Sofia) Flughafen nach Playa de las Américas";

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

            // VERIFY VERTREK
            actual = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[1]/dl[2]/dd[1]")).getText();
            expected = "Playa de las Américas nach Teneriffa-Süd (Reina Sofia) Flughafen";

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

            // START THE BOOKING PROCESS

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

            // SELECT IDEAL PAYMENT
            driver.findElement(By.id("idealpayment")).click();

            // WAIT
            Utils.wait(4);

            // BIC
            driver.findElement(By.id("elvbic")).sendKeys("1234");

            // WAIT
            Utils.wait(4);

            // IBAN
            driver.findElement(By.id("elviban")).sendKeys("DE56200800000120122000");

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

            // VERIFY CONFIRMATION PAGE IS DISPLAYED

            actual = driver.getCurrentUrl();
            expected = "https://public.htxdev.com/de/newbooking/confirmation";

            String bookingref = driver.findElement(By.xpath("/html/body/main/section[1]/div[1]/div/div[1]/h1/span")).getText();

//            Boolean actual1 = driver.findElement(By.id("submit-checkout-form")).isEnabled();
//            Boolean expected1 = true;

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
        finally
        {
            driver.quit();
        }
    }
}
