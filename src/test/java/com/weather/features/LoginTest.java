package com.weather.features;

import com.weather.ChromeWebDriver;
import com.weather.pageDefinitions.DashboardPage;
import com.weather.pageDefinitions.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {
    private ChromeWebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {
        driver = new ChromeWebDriver();
        driver.get("http://localhost:4200/auth");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void canLoginWithValidCredentials() {
        loginPage.setUsername("test1@test.com");
        loginPage.setPassword("test");
        loginPage.clickLoginButton();
        DashboardPage dashboardPage = new DashboardPage(driver);

        assertThat(dashboardPage.getConfirmationMessage(), equalTo("dashboard works!"));
        assertThat(driver.getCurrentUrl(), containsString("dashboard"));
    }

    @Test
    public void cannotLoginWithInvalidPassword() {
        loginPage.setUsername("test1@test.com");
        loginPage.setPassword("wrongPass");
        loginPage.clickLoginButton();

        assertThat(loginPage.getAlertMessage(), is("Bad credentials!"));
    }

    @Test
    public void cannotLoginWithUnregisteredUser() {
        loginPage.setUsername("testUnregistered@test.com");
        loginPage.setPassword("test");
        loginPage.clickLoginButton();

        assertThat(loginPage.getAlertMessage(), is("Bad credentials!"));
    }

    @Test
    public void cannotEnterEmailAddressWithInvalidFormat() {
        loginPage.setUsername("test1");
        loginPage.setPassword("test");

        assertThat(loginPage.getErrorMessage(), is("Not a valid email"));
    }

    @Test
    public void cannotLoginWithoutEmail() {

    }

    @Test
    public void cannotLoginWithoutPassword() {

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}