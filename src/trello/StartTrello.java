package trello;

import org.openqa.selenium.WebDriver;
import trello.model.ScreenShotMaker;
import trello.pageobjects.*;

import java.util.concurrent.TimeUnit;

public class StartTrello {

    private void start() {
        WebDriver driver = DriverFactory.getDriver();

        //use the below line instead of the above one, if want to run on remote
//        WebDriver driver = DriverFactory.getRemoteWebDriver();

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
