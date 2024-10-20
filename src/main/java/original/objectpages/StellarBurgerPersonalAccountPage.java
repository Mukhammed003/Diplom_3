package original.objectpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import original.Constants;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class StellarBurgerPersonalAccountPage {
    private WebDriver driver;

    private By profileText = By.xpath(".//a[text()='Профиль']");

    public StellarBurgerPersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitStellarBurgerPersonalAccountPageLoading() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
    }

    public void presenceOfProfileText() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
        assertTrue(driver.findElement(profileText).isDisplayed());
    }

}
