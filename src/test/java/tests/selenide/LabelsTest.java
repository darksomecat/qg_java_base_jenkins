package tests.selenide;

import io.qameta.allure.Step;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps extends TestBase {
   @Step("Открываем главную страницу")
   public  void openMainPage() {
       open("https://github.com");
   }
   @Step("Ищем репозиторий {repo}")
   public  void searchForRepository(String repo) {
       $("[class*='HeaderSearch-module__trigger']").click();
       $("[class*='searchContainer'] input").setValue(repo).pressEnter();
   }
    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
       $(linkText(repo)).click();
   }
    @Step("Открываем вкладку Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }
    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $("[data-testid='list-row-repo-name-and-number']")
                .shouldBe(visible)
                .shouldHave(text("#" + issue));
    }
}
