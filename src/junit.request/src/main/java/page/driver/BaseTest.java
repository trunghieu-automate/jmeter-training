package page.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.utils.PropertiesReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class BaseTest {
    private final String browser = PropertiesReader.get("browser");
    public synchronized WebDriver initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                if (browser.equalsIgnoreCase("chrome")) {
                    WebDriver driver = new ChromeDriver(OptionManager.getChromeOptions());
                    DriverManager.setDriver(driver);
                } else if (browser.equalsIgnoreCase("firefox")) {
                    WebDriver driver = new FirefoxDriver();
                    DriverManager.setDriver(driver);
                } else if (browser.equalsIgnoreCase("edge")) {
                    WebDriver driver = new EdgeDriver(OptionManager.getEdgeOption());
                    DriverManager.setDriver(driver);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(browser + " was initialized properly with implicit timeout: 10s");
        return DriverManager.getDriver();

    }

    // quit & remove driver
    public synchronized void removeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
        DriverManager.remove();
        System.out.println("Quit current driver successfully");
    }

    private void killBrowserTask(){
        Runtime runtime = Runtime.getRuntime();
        // Execute the command to kill all `chromedriver.exe`
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                runtime.exec("taskkill /F /IM chromedriver.exe /T");
            } else if (browser.equalsIgnoreCase("firefox")) {
                runtime.exec("taskkill /F /IM geckodriver.exe /T");
            } else if (browser.equalsIgnoreCase("edge")) {
                runtime.exec("taskkill /F /IM msedgedriver.exe /T");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
