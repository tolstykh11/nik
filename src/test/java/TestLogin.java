import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogin {
   // AppiumDriver driver=TEST.getDriver();

    @BeforeEach
    public  void  SetUp () throws Exception {
        System.out.println("Step 1. Create new driver");
        TEST.setDriver(TEST.getAppiumDriver("Android", new URL("http://0.0.0.0:4723/wd/hub")));
    }

    @Test
    public void TestInvalidLogin () throws InterruptedException {
        System.out.println("Step 2. First Test - Invalid login");
        Thread.sleep(3000);
        AppiumDriver driver=TEST.getDriver();
        driver.findElementById("com.magora.abacuspay.dev:id/emailField").sendKeys("tolstykh+999991@magora-systems.com");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/passwordField").sendKeys("Qwerty");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
        Thread.sleep(2000);
        assertTrue(driver.findElementById("com.magora.abacuspay.dev:id/credentialsError").isDisplayed(),"LOX");
    }

    @Test
    public void TestSuccessLogin () throws InterruptedException {
        System.out.println("Step 2. First Test - Success login");
        Thread.sleep(3000);
        // WebElement ss= driver.findElementById("dsdsd");
        AppiumDriver driver=TEST.getDriver();
        driver.findElementById("com.magora.abacuspay.dev:id/emailField").sendKeys("tolstykh+999991@magora-systems.com");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/passwordField").sendKeys("Qwerty123");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
        Thread.sleep(2000);
        assertTrue(driver.findElementById("com.magora.abacuspay.dev:id/payBtn").isDisplayed(),"LOX");
    }

    @AfterEach
    public  void tearDown() {
        System.out.println("Close driver");
        AppiumDriver driver=TEST.getDriver();
        driver.quit();
    }
}
