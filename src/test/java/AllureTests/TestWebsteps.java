package AllureTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.IssuesPage;
import pages.RepoListPage;
import pages.RepoSelenidePage;
import pages.StartPage;

public class TestWebsteps {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com";
    }



    String query = "selenide/selenide";
    int expectNum = 25;

    @Test
    public void webStepsTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openStartPage();
        steps.openRepositoryPage(query);
        steps.clickRepositoryLink(query);
        steps.clickIssuesTab();
        steps.countIssues(expectNum);

    }

}
