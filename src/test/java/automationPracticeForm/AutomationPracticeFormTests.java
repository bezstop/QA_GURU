package automationPracticeForm;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AutomationPracticeFormTests extends PrepareForTests {

    public static final String NAME = "Игорь";
    public static final String SURNAME = "Яковлев";
    public static final String EMAIL = "x@x.ru";
    public static final String PHONE_NUMBER = "1234567890";
    public static final String DECEMBER = "December";
    public static final String YEAR = "1987";
    public static final String ARTS = "Arts";
    public static final String TEXT = "Мой адрес не дом и не улица";
    public static final String THANKS_FOR_SUBMITTING_THE_FORM = "Thanks for submitting the form";

    @Test
    void checkAutomationPracticeForm() {
        openUrl("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(NAME);
        $("#lastName").setValue(SURNAME);
        $("#userEmail").setValue(EMAIL);
        $("label[for='gender-radio-3']").click();
        $("#userNumber").setValue(PHONE_NUMBER);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(DECEMBER);
        $(".react-datepicker__year-select").selectOption(YEAR);
        $(".react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(ARTS).pressEnter();
        $("label[for='hobbies-checkbox-2']").click();
        File file = new File("src/test/resources/12345.png");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(TEXT);
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(THANKS_FOR_SUBMITTING_THE_FORM));
        $(".table-responsive").shouldHave(text(NAME),
                text(NAME),
                text(SURNAME),
                text(EMAIL),
                text(PHONE_NUMBER),
                text(YEAR),
                text(DECEMBER),
                text(ARTS),
                text(TEXT));
    }
}
