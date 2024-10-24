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
import original.objectpages.StellarBurgerRegistrationPage;

public class RegisterTest {

    WebDriver driver;

    private Boolean isNeedToDeleteUser;

    StepsForWorkingWithAPI stepsForWorkingWithAPI = new StepsForWorkingWithAPI();

    public Boolean getIsNeedToDeleteUser() {
        return isNeedToDeleteUser;
    }

    public void setIsNeedToDeleteUser(Boolean needToDeleteUser) {
        isNeedToDeleteUser = needToDeleteUser;
    }

    @Rule
    public DriverRule factory = new DriverRule();

    @Before
    public void initializeDriver() {
        driver = factory.getDriver();
        RestAssured.baseURI = Constants.BASIC_URL;

        StellarBurgerMainPage stellarBurgerMainPage = new StellarBurgerMainPage(driver);
        StellarBurgerLoginPage stellarBurgerLoginPage = new StellarBurgerLoginPage(driver);

        stellarBurgerMainPage.waitStellarBurgerMainPageLoading();
        stellarBurgerMainPage.clickOnLoginToAccountButton();

        stellarBurgerLoginPage.waitStellarBurgerLoginPageLoading();
        stellarBurgerLoginPage.clickOnRegisterLink();
    }

    @Test
    public void rightRegistration() {
        setIsNeedToDeleteUser(true);
        StellarBurgerLoginPage stellarBurgerLoginPage = new StellarBurgerLoginPage(driver);
        StellarBurgerRegistrationPage stellarBurgerRegistrationPage = new StellarBurgerRegistrationPage(driver);

        stellarBurgerRegistrationPage.waitStellarBurgerRegistrationPageLoading();
        stellarBurgerRegistrationPage.enterDataToFieldsForRegistration("Mukhammed", "Mukhammed@yandex.ru", "password");
        stellarBurgerRegistrationPage.clickToRegisterButton();

        stellarBurgerLoginPage.presenceOfLoginText();
    }

    @Test
    public void tryToRegisterWithWrongPassword() {
        setIsNeedToDeleteUser(false);
        StellarBurgerRegistrationPage stellarBurgerRegistrationPage = new StellarBurgerRegistrationPage(driver);

        stellarBurgerRegistrationPage.waitStellarBurgerRegistrationPageLoading();
        stellarBurgerRegistrationPage.enterDataToFieldsForRegistration("Mukhammed", "Mukhammed@yandex.ru", "passw");
        stellarBurgerRegistrationPage.clickToRegisterButton();

        stellarBurgerRegistrationPage.checkingCorrectnessOfErrorText();
    }

    @After
    public void setDown() {
        if(getIsNeedToDeleteUser().equals(true)) {
            Response responseAfterLoginUser = stepsForWorkingWithAPI.loginUser("Mukhammed@yandex.ru", "password");
            String accessToken = stepsForWorkingWithAPI.extractingToken(responseAfterLoginUser);
            stepsForWorkingWithAPI.deleteUser(accessToken);
        }
        else {
            System.out.println("Error");
        }
    }
}
