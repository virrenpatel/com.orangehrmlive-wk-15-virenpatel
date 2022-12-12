package com.oranghrmlive.demo.testsuite;

import com.oranghrmlive.demo.customlisteners.CustomListeners;
import com.oranghrmlive.demo.pages.ForgotPassword;
import com.oranghrmlive.demo.pages.LoginPage;
import com.oranghrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    ForgotPassword forgotPassword;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginPage = new LoginPage();
        forgotPassword = new ForgotPassword();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        String expectedDashboardText = "Dashboard";
        Assert.assertEquals(loginPage.getDashboardText(),expectedDashboardText,"Dashboard");
    }

    @Test(groups = {"smoke","regression"})
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        forgotPassword.clickOnForgotPassword();
        String expectedResetPasswordText = "Reset Password";
        Assert.assertEquals(forgotPassword.getResetPasswordText(),expectedResetPasswordText,"Reset Password");
    }

}
