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

import static com.codeborne.selenide.CollectionCondition.size;
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

    String query = "selenide/selenide";
    int expectNum = 25;

    @Test
    public void lambdaTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            startPage.openPage();
        });

        step("Ищем репозиторий " + query, () -> {
            startPage.openRepoList(query);
        });

        step("Переходим по ссылке репозитория " + query, () -> {
            repoListPage.getExactRepo(query);
        });

        step("Вызываем вкладку Issues", () -> {
            repoSelenidePage.getIssues();
        });

        step("Считаем количество записей", () -> {
            Assertions.assertEquals(expectNum, issuesPage.getIssueCount());
        });

    }

}
