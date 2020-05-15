import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;

public class Settings {

    @BeforeEach
    public  void  SetUp () throws Exception {
        System.out.println("Step 1. Create new driver");
        TEST.setDriver(TEST.getAppiumDriver("Android", new URL("http://0.0.0.0:4723/wd/hub")));
        Thread.sleep(2000);
    }

    @Test
    public void TestBankAccountSettings () throws InterruptedException {
        System.out.println("Step 2. Success filling new Bank Account Details");
        AppiumDriver driver = TEST.getDriver();
        driver.findElementById("com.magora.abacuspay.dev:id/emailField").sendKeys("tolstykh+test@magora-systems.com");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/passwordField").sendKeys("Qwerty123");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
        Thread.sleep(2000);
        driver.findElementById("com.magora.abacuspay.dev:id/settingsBtn").click();
        driver.findElementById("com.magora.abacuspay.dev:id/paymentSettingsBtn").click();
        driver.findElementById("com.magora.abacuspay.dev:id/bankAccountDetailsBtn").click();
        driver.findElementsById("com.magora.abacuspay.dev:id/accountName").clear();
        driver.findElementById("com.magora.abacuspay.dev:id/accountName").sendKeys("AutoTest");
        driver.findElementById("com.magora.abacuspay.dev:id/sortCode").sendKeys("133700");
        driver.findElementById("com.magora.abacuspay.dev:id/accountNumber").sendKeys("13371337");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/confirmBtn").click();
        driver.findElementById("com.magora.abacuspay.dev:id/password").sendKeys("Qwerty123");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/confirmBtn").click();
        assertTrue(driver.findElementById("com.magora.abacuspay.dev:id/bankAccountDetailsBtn").isDisplayed(),"element not found");
    }
    @Test
    public void TestChangePassword () throws InterruptedException {
        System.out.println("Step 2. Success Changing Email");
        Thread.sleep(3000);
        AppiumDriver driver = TEST.getDriver();
        driver.findElementById("com.magora.abacuspay.dev:id/emailField").sendKeys("tolstykh+test@magora-systems.com");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/passwordField").sendKeys("Qwerty123");
        driver.hideKeyboard();
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
        Thread.sleep(2000);
        driver.findElementById("com.magora.abacuspay.dev:id/settingsBtn").click();
        driver.findElementById("com.magora.abacuspay.dev:id/accountSettingsBtn").click();
        driver.findElementById("com.magora.abacuspay.dev:id/changePasswordBtn").click();
        driver.findElementById("com.magora.abacuspay.dev:id/currentPassword").sendKeys("Qwerty123");
        driver.findElementById("com.magora.abacuspay.dev:id/newPassword").sendKeys("Qwerty123");
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
        Thread.sleep(2000);
        assertTrue(driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").isDisplayed(),"element not found");
        assertTrue(driver.findElementById("com.magora.abacuspay.dev:id/transactionImage").isDisplayed(),"element not found");
        driver.findElementById("com.magora.abacuspay.dev:id/nextBtn").click();
    }


    @AfterEach
    public  void tearDown() {
        System.out.println("Step 3. Close driver");
        AppiumDriver driver=TEST.getDriver();
        driver.quit();
    }
}
