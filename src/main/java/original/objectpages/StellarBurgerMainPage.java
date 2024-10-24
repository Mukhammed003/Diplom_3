package original.objectpages;

import io.qameta.allure.Step;
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
    private By bunsButton = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
    private By saucesButton = By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
    private By fillingsButton = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");

    public StellarBurgerMainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ждем загрузки главной страницы")
    public void waitStellarBurgerMainPageLoading() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(assembleTheBurgerText));
    }

    @Step("Проверяем что текст \"Соберите бургер\" отображается")
    public void presenceOfAssembleTheBurgerText() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(assembleTheBurgerText));
        assertTrue(driver.findElement(assembleTheBurgerText).isDisplayed());
    }

    @Step("Нажимаем на кнопку \"Войти в аккаунт\"")
    public void clickOnLoginToAccountButton() {
        driver.findElement(loginToAccountButton).click();
    }

    @Step("Проверяем что текст \"Оформить заказ\" отображается")
    public void presenceOfMakeOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(makeOrderButton));
        assertTrue(driver.findElement(makeOrderButton).isDisplayed());
    }

    @Step("Нажимаем на кнопку \"Личный Кабинет\"")
    public void clickOnPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажимаем на кнопку \"Булки\"")
    public void clickOnBunsButton() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsButton));
        driver.findElement(bunsButton).click();
    }

    @Step("Нажимаем на кнопку \"Соусы\"")
    public void clickOnSaucesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(saucesButton));
        driver.findElement(saucesButton).click();
    }

    @Step("Нажимаем на кнопку \"Начинки\"")
    public void clickOnFillingsButton() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsButton));
        driver.findElement(fillingsButton).click();
    }

    @Step("Проверяем переключение на раздел \"Булки\"")
    public void сheckingTheSectionSwitchingToBunsSection() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.IMPLICIT_WAIT))
                .until(ExpectedConditions.attributeContains(bunsButton, "class", "current"));
    }

    @Step("Проверяем переключение на раздел \"Соусы\"")
    public void сheckingTheSectionSwitchingToSaucesSection() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.IMPLICIT_WAIT))
                .until(ExpectedConditions.attributeContains(saucesButton, "class", "current"));
    }

    @Step("Проверяем переключение на раздел \"Начинки\"")
    public void сheckingTheSectionSwitchingToFillingsSection() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.IMPLICIT_WAIT))
                .until(ExpectedConditions.attributeContains(fillingsButton, "class", "current"));
    }
}
