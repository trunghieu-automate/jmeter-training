package page.driver;

import org.openqa.selenium.WebDriver;

// Jmeter run test in parallel in nature, so this class will manage WebDriver object for parallel running
// Basic Thread-safe WebDriver object create, set and remove
public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public synchronized static WebDriver getDriver(){
        return driver.get();
    }

    public synchronized static void setDriver(WebDriver d){
        driver.set(d);
    }

    public synchronized static void remove(){
        driver.remove();
    }
}
