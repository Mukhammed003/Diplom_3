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
    private By bunsButton = By.xpath(".//span[text()='Булки']");
    private By saucesButton = By.xpath(".//span[text()='Соусы']");
    private By fillingsButton = By.xpath(".//span[text()='Начинки']");
    private By bunsSection = By.xpath(".//h2[text()='Булки']");
    private By saucesSection = By.xpath(".//h2[text()='Соусы']");
    private By fillingsSection = By.xpath(".//h2[text()='Начинки']");

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
        driver.findElement(bunsButton).click();
    }

    @Step("Нажимаем на кнопку \"Соусы\"")
    public void clickOnSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    @Step("Нажимаем на кнопку \"Начинки\"")
    public void clickOnFillingsButton() {
        driver.findElement(fillingsButton).click();
    }

    @Step("Проверяем что раздел \"Булки\" отображается")
    public void presenceOfBunsSection() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsSection));
        assertTrue(driver.findElement(bunsSection).isDisplayed());
    }

    @Step("Проверяем что раздел \"Соусы\" отображается")
    public void presenceOfSaucesSection() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(saucesSection));
        assertTrue(driver.findElement(saucesSection).isDisplayed());
    }

    @Step("Проверяем что раздел \"Начинки\" отображается")
    public void presenceOfFillingsSection() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsSection));
        assertTrue(driver.findElement(fillingsSection).isDisplayed());
    }
}
