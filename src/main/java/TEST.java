import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TEST {



   private static AppiumDriver driver;

    public static void setDriver(AppiumDriver driver) {
        TEST.driver = driver;
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    /*
        @BeforeAll
        public  static void  SetUp () throws Exception {
            System.out.println("Step 1. Create new driver");
            driver = getAppiumDriver("Android", new URL("http://0.0.0.0:4723/wd/hub"));

        }

            @Test
            public void test_1() throws Exception {
                System.out.println("Step 2. First Test - Success login");
                Thread.sleep(3000);
               // WebElement ss= driver.findElementById("dsdsd");
                driver.findElementById("com.magora.abacuspay.dev:id/emailField").sendKeys("tolstykh+999991@magora-systems.com");
                driver.hideKeyboard();
                driver.findElementById("com.magora.abacuspay.dev:id/passwordField").sendKeys("Qwerty123");
                driver.hideKeyboard();
                driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
                Thread.sleep(2000);
                assertTrue(driver.findElementById("com.magora.abacuspay.dev:id/payBtn").isDisplayed(),"LOX");


            }

            @AfterAll
            public static void tearDown() {
                System.out.println("Close driver");
                driver.quit();
            }

        */
    public static AppiumDriver getAppiumDriver(String platform, URL serverUrl) {
        return platform.equals("iOS") ? getIOSDriver(serverUrl) : getAndroidDriver(serverUrl);
    }


    private static AppiumDriver getIOSDriver(URL serverUrl) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.UDID, "F97C79FE-5F55-4CE3-BA88-9351B7A9421F");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");
        capabilities.setCapability("showXcodeLog", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");

        return new IOSDriver(serverUrl, capabilities);
    }

    private static AppiumDriver getAndroidDriver(URL serverUrl) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "D1AGAD1761710061");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nokia 5");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
       // capabilities.setCapability(MobileCapabilityType.APP, "https://raw.githubusercontent.com/afollestad/material-dialogs/master/sample/sample.apk");
         capabilities.setCapability(MobileCapabilityType.APP, "H://Programs/base.apk");
       // capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "Abacus Pay Dev");
        return new AndroidDriver(serverUrl, capabilities);
    }


}