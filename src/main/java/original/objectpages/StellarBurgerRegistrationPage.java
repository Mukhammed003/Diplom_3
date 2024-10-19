package original.objectpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import original.Constants;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class StellarBurgerRegistrationPage {
    private WebDriver driver;

    private By registrationText = By.xpath(".//h2[text()='Регистрация']");
    private By nameField = By.xpath(".//fieldset[1]/div/div/input");
    private By emailField = By.xpath(".//fieldset[2]/div/div/input");
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    private By registerButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By errorTextOfPasswordField = By.xpath(".//p[text()='Некорректный пароль']");
    private By loginLink = By.xpath(".//a[text()='Войти']");

    public StellarBurgerRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitStellarBurgerRegistrationPageLoading() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationText));
    }

    public void enterDataToFieldsForRegistration(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickToRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void checkingCorrectnessOfErrorText() {
        assertEquals("Another error text for password field", Constants.EXPECTED_ERROR_MESSAGE_FOR_PASSWORD_FIELD, driver.findElement(errorTextOfPasswordField).getText());
    }

    public void clickToLoginLink() {
        driver.findElement(loginLink).click();
    }
}
