package sbpTests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginTestNegativ extends BaseTest {
    public BaseSteps baseSteps;
    @BeforeEach
    void before(){
        open(baseUrl);
        logoImg.shouldBe(visible);
        baseSteps = new BaseSteps();

        baseSteps.Authorisation();
    };


    @Test
    @Description("Авторизация в интернет банке БСБП")
    void test2() {
    }
}
