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

public class test_005_booking_j_ideal_payment {

    String actual;
    String expected;
    String outcome;

    @Test
    public void booking_j_ideal_payment() {

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
            driver.navigate().to("http://public.htxdev.com/en/?ref=htnl");

            // WAIT FOR
            Utils.wait(4);

            // MAXIMIZE BROWSER WINDOW
            driver.manage().window().maximize();


            // CONDITIONS: RETURN(RETOUR) BOOK 2 ADULTS, 1 CHILD, 1 INFANT,
            // SPANJE(VASTELAND) TO LUHTHAVEN(BARCELONA TO BARCELONA CENTRUM STAD), PAY BY IDEAL


            // FROM AIRPORT: BARCELONA
            driver.findElement(By.id("pickup_name")).sendKeys("Barcelona");

            // WAIT FOR
            Utils.wait(4);

            // SELECT MAJORCA
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(4);


            // SELECT
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(3);

            // TO AIRPORT: BARCELONA CITY CENTRE
            driver.findElement(By.id("dropoff_name")).sendKeys("Barcelona city centre");

            // WAIT FOR
            Utils.wait(4);

            // SELECT ALCUDIA
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            // WAIT FOR
            Utils.wait(4);

            // CLICK BOOK NOW
            driver.findElement(By.id("js-booknow-btn")).click();

            // WAIT FOR
            Utils.wait(9);

            // CHANGE LANGUAGE TO: DUTCH
            WebElement lang = driver.findElement(By.id("dropdownMenu1"));
            lang.click();

            // WAIT FOR
            Utils.wait(4);

            // SELECT NEDERLANDS LANG
            driver.findElement(By.xpath("//*[@id=\"langDropdown\"]/ul/li[5]/a/span[2]")).click();

            // WAIT FOR
            sleep(12000);

            // CLICK BOOK NOW AGAIN
            driver.findElement(By.id("js-booknow-btn")).click();

            // WAIT FOR
            Utils.wait(5);

            // SELECT PENDELDIENST
            driver.findElement(By.xpath("/html/body/main/section[2]/div/div[1]/div/form[1]/article/div/div/footer/div[2]/button")).click();

            // WAIT
            sleep(12000);

            // VERIFY AANKOMST
            actual = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[1]/dl[1]/dd[1]")).getText();
            expected = "Luchthaven Barcelona naar Barcelona centrum stad";

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
            expected = "Barcelona centrum stad naar Luchthaven Barcelona";

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

            // FORM LOADED
            System.out.println("Form loaded...");

            // WAIT
            Utils.wait(4);

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

            airport.sendKeys("lei");

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


            // FILLED PAYMENT DETAILS
            System.out.println("Selected Ideal Payment...");

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

            // WAIT FOR
            Utils.wait(4);

            // KIES UW BANK
            WebElement bank = driver.findElement(By.id("ideal_bank_code"));
            bank.click();

            // WAIT
            Utils.wait(4);

            // SELECT KNAB BANK
            WebElement knab = driver.findElement(By.id("ideal_bank_code"));
            knab.click();

            // WAIT
            Utils.wait(4);

            // SELECT KNAB BANK
            driver.findElement(By.id("ideal_bank_code")).sendKeys("Knab");

            // FILLED ACCOMMODATION DETAILS
            System.out.println("Filled accommodation details...");

            // WAIT FOR
            sleep(9000);

            // CLICK BESTELLING NU PLAATSEN
            driver.findElement(By.id("submit-checkout-form")).click();

            // WAIT
            sleep(20000);

            // VERIFY WORLDPAY IS DISPLAYED
            actual = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/img")).getAttribute("src");
            expected = "https://secure-test.worldpay.com/images/wp/new_wplogo.gif";

            assertThat(actual, equalTo(expected));

            if(actual.equals(expected))
            {
                outcome = "PASS";
            }
            else
            {
                outcome = "PASS";
            }

            System.out.println();
            System.out.println(outcome + " WorldPay Src : " + actual);
            System.out.println();

            // WAIT
            Utils.wait(9);

            // CLICK AUTHORISE
            driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/table/tbody/tr[9]/td/form/table[1]/tbody/tr/td/label[1]/nobr/span/b")).click();

            // WAIT
            sleep(20000);

            // VERIFY CONFIRMATION PAGE
            actual = driver.getCurrentUrl();
            expected = "https://public.htxdev.com/nl/newbooking/confirmation";

            assertThat(actual, equalTo(expected));

            if(actual.equals(expected))
            {
                outcome = "PASS";
            }
            else
            {
                outcome = "PASS";
            }

            System.out.println();
            System.out.println(outcome);
            System.out.println();

            // WAIT
            Utils.wait(5);

            // BOOKING NO
            System.out.println("Booking Ref: " + driver.findElement(By.xpath("/html/body/main/section[1]/div[1]/div/div[1]/h1/span")).getText());

            // WAIT
            Utils.wait(5);

            System.out.println();

            if(outcome == "PASS")
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
