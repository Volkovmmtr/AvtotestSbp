package sbpTests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends BaseTest {
    public BaseSteps baseSteps;
    @Test
    @Description("Авторизация в интернет банке БСБП")
    void loginTest() {

        baseSteps = new BaseSteps();

        baseSteps.appCheckNmae();
        baseSteps.setNewAva();
        baseSteps.frameOut();
    }

    @Test
    @Description("Авторизация в интернет банке БСБП")
    void test2() {
    }
}
