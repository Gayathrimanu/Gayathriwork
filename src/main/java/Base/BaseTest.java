package Base;

import Utils.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigLoader config;

    @BeforeClass
    public void setUp() {
        // Initialize ConfigLoader (default config.properties)
        config = new ConfigLoader();
        // Read configuration values
        String browser = config.getProperty("browser");
        // String headless = config.getProperty("headless");
        int implicitlyWait = Integer.parseInt(config.getProperty("implicitlyWait"));
        int pageLoadTimeout = Integer.parseInt(config.getProperty("pageLoadTimeout"));
        int scriptTimeout = Integer.parseInt(config.getProperty("scriptTimeout"));
        String url = config.getProperty("url");

        // Browser setup
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            driver = new ChromeDriver(options); // initialize WebDriverelse
        }else

        {
            throw new RuntimeException("Currently only Chrome browser is supported.");
        }

        // Browser window and timeouts
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeout));

        // Navigate to URL
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

