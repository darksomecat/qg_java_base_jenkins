package tests.selenide;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class LabelsTest extends TestBase {
   @Test
   @Feature("Issue в репозитории")
   @Story("Создание Issue")
   @Owner("aukolova")
   @Severity(SeverityLevel.BLOCKER)
   @Link(value = "github", url = "https://github.com")
   @DisplayName("Создание  Issue для авторизованного пользователя")
   public void testStaticLabels() {

   }

   @Test
   public void testDynamicLabels() {
      Allure.getLifecycle().updateTestCase(t -> t.setName("Создание  Issue для авторизованного пользователя")
      );
      Allure.feature("Issue в репозитории");
      Allure.story("Создание Issue");
      Allure.label("owner", "aukolova");
      Allure.label("severity", SeverityLevel.CRITICAL.value());
      Allure.link("github", "https://github.com");
   }
}
