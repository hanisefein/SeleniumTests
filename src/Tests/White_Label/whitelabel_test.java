package Tests.White_Label;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class whitelabel_test {

    @Test
    public void test1() throws Exception {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://public.htxdev.com/en/?ref=skc");
        assertEquals(driver.getCurrentUrl(), "http://public.htxdev.com/en/");
        System.out.println("PASS");
    }

    @Test
    public void test2() throws Exception {

        //Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hsefein\\Downloads\\geckodriver-v0.11.1-win32 (1)\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://public.htxdev.com/en/?ref=skc");
        assertEquals(driver.getTitle(), "Airport Transfers & Shuttles - Low Cost & Reliable Taxi Transfers");
        System.out.println("PASS");
    }

}
