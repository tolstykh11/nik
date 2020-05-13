import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.net.URL;

public class TestPayment {

    @BeforeEach
    public  void  SetUp () throws Exception {
        System.out.println("Step 1. Create new driver");
        TEST.setDriver(TEST.getAppiumDriver("Android", new URL("http://0.0.0.0:4723/wd/hub")));
    }

    @Test
    public void TestSuccessCardPayment () throws InterruptedException {
        AppiumDriver driver = TEST.getDriver();

        Actions action = new Actions(TEST.getDriver());

        System.out.println("Step 2. Success Card Payment");

        Thread.sleep(3000);
        driver.findElementById("com.magora.abacuspay.dev:id/emailField").sendKeys("tolstykh+999991@magora-systems.com");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/passwordField").sendKeys("Qwerty123");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
        Thread.sleep(2000);
        driver.findElementById("com.magora.abacuspay.dev:id/payBtn").click();
        Thread.sleep(2000);
        driver.findElementById("com.magora.abacuspay.dev:id/button1").click();
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
        driver.findElementById("com.magora.abacuspay.dev:id/givePermissionBtn").click();
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        driver.findElementById("com.magora.abacuspay.dev:id/cashBtn").click();
        driver.findElementById("com.magora.abacuspay.dev:id/button1").click();
       // driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
       // driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
        WebElement button = driver.findElementById("com.magora.abacuspay.dev:id/nextBtn");
        action.doubleClick(button);
        action.click(driver.findElementById("com.magora.abacuspay.dev:id/button1"));

        // action.doubleTap(button);
        // action.perform();
        // action.moveTo();
       // action.doubleClick(button);
       // action.perform();
    }

    @AfterEach
    public  void tearDown() {
        System.out.println("Step 3. Close driver");
        AppiumDriver driver=TEST.getDriver();
        driver.quit();
    }
}
