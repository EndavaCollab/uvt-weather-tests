package com.weather.pageDefinitions;

import com.weather.ChromeWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    private ChromeWebDriver driver;
    private final By usernameField = By.id("login-email-input");
    private final By passwordField = By.id("login-password-input");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.tagName("mat-error");
    private final By createAccountButton = By.id("create-account-button");

    public LoginPage(ChromeWebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        WebElement element = driver.findElement(usernameField);
        element.sendKeys(username);
    }

    public void setPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement element = driver.findElement(loginButton);
        element.click();
    }

    public String getErrorMessage() {
        driver.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

    public List<String> getErrorMessages() {
        driver.getWebDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMessage));
        List<WebElement> elements = driver.findElements(errorMessage);
        List<String> errors = new ArrayList<>();
        elements.forEach(e -> errors.add(e.getText()));

        return errors;
    }

    public String getAlertMessage() {
        driver.getWebDriverWait().until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public RegistrationPage navigateToRegistrationPage() {
        driver.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(createAccountButton));
        driver.findElement(createAccountButton).click();

        return new RegistrationPage(driver);
    }
}