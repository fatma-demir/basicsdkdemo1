package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;

public class basicsdkdemo {
    public AndroidDriver driver;

    By usernameFieldBy = By.id("usernameFieldId");
    By platformFieldBy = By.id("platrformFieldId");
    By passwordFieldBy = By.id("passwordFieldId"); // Assuming this is the ID of the password field
    By iceTimeoutBy = By.id("iceTimeoutFieldId");
    By accountFieldBy = By.id("accountFieldId");
    By restIpBy= By.id("restIpFieldId");
    By restPortBy= By.id("restPortFieldId");
    By loginButtonBy = By.id("loginButtonId"); // Assuming this is the ID of the login button
    By allowWhenUsingBy =  By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    By animationBy      = By.id("com.genband.basicsdkdemo:id/animation_view");




    @BeforeMethod
    public void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "Pixel 7 Pro");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.genband.basicsdkdemo"); // Change this to your app's package name
        caps.setCapability("appActivity", "com.genband.basicsdkdemo.LoginActivity"); // Change this to your app's login activity
        caps.setCapability("noReset", "false");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement allowButton = driver.findElement(allowWhenUsingBy);
        allowButton.click();
    }

    @Test
    public void basicTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(animationBy));
        element.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(allowWhenUsingBy));
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(allowWhenUsingBy)).isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(allowWhenUsingBy)).click();
        }
        WebElement platformField = wait.until(ExpectedConditions.visibilityOfElementLocated(platformFieldBy));
        String optionToSelect = "sr1.kandycorp.net";
        Select select = new Select(platformField);
        select.selectByVisibleText(optionToSelect);
        WebElement accountField = wait.until(ExpectedConditions.visibilityOfElementLocated(accountFieldBy));
        String accountToSelect = "adem1@spidr.com";
        Select selectAccount = new Select(accountField);
        selectAccount.selectByVisibleText(accountToSelect);


        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldBy)).sendKeys("adem1@spidr.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(restIpBy)).sendKeys("red.rbbn.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(restPortBy)).sendKeys("443");
        wait.until(ExpectedConditions.visibilityOfElementLocated(iceTimeoutBy)).sendKeys("3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldBy)).sendKeys("1234");
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonBy)).click();

        WebElement allowButton = driver.findElement(allowWhenUsingBy);
        allowButton.click();
        // You can add assertions here to verify successful login
        // For example:
        // Assert.assertTrue(driver.findElement(By.id("welcomeMessageId")).isDisplayed());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

