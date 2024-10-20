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
import original.objectpages.StellarBurgerPersonalAccountPage;

public class TryToTransferToPersonalAccountTest {

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
    public void tryToTransferToPersonalAccountPageByClickingPersonalAccountButton() {
        StellarBurgerMainPage stellarBurgerMainPage = new StellarBurgerMainPage(driver);
        StellarBurgerLoginPage stellarBurgerLoginPage = new StellarBurgerLoginPage(driver);
        StellarBurgerPersonalAccountPage stellarBurgerPersonalAccountPage = new StellarBurgerPersonalAccountPage(driver);

        stellarBurgerMainPage.waitStellarBurgerMainPageLoading();
        stellarBurgerMainPage.clickOnLoginToAccountButton();

        stellarBurgerLoginPage.waitStellarBurgerLoginPageLoading();
        stellarBurgerLoginPage.enterDataToFieldsForLogin("Mukhammed@yandex.ru", "password");
        stellarBurgerLoginPage.clickToLoginButton();

        stellarBurgerMainPage.waitStellarBurgerMainPageLoading();
        stellarBurgerMainPage.clickOnPersonalAccountButton();

        stellarBurgerPersonalAccountPage.waitStellarBurgerPersonalAccountPageLoading();
        stellarBurgerPersonalAccountPage.presenceOfProfileText();
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
