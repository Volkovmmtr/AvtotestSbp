package sbpTests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class BaseSteps {
    private final SelenideElement userNameInput = $x("//input[@name='username']").as("Поле имя пользователя");
    private final SelenideElement logInButton = $x("//button[@id='login-button']");
    private final SelenideElement passwordInput = $x("//input[@name='password']");
    private final SelenideElement smsInput = $x("//input[@id='otp-code']");
    private final SelenideElement codeButton = $x("//button[@id='login-otp-button']");
    private final static SelenideElement logoImg = $x("//*[@id='logo']").as("Картинка логопита");
    private final SelenideElement appName = $x("//div[@class='environment print-hidden']");
    private final SelenideElement curAva = $x("//a[@id='user-avatar']");
    private final SelenideElement newAva = $x("//div[@id='avatars']//img[@data-avatar='24.png']");
    private final SelenideElement labelAva = $x("//div[@id='avatars-form']/label");

    @Step("Авторизация на БСБП")
    public void Authorisation()
    {
        userNameInput.shouldBe(visible).val("demo");
        passwordInput.shouldBe(visible).val("demo");
        logInButton.shouldBe(visible).click();
        smsInput.shouldBe(visible).val("0000");
        codeButton.shouldBe(visible).click();
        logoImg.shouldBe(visible);
        appName.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Проверка наименования приложения")  // Анотация бибилиотеки Allure позволяет выделать в отдельный степ (Шаг) какое-то действие/проверку в автотесте
        // также библиотека Allure считает анотации Before, After, Description
    void appCheckNmae(){
        //appName.shouldHave(text("bank")); // матчеры интегрированные в селенид. Делает скриншот
        assertThat("Не соответствует текст", appName.getText(),containsString("bank")); // матчеры как отдельная библиотека. Не делает скриншот
    }
    @Step("Изменить аватар")  // Анотация бибилиотеки Allure позволяет выделать в отдельный степ (Шаг) какое-то действие/проверку в автотесте
        // также библиотека Allure считает анотации Before, After, Description
    void setNewAva(){
        curAva.click();
        switchTo().frame($x("(//div[@id='contentbar']/iframe)"));
        labelAva.shouldBe(visible);
        labelAva.shouldHave(text("Avatay"));
        newAva.click();
    }

    @Step("Выйти из фрейма")  // Анотация бибилиотеки Allure позволяет выделать в отдельный степ (Шаг) какое-то действие/проверку в автотесте
        // также библиотека Allure считает анотации Before, After, Description
    void frameOut(){
        switchTo().defaultContent();
        logoImg.shouldBe(visible).click();
    }
}
