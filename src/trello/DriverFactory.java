package trello;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

class DriverFactory {

    private static WebDriver driver = null;
    private static Dimension dimension = new Dimension(1600, 600);

    public static WebDriver getDriver() {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(dimension);
        return driver;
    }

    public static WebDriver getRemoteWebDriver() {
        try {
            driver = new RemoteWebDriver(new URL("http://visko.dyndns.hu:61983/wd/hub"), DesiredCapabilities.firefox());
            driver.manage().window().setSize(dimension);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
