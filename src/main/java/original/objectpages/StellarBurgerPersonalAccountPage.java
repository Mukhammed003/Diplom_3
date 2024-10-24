package original.objectpages;

import io.qameta.allure.Step;
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
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By stellarBurgerLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private By logoutButton = By.xpath(".//button[text()='Выход']");

    public StellarBurgerPersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ждем загрузки страницы личный кабинет")
    public void waitStellarBurgerPersonalAccountPageLoading() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
    }

    @Step("Проверяем что текст \"Профиль\" отображается")
    public void presenceOfProfileText() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
        assertTrue(driver.findElement(profileText).isDisplayed());
    }

    @Step("Нажимаем на кнопку \"Конструктор\"")
    public void clickToConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Кликаем по логотипу Stellar Burgers")
    public void clickToStellarBurgerLogo() {
        driver.findElement(stellarBurgerLogo).click();
    }

    @Step("Нажимаем на кнопку \"Выйти\"")
    public void clickToLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
