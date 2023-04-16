package page.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
    //Get Chrome Options
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--disable-extensions",
                "--disable-gpu",
                "--disable-setuid-sandbox",
                "--headless",
                "disable-infobars",
                "--disable-dev-shm-using",
                "--remote-allow-origins=*");
        return options;
    }

    public static EdgeOptions getEdgeOption() {
        EdgeOptions options = new EdgeOptions();
        /*options.addArguments(
                "--disable-extensions",
                "--disable-gpu",
                "--disable-setuid-sandbox",
                "--headless",
                "disable-infobars",
                "--disable-dev-shm-using",
                "--remote-allow-origins=*");*/
        return options;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless",
                "disable-infobars",
                "--disable-gpu",
                "--remote-allow-origins=*");
        return options;
    }
}
