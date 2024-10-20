package original.objectpages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import original.Constants;

import java.time.Duration;

public class StellarBurgerPasswordRecoveryPage {
    private WebDriver driver;

    private By loginLink = By.xpath(".//a[text()='Войти']");
    private By passwordRecoveryText = By.xpath(".//h2[text()='Восстановление пароля']");

    public StellarBurgerPasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ждем загрузки страницы восстановление пароля")
    public void waitStellarBurgerRegistrationPageLoading() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordRecoveryText));
    }

    @Step("Нажимаем на кнопку/ссылку \"Войти\"")
    public void clickToLoginLink() {
        driver.findElement(loginLink).click();
    }
}
