package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.IssuesPage;
import pages.RepoListPage;
import pages.RepoSelenidePage;
import pages.StartPage;

import static com.codeborne.selenide.CollectionCondition.size;

public class Tests {

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
    @DisplayName("Test with Selenide logger")
    @Owner("Tatiana Belotserkovskaia")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Issues in repository")
    @Story("Looking up for issues in repository")
    public void pureSelenide() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        startPage.openPage().openRepoList(REPO);
        repoListPage.getExactRepo(REPO);
        repoSelenidePage.getIssues();
        issuesPage.getIssueList().shouldHave(size(NUM));

    }

}
