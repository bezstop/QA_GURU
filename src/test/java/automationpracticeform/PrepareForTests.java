package automationpracticeform;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class PrepareForTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    public void init() {
        Configuration.pageLoadStrategy = "eager";
    }

    public static void openUrl(String url) {
        open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void close() {
        Selenide.closeWebDriver();
    }

}
