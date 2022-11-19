package sbpTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    private final static SelenideElement logoImg = $x("//*[@id='logo']").as("Картинка логопита");
    private final static String baseUrl = "https://idemo.bspb.ru/";
    public BaseSteps baseSteps;


    @BeforeAll
    static void beforeConfig(){
        SelenideLogger.addListener("listenerAllure",new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.timeout = 3000; // Умное ожидание появление элемента на странице
        Configuration.browserSize = "1920x1080"; // Умно
    }

    @BeforeEach
    void before(){
        open(baseUrl);
        logoImg.shouldBe(visible);
        baseSteps = new BaseSteps();

        baseSteps.Authorisation();
    };

    @AfterEach
    void after() {
        closeWebDriver();
    }
}
