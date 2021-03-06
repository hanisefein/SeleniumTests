package Tests.Booking_Journey;

import Constants.Utils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class test_004_booking_j_firefox_amex {

    String actual;
    String expected;
    String outcome;

    @Test
    public void booking_j_firefox_amex() {

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
            driver.navigate().to("http://public.htxdev.com/en/?ref=skc");

            // WAIT FOR
            Utils.wait(4);

            // MAXIMIZE BROWSER WINDOW
            driver.manage().window().maximize();

            // CONDITIONS: SINGLE BOOK 2 ADULTS, 1 CHILD, 1 INFANT, ALICANTE TO BENIDORM, PAY BY AMEX

            // SELECT SINGLE FROM AIRPORT
            driver.findElement(By.id("bookingtypesinglefromairport")).click();

            // WAIT FOR
            Utils.wait(4);

            // FROM AIRPORT: BARCELONA
            driver.findElement(By.id("pickup_name")).sendKeys("Barcelona");

            // WAIT FOR
            Utils.wait(4);

            // SELECT MAJORCA
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(3);

            // TO AIRPORT: ALCUDIA
            driver.findElement(By.id("dropoff_name")).sendKeys("Barcelona city centre");

            // WAIT FOR
            Utils.wait(3);

            // SELECT ALCUDIA
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(4);


            // CHANGE ARRIVAL DATE
            driver.findElement(By.id("pickupdate")).click();

            // WAIT FOR
            Utils.wait(4);

            // CLICK > IN CALENDER
            driver.findElement(By.xpath("//*[@id=\"pickupdatepicker\"]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]/span")).click();

            // WAIT FOR
            Utils.wait(4);

            // SELECT 15 OF THE MONTH
            driver.findElement(By.xpath("//*[@id=\"pickupdatepicker\"]/div/ul/li[1]/div/div[1]/table/tbody/tr[3]/td[7]")).click();

            // WAIT FOR
            Utils.wait(4);

            // CLICK CONTINUE
            driver.findElement(By.xpath("//*[@id=\"transfer_search\"]/section/div[2]/div/fieldset[3]/div[1]/div[3]/div[3]/button")).click();

            // WAIT FOR
            Utils.wait(4);

            // 1 CHILD
            driver.findElement(By.id("children")).sendKeys("1");

            // WAIT FOR
            Utils.wait(4);

            // 1 INFANT
            driver.findElement(By.id("infants")).sendKeys("1");

            // WAIT FOR
            Utils.wait(4);

            // CLICK BOOK NOW
            driver.findElement(By.id("js-booknow-btn")).click();

            // WAIT FOR
            Utils.wait(4);

            // VERIFY OUT DETAILS
            actual = driver.findElement(By.xpath("//*[@id=\"bookingSummaryScroll\"]/div[1]/dl[1]/dd[1]")).getText();
            expected = "Barcelona Airport, (BCN), Spain (Mainland) to Barcelona city centre";

            // WAIT FOR
            Utils.wait(4);

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

            // WAIT FOR
            Utils.wait(4);

            // VERIFY NUMBER OF PEOPLE
            actual = driver.findElement(By.xpath("//*[@id=\"bookingSummaryScroll\"]/div[2]/dl/dd")).getText();
            expected = "2 Adults,\n" +
                    "1 Children (3-11),\n" +
                    "1 Infants (0-2)";

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

            // SELECT SHUTTLE TRANSFER
            driver.findElement(By.xpath("/html/body/main/section[2]/div/div[1]/div/form[2]/article/div/div/footer/div[2]/button")).click();

            // WAIT FOR
            sleep(20000);
//            Utils.wait(30);

            // START THE BOOKING PROCESS

            System.out.println("Form Loaded...");

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

            airport.sendKeys("lon");

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
            Utils.wait(2);

            // SELECT AMEX PAYMENT
            WebElement cardtype = driver.findElement(By.id("cardtype"));
            cardtype.click();
            cardtype.sendKeys("American");

            // WAIT
            Utils.wait(4);

            // ENTER CARD NUMBER
            driver.findElement(By.id("cardnumber")).sendKeys("34343434343434");

            // WAIT FOR
            Utils.wait(4);

            // ENTER CARD SECURITY NUMBER
            driver.findElement(By.id("cardsecuritynumber")).sendKeys("1234");

            // WAIT FOR
            Utils.wait(4);

            // SELECT EXPIRY MONTH
            WebElement exmonth = driver.findElement(By.id("cardexpiremonth"));
            exmonth.click();
            exmonth.sendKeys("07");

            // WAIT FOR
            Utils.wait(4);

            // SELECT EXPIRY YEAR
            WebElement exyear = driver.findElement(By.id("cardexpireyear"));
            exyear.click();
            exyear.sendKeys("2019");

            // FILLED PAYMENT DETAILS
            System.out.println("Filled Payment details...");

            // WAIT FOR
            Utils.wait(4);

            // ADDRESS LINE 1
            driver.findElement(By.id("accountaddress1")).sendKeys("1");

            // WAIT FOR
            Utils.wait(4);

            // ADDRESS LINE 2
            driver.findElement(By.id("accountaddress2")).sendKeys("Kings Way");

            // WAIT FOR
            Utils.wait(4);

            // POST CODE
            driver.findElement(By.id("accountpostcode")).sendKeys("BN2 1KK");

            // FILLED ACCOMMODATION DETAILS
            System.out.println("Filled accommodation details...");

            // WAIT FOR
            sleep(9000);

            // CLICK PLACE ORDER NOW
            driver.findElement(By.id("submit-checkout-form")).click();

            // WAIT FOR
            sleep(30000);

            // VERIFY CONFIRMATION PAGE IS DISPLAYED

            actual = driver.getCurrentUrl();
            expected = "https://public.htxdev.com/en/newbooking/confirmation";

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
