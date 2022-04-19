package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WebstepsTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com";
    }



    private final String REPO = "selenide/selenide";
    private final int NUM = 25;

    @Test
    @DisplayName("Test with @Step annotations")
    @Owner("Tatiana Belotserkovskaia")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Issues in repository")
    @Story("Looking up for issues in repository")
    public void webStepsTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openStartPage();
        steps.openRepositoryPage(REPO);
        steps.clickRepositoryLink(REPO);
        steps.clickIssuesTab();
        steps.countIssues(NUM);

    }

}
