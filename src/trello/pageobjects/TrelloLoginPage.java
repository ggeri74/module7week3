package trello.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import trello.model.Credentials;

public class TrelloLoginPage extends Page {

    TrelloLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("user");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login");


    public void loginToTrello(){
        Credentials credentials = Credentials.readFromConsole();
        driver.findElement(emailField).sendKeys(credentials.getUsername());
        driver.findElement(passwordField).sendKeys(credentials.getPassword());
        driver.findElement(loginButton).click();
    }

}
