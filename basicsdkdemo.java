package org.example;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
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
    private Object WebElement;
    private Object pageUp;

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
        {
            Dimension size = driver.manage().window().getSize();
            int startX = size.width / 2;
            int startY = (int) (size.height * 0.5);
            int endY = (int) (size.height * 0.2);

            new TouchAction(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();
        }
        pageUp();
        WebElement restIPField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.genband.basicsdkdemo:id/restIP")));
        restIPField.click();
        restIPField.clear();
        restIPField.sendKeys("red.rbbn.com");


        // Ice timeout doldurma
        WebElement restIceTimeOutField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.genband.basicsdkdemo:id/iceTimeOut")));
        restIceTimeOutField.click();
        restIceTimeOutField.sendKeys("3");


        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button")).click();
        {
            WebElement enterAddressToCallField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText")));
            enterAddressToCallField.sendKeys("adem2@spidr.com");
            WebElement sendLogsField = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.Button")));
            sendLogsField.click();



            WebElement doneField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.genband.basicsdkdemo:id/doneButton")));
            doneField.click();
            WebElement resetLogsField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.genband.basicsdkdemo:id/callButton")));
            resetLogsField.click();
        }

    }

    private void pageUp() {
    }
}




