import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @BeforeEach
    public void init() {
        Configuration.pageLoadStrategy = "eager";
    }

    public static void openUrl(String url) {
        open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test
    void successfulSearchTest() {
        openUrl("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
        System.out.println("GOOD");
    }
}
