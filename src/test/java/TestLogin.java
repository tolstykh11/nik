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
        Thread.sleep(2000);
    }

    @Test
    public void TestInvalidLogin () throws InterruptedException {
        System.out.println("Step 2. First Test - Invalid login");
        AppiumDriver driver=TEST.getDriver();
        driver.findElementById("com.magora.abacuspay.dev:id/emailField").sendKeys("tolstykh+test@magora-systems.com");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/passwordField").sendKeys("Qwerty");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
        Thread.sleep(2000);
        assertTrue(driver.findElementById("com.magora.abacuspay.dev:id/credentialsError").isDisplayed(),"element not found");
    }

    @Test
    public void TestSuccessLogin () throws InterruptedException {
        System.out.println("Step 2. First Test - Success login");
        // WebElement ss= driver.findElementById("dsdsd");
        AppiumDriver driver=TEST.getDriver();
        driver.findElementById("com.magora.abacuspay.dev:id/emailField").sendKeys("tolstykh+test@magora-systems.com");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/passwordField").sendKeys("Qwerty123");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
        Thread.sleep(2000);
        assertTrue(driver.findElementById("com.magora.abacuspay.dev:id/payBtn").isDisplayed(),"LOX");
    }

    @Test
    public void TestResetPassword() {
        AppiumDriver driver=TEST.getDriver();

        driver.findElementById("com.magora.abacuspay.dev:id/forgotPassword").click();
        driver.findElementById("com.magora.abacuspay.dev:id/emailField").sendKeys("tolstykh@magora-systems.com");
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();

    }


    @AfterEach
    public  void tearDown() {
        System.out.println("Close driver");
        AppiumDriver driver=TEST.getDriver();
        driver.quit();
    }
}
