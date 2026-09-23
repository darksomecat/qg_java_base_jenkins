package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegistrationPage;
import java.util.Map;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    protected RegistrationPage registrationPage = new RegistrationPage();

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    static void beforeAll(){
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://qa-guru.github.io/one-page-form";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1428x1158";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage", "--no-sandbox");
        chromeOptions.setCapability("se:cdpEnabled", false);
        chromeOptions.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = chromeOptions;
        //Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";//put("enableVideo", true); в настройках самого селеноида для включения видео
    }
    @AfterEach
    void addAtachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.attachAsText("Some file", "Some Content");
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();

    }

}

