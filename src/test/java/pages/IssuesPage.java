package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class IssuesPage {

    public ElementsCollection getIssueList() {
        return $$x("//div[contains(@id, 'issue')]");
    }

    public int getIssueCount() {
        return Integer.parseInt($("#issues-repo-tab-count").getAttribute("textContent"));
    }

}
