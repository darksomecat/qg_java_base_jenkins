package tests.selenide;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTests extends TestBase {
    @Test
    public void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com") ;
        $("[class*='HeaderSearch-module__trigger']").click();
        $("[class*='searchContainer'] input").setValue("qa-guru/qa_guru_14_10").pressEnter();
        $(linkText("qa-guru/qa_guru_14_10")).click();
        $("#issues-tab").click();
        $("[data-testid='list-row-repo-name-and-number']")
                .shouldBe(visible)
                .shouldHave(text("#2"));

    }
}
