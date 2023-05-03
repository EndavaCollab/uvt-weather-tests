package com.mockup.features;

import com.mockup.ChromeWebDriver;
import com.mockup.pageDefinitions.HomePage;
import com.mockup.pageDefinitions.RegistrationPage;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTest {
    private ChromeWebDriver driver;
    private RegistrationPage registrationPage;

    @Before
    public void setup() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
    }

    @Test
    public void testRegistration() {
        registrationPage.setUsername("username");
        registrationPage.setEmail("email@example.com");
        registrationPage.setPassword("password");
        registrationPage.setConfirmPassword("password");
        registrationPage.clickRegisterButton();
        driver.quit();
        // Add assertions to verify successful registration
    }
}