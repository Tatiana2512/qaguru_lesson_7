package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.name;

public class StartPage {
    SelenideElement SearchInput = $(name("q"));

    public StartPage openPage() {
        open("/");
        return this;
    }

    public RepoListPage openRepoList(String repo) {
        SearchInput.click();
        SearchInput.setValue(repo).pressEnter();

        return new RepoListPage();
    }
}
