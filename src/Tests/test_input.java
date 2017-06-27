package Tests;

import java.util.Scanner;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class test_input {


//   public static void main(String[] args) {
//
//       System.out.println("Please enter airport: ");
//       Scanner scanner = new Scanner(System.in);
//       String name = scanner.next();
//
//       System.out.println(name);
//
//   }
    public static class firsttest
    {
        @Test
        public void custom_booking()
        {

            System.out.println("Please enter airport: ");

            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();

            System.out.println(name);


            //Firefox
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");
            try
            {

                WebDriver driver = new FirefoxDriver();

                driver.navigate().to("http://public.htxdev.com");
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (Exception e) {
                    System.out.println(e);
                }

                driver.manage().window().maximize();

                // PICK UP LOCATION: VEN
//           driver.findElement(By.id("pickup_name")).sendKeys(name);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }

        }
    }




}