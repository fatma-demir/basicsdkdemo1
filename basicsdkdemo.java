package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;

public class basicsdkdemo {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 7 Pro");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.genband.basicsdkdemo");
        caps.setCapability("appActivity", "com.genband.basicsdkdemo.LoginActivity");
        caps.setCapability("noReset", "false");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        System.out.println();


    }

    @Test
    public void loginTest() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.genband.basicsdkdemo:id/animation_view")));
        element.click();

        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout')]"));{
            WebElement allowButton = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
            allowButton.click();
        }

        try {
            WebElement allowButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
            allowButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.switchTo().frame("iframe_id");
        WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginType")));
        new Select(login).selectByVisibleText("basic");

        WebElement platform = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("platrform")));
        new Select(platform).selectByVisibleText("sr1.kandycorp.net");

        WebElement account = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("account")));
        new Select(account).selectByVisibleText("adem1@spidr.com");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.genband.basicsdkdemo:id/userName"))).sendKeys("adem1@spidr.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.genband.basicsdkdemo:id/password_layout"))).sendKeys("1234");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.genband.basicsdkdemo:id/restIP"))).sendKeys("red.rbbn.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.genband.basicsdkdemo:id/restport"))).sendKeys("443");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iceTimeout"))).sendKeys("3");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton"))).click();
        driver.switchTo().defaultContent();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }}
