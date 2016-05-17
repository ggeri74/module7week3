package trello;

import org.openqa.selenium.WebDriver;
import trello.business.DriverFactory;
import trello.business.ScreenShotMaker;
import trello.pageobjects.*;


import java.util.concurrent.TimeUnit;

import static trello.business.DriverFactory.WebDriverType.*;

public class StartTrello {

    private void start() {

        // Use FIREFOXDRIVER or REMOTEWEBDRIVER enum as parameter to choose between drivers
        WebDriver driver = DriverFactory.getDriver(FIREFOXDRIVER);

        try {
            trelloTest(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        new StartTrello().start();
    }

    private void trelloTest(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TrelloMainPage mainPage = new TrelloMainPage(driver);
        TrelloLoginPage loginPage = mainPage.clickLoginButton();
        loginPage.loginToTrello();
        mainPage.addCard();
        ScreenShotMaker ssmaker = new ScreenShotMaker(driver);
        ssmaker.takeScreenshot();
        mainPage.moveCardToDoneColumn();
        ssmaker.takeScreenshot();
    }
}
