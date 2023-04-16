package testcasse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import page.driver.BaseTest;
import page.utils.JMeterContextHandler;

@RunWith(JUnit4.class)
public class SeleniumDevTest extends BaseTest {

    @Test
    public synchronized void getSeleniumHomePage_thenTitleIsOK() {
        JMeterContextHandler.startThread();
        WebDriver driver = initDriver();
        driver.get("https://selenium.dev/");
        System.out.println("Page's title: " + driver.getTitle());
        removeDriver();
        JMeterContextHandler.endThread();
    }
}
