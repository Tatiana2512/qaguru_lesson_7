package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.IssuesPage;
import pages.RepoListPage;
import pages.RepoSelenidePage;
import pages.StartPage;

import static io.qameta.allure.Allure.step;

public class LambdaStepTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com";
    }

    StartPage startPage = new StartPage();
    RepoListPage repoListPage = new RepoListPage();
    RepoSelenidePage repoSelenidePage = new RepoSelenidePage();
    IssuesPage issuesPage = new IssuesPage();

    private final String REPO = "selenide/selenide";
    private final int NUM = 25;


    @Test
    @DisplayName("Test with Lambda step annotations")
    @Owner("Tatiana Belotserkovskaia")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Issues in repository")
    @Story("Looking up for issues in repository")
    public void lambdaTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            startPage.openPage();
        });

        step("Search for repository " + REPO, () -> {
            startPage.openRepoList(REPO);
        });

        step("Click link " + REPO, () -> {
            repoListPage.getExactRepo(REPO);
        });

        step("Click Issues tab", () -> {
            repoSelenidePage.getIssues();
        });

        step("Count Issues items", () -> {
            Assertions.assertEquals(NUM, issuesPage.getIssueList().size());
        });

    }

}
