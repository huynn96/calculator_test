package calculator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Hook {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void InitTest() throws MalformedURLException {
        String browser = System.getProperty("browser", "chrome");
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Huy\\Downloads\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "android":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "5af5133");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                URL url = new URL("http://127.0.0.1:4723/wd/hub");

                driver = new AndroidDriver(url, capabilities);
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Huy\\Downloads\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void AfterTest() {
        driver.quit();
    }
}
