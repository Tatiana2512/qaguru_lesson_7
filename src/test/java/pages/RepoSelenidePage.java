package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RepoSelenidePage {

    SelenideElement IssuesTab = $("#issues-tab");

    public IssuesPage getIssues(){
        IssuesTab.click();
        return new IssuesPage();
    }

}
