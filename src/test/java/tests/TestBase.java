package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
       static void beforeAll(){
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://qa-guru.github.io/one-page-form";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1428x1158";
//        Configuration.browserVersion = "128.0";
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
        closeWebDriver();
    }
}
