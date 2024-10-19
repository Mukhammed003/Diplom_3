import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import original.Constants;
import original.apisteps.StepsForWorkingWithAPI;
import original.objectpages.StellarBurgerLoginPage;
import original.objectpages.StellarBurgerMainPage;
import original.objectpages.StellarBurgerPasswordRecoveryPage;
import original.objectpages.StellarBurgerRegistrationPage;

public class TryToLoginTest {
    WebDriver driver;

    private String accessToken;

    StepsForWorkingWithAPI stepsForWorkingWithAPI = new StepsForWorkingWithAPI();

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Rule
    public DriverRule factory = new DriverRule();

    @Before
    public void initializeDriver() {
        driver = factory.getDriver();
        RestAssured.baseURI = Constants.BASIC_URL;
        Response responseAfterCreatingUser = stepsForWorkingWithAPI.createUser("Mukhammed@yandex.ru", "password", "Mukhammed");
        setAccessToken(stepsForWorkingWithAPI.extractingToken(responseAfterCreatingUser));
    }

    @Test
    public void tryToLoginByLoginToAccountButton() {
        StellarBurgerMainPage stellarBurgerMainPage = new StellarBurgerMainPage(driver);
        StellarBurgerLoginPage stellarBurgerLoginPage = new StellarBurgerLoginPage(driver);

        stellarBurgerMainPage.waitStellarBurgerMainPageLoading();
        stellarBurgerMainPage.clickOnLoginToAccountButton();

        stellarBurgerLoginPage.waitStellarBurgerLoginPageLoading();
        stellarBurgerLoginPage.enterDataToFieldsForLogin("Mukhammed@yandex.ru", "password");
        stellarBurgerLoginPage.clickToLoginButton();

        stellarBurgerMainPage.presenceOfMakeOrderButton();
    }

    @Test
    public void tryToLoginByPersonalAccountButton() {
        StellarBurgerMainPage stellarBurgerMainPage = new StellarBurgerMainPage(driver);
        StellarBurgerLoginPage stellarBurgerLoginPage = new StellarBurgerLoginPage(driver);

        stellarBurgerMainPage.waitStellarBurgerMainPageLoading();
        stellarBurgerMainPage.clickOnPersonalAccountButton();

        stellarBurgerLoginPage.waitStellarBurgerLoginPageLoading();
        stellarBurgerLoginPage.enterDataToFieldsForLogin("Mukhammed@yandex.ru", "password");
        stellarBurgerLoginPage.clickToLoginButton();

        stellarBurgerMainPage.presenceOfMakeOrderButton();
    }

    @Test
    public void tryToLoginByLoginButtonInRegistrationForm() {
        StellarBurgerMainPage stellarBurgerMainPage = new StellarBurgerMainPage(driver);
        StellarBurgerLoginPage stellarBurgerLoginPage = new StellarBurgerLoginPage(driver);
        StellarBurgerRegistrationPage stellarBurgerRegistrationPage = new StellarBurgerRegistrationPage(driver);

        stellarBurgerMainPage.waitStellarBurgerMainPageLoading();
        stellarBurgerMainPage.clickOnLoginToAccountButton();

        stellarBurgerLoginPage.waitStellarBurgerLoginPageLoading();
        stellarBurgerLoginPage.clickOnRegisterLink();

        stellarBurgerRegistrationPage.waitStellarBurgerRegistrationPageLoading();
        stellarBurgerRegistrationPage.clickToLoginLink();

        stellarBurgerLoginPage.waitStellarBurgerLoginPageLoading();
        stellarBurgerLoginPage.enterDataToFieldsForLogin("Mukhammed@yandex.ru", "password");
        stellarBurgerLoginPage.clickToLoginButton();

        stellarBurgerMainPage.presenceOfMakeOrderButton();
    }

    @Test
    public void tryToLoginByLoginButtonInPasswordRecoveryForm() {
        StellarBurgerMainPage stellarBurgerMainPage = new StellarBurgerMainPage(driver);
        StellarBurgerLoginPage stellarBurgerLoginPage = new StellarBurgerLoginPage(driver);
        StellarBurgerPasswordRecoveryPage stellarBurgerPasswordRecoveryPage = new StellarBurgerPasswordRecoveryPage(driver);

        stellarBurgerMainPage.waitStellarBurgerMainPageLoading();
        stellarBurgerMainPage.clickOnLoginToAccountButton();

        stellarBurgerLoginPage.waitStellarBurgerLoginPageLoading();
        stellarBurgerLoginPage.clickOnPasswordRecoveryLink();

        stellarBurgerPasswordRecoveryPage.waitStellarBurgerRegistrationPageLoading();
        stellarBurgerPasswordRecoveryPage.clickToLoginLink();

        stellarBurgerLoginPage.waitStellarBurgerLoginPageLoading();
        stellarBurgerLoginPage.enterDataToFieldsForLogin("Mukhammed@yandex.ru", "password");
        stellarBurgerLoginPage.clickToLoginButton();

        stellarBurgerMainPage.presenceOfMakeOrderButton();
    }

    @After
    public void setDown() {
        if(getAccessToken() != null) {
            stepsForWorkingWithAPI.deleteUser(getAccessToken());
        } else {
            System.out.println("Error");
        }
    }
}
