package original.objectpages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import original.Constants;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class StellarBurgerLoginPage {
    private WebDriver driver;

    private By loginText = By.xpath(".//h2[text()='Вход']");
    private By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private By emailField = By.xpath(".//fieldset[1]/div/div/input");
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    private By loginButton = By.xpath(".//button[text()='Войти']");
    private By passwordRecoveryLink = By.xpath(".//a[text()='Восстановить пароль']");

    public StellarBurgerLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ждем загрузки страницы авторизации")
    public void waitStellarBurgerLoginPageLoading() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(loginText));
    }

    @Step("Нажимаем на кнопку/ссылку \"Зарегистрироваться\"")
    public void clickOnRegisterLink() {
        driver.findElement(registerLink).click();
    }

    @Step("Проверяем что текст \"Вход\" отображается")
    public void presenceOfLoginText() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(loginText));
        assertTrue(driver.findElement(loginText).isDisplayed());
    }

    @Step("Вводим все данные в поля для входа")
    public void enterDataToFieldsForLogin(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажимаем на кнопку \"Войти\"")
    public void clickToLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажимаем на кнопку/ссылку \"Восстановить пароль\"")
    public void clickOnPasswordRecoveryLink() {
        driver.findElement(passwordRecoveryLink).click();
    }
}
