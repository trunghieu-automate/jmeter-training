package testcasse;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.driver.BaseTest;
import page.utils.JMeterContextHandler;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public synchronized void login_thenDashboardIsDisplayed() {
        JMeterContextHandler.startThread();
        WebDriver driver = initDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[contains(.,'Dashboard')]")));
        removeDriver();
        JMeterContextHandler.endThread();
    }
}
