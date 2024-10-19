package original.objectpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import original.Constants;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class StellarBurgerMainPage {
    private WebDriver driver;

    private By loginToAccountButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private By assembleTheBurgerText = By.xpath(".//h1[text()='Соберите бургер']");
    private By makeOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    public StellarBurgerMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitStellarBurgerMainPageLoading() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(assembleTheBurgerText));
    }

    public void clickOnLoginToAccountButton() {
        driver.findElement(loginToAccountButton).click();
    }

    public void presenceOfMakeOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(makeOrderButton));
        assertTrue(driver.findElement(makeOrderButton).isDisplayed());
    }

    public void clickOnPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
}
