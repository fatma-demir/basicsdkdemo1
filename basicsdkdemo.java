package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
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


        WebElement allowButton = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
        allowButton.click();
        WebElement allowButton2 = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
        allowButton2.click();
        WebElement allowButton3 = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
        allowButton3.click();

    }

    @Test
    public void loginTest() throws MalformedURLException {

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.EditText")));
        element.click();
        element.clear();
        element.sendKeys("adem1@spidr.com");
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.TableLayout/android.widget.LinearLayout[7]/android.widget.EditText")));
        passwordField.sendKeys("1234");


        WebElement restIPField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.TableLayout/android.widget.LinearLayout[11]/android.widget.TextView\n")));

        restIPField.click();
        restIPField.clear();
        restIPField.sendKeys("red.rbbn.com");

        // Rest port doldurma
        WebElement restPortField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.TableLayout/android.widget.LinearLayout[12]/android.widget.EditText")));
        restPortField.sendKeys("443");

        // Ice timeout doldurma
        WebElement iceTimeoutField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.TableLayout/android.widget.LinearLayout[13]/android.widget.EditText")));
        iceTimeoutField.sendKeys("3");



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

        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton"))).click();
        driver.switchTo().defaultContent();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }}
