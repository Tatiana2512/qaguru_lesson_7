package allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.name;

public class WebSteps {


    @Step("Open Github main page")
    public void openStartPage() {
        open("/");
    }


    @Step("Open page repository {query}")
    public void openRepositoryPage(String query) {
        $(name("q")).click();
        $(name("q")).setValue(query).pressEnter();
    }

    @Step("Click repository link {query}")
    public void clickRepositoryLink(String query) {
        $(By.linkText(query)).click();
    }

    @Step("Click Issues tab")
    public void clickIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Counting Issue items, should be {num}")
    public void countIssues(int num) {
        int count = Integer.parseInt($("#issues-repo-tab-count").getAttribute("textContent"));
        Assertions.assertEquals(num, count);
        attachScreenshot();
    }

    @Attachment(value = "Мой любимый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}

