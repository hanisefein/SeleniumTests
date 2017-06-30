package Tests;

import Constants.AppVersion;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class WholeBooking {

    String actual;
    String expected;
    String outcome;
    String name;

    @Test
    public void Whole_Booking_Journey()
    {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");

        // IE
//        System.setProperty("webdriver.ie.driver", "C:\\Users\\Hsefein\\Downloads\\IEDriverServer_Win32_3.1.0\\IEDriverServer.exe");

        // Chrome
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hsefein\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

        //IE
        WebDriver driver = new FirefoxDriver();
//        System.out.println("Please enter airport: ");
//
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.next();


        // START THE TESTING PROCESS
        try {

            // GET VERSION
            System.out.println("Version: " + AppVersion.AppVersion);
            System.out.println();

            driver.navigate().to("http://public.htxdev.com");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            driver.manage().window().maximize();

            // PICK UP LOCATION: VEN
            driver.findElement(By.id("pickup_name")).sendKeys("Prague");
//            driver.findElement(By.id("pickup_name")).sendKeys(name);


            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT PRAGUE AIRPORT
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT DROP OFF LOCATION
            driver.findElement(By.id("dropoff_name")).sendKeys("Hilton");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT HILTON PRAGUE
            driver.findElement(By.className("ui-helper-hidden-accessible")).click();

            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK ARRIVAL DATE
            driver.findElement(By.id("pickupdate")).click();

            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT 12 MARCH
            driver.findElement(By.xpath("//*[@id=\"pickupdatepicker\"]/div/ul/li[1]/div/div[1]/table/tbody/tr[3]/td[1]")).click();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK CONTINUE
            driver.findElement(By.xpath("//*[@id=\"transfer_search\"]/section/div[2]/div/fieldset[3]/div[1]/div[3]/div[3]/button")).click();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK DEPARTURE DATE
            driver.findElement(By.id("returndate")).click();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK > TO GO TO NEXT MONTH (APRIL)
            driver.findElement(By.xpath("//*[@id=\"returndatepicker\"]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]")).click();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK > TO GO TO NEXT MONTH (MAY)
            driver.findElement(By.xpath("//*[@id=\"returndatepicker\"]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]")).click();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK > TO GO TO NEXT MONTH (JUNE)
            driver.findElement(By.xpath("//*[@id=\"returndatepicker\"]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]")).click();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            //SELECT DATE 12 JUNE
            driver.findElement(By.xpath("//*[@id=\"returndatepicker\"]/div/ul/li[1]/div/div[1]/table/tbody/tr[3]/td[2]")).click();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK CONTINUE
            driver.findElement(By.xpath("//*[@id=\"transfer_search\"]/section/div[2]/div/fieldset[3]/div[3]/div[3]/div[3]/button")).click();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT ADULTS 3
            WebElement adults = driver.findElement(By.id("adults"));
            adults.click();
            adults.sendKeys("3");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT CHILDREN 1

            WebElement children = driver.findElement(By.id("children"));
            children.click();
            children.sendKeys("1");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // SELECT INFANTS 2

            WebElement infants = driver.findElement(By.id("infants"));
            infants.click();
            infants.sendKeys("2");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }


            // CLICK BOOK NOW
            driver.findElement(By.id("js-booknow-btn")).click();
            try {
                TimeUnit.SECONDS.sleep(7);
            } catch (Exception e) {
                System.out.println(e);
            }

//            // CHECK RESULT
//            actual = driver.findElement(By.xpath("//*[@id=\"bookingSummaryScroll\"]/div[1]/dl[1]/dd[1]")).getText();
//            expected = "Prague Airport, (PRG), Czech Republic to Hilton Prague, Pobrezni, Prague, Czech Republic";
//
//            assertThat(actual, equalTo(expected));
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            System.out.println();
//
//            // REPORT OUTCOME
//            if (actual.equals(expected)) {
//                outcome = "PASS";
//            } else {
//                outcome = "FAIL";
//            }
//            System.out.println(outcome);
//            System.out.println();
//
//            System.out.println("Expected Outcome: " + actual);
//            System.out.println();

            // SELECT SHUTTLE TRANSFER
            driver.findElement(By.xpath("//*[@id=\"product_450371\"]/article/div/div/footer/div[2]/button")).click();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }



            //  CLICK ON ADVANCED BUTTON
            driver.findElement(By.id("advancedButton")).click();
            try {
                TimeUnit.SECONDS.sleep(8);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK ON ADD EXCEPTION BUTTON
            driver.findElement(By.id("exceptionDialogButton")).click();
            try {
                TimeUnit.SECONDS.sleep(12);
            } catch (Exception e) {
                System.out.println(e);
            }


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


            // CARD TYPE
            WebElement card = driver.findElement(By.id("cardtype"));
            card.click();
            card.sendKeys("Vi");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CARD NUMBER
            driver.findElement(By.id("cardnumber")).sendKeys("4444333322221111");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CARD SECURITY
            driver.findElement(By.id("cardsecuritynumber")).sendKeys("123");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CARD EXPIRY MONTH
            WebElement month = driver.findElement(By.id("cardexpiremonth"));
            month.click();
            month.sendKeys("08");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CARD EXPIRY YEAR
            WebElement year = driver.findElement(By.id("cardexpireyear"));
            year.click();
            year.sendKeys("2018");
            try {
                TimeUnit.SECONDS.sleep(3);
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
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e);
            }

            // CLICK PLACE ORDER NOW
            driver.findElement(By.id("submit-checkout-form")).click();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                System.out.println(e);
            }


            // TEST OUTCOME
            System.out.println("TEST PASS");

        }
        catch (Exception e)
        {
            System.out.println(e);

        }
//        finally
//        {
//            driver.quit();
//        }

    }
}