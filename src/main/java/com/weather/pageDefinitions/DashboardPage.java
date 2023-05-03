package com.weather.pageDefinitions;

import com.weather.ChromeWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class DashboardPage {
    private ChromeWebDriver driver;

    private final By confirmationMessage = By.tagName("app-dashboard");

    public DashboardPage(ChromeWebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage() {
        driver.getWebDriverWait().until(visibilityOfElementLocated(confirmationMessage));
        WebElement element = driver.findElement(confirmationMessage);
        return element.getText();
    }
}
