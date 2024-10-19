import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import original.Constants;

public class DriverRule extends ExternalResource {
    private WebDriver driver;

    //Геттер для драйвера
    public WebDriver getDriver() {
        return driver;
    }

    //Перед каждым тестом
    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    //После каждого теста
    @Override
    protected void after() {
        driver.quit();
    }

    //Выбор драйвера(браузера)
    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            startFirefox();
        } else {
            startChrome();
        }
    }

    //Начало для Chrome
    public void startChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        //"--no-sandbox", "--headless", "--disable-dev-shm-usage"
        driver = new ChromeDriver(options);
        driver.get(Constants.URL_OF_SITE);
        driver.manage().window().maximize();
    }

    //Начало для Firefox
    public void startFirefox() {
        FirefoxOptions foptions = new FirefoxOptions();
        foptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(foptions);
        driver.get(Constants.URL_OF_SITE);
        driver.manage().window().maximize();
    }
}
