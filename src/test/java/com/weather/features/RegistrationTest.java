package com.weather.features;

import com.weather.ChromeWebDriver;
import com.weather.pageDefinitions.LoginPage;
import com.weather.pageDefinitions.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTest {
    private ChromeWebDriver driver;
    private RegistrationPage registrationPage;

    @Before
    public void setup() {
        driver = new ChromeWebDriver();
        driver.get("http://localhost:4200/auth");
        LoginPage loginPage = new LoginPage(driver);
        registrationPage = loginPage.navigateToRegistrationPage();
    }

    @Test
    public void canRegisterNewAccount() {
        registrationPage.setUsername("username");
        registrationPage.setEmail("email@example.com");
        registrationPage.setPassword("password");
        registrationPage.setConfirmPassword("password");
        registrationPage.clickRegisterButton();
//    TODO 1: Add assertions to verify successful registration
    }

//    TODO 2: Add other testcases to validate registration functionality

    @After
    public void tearDown() {
        driver.quit();
    }
}