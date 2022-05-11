package tests;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author eazanova
 * @since 03.04.2022
 */
public class DemoQaTest extends TestBase
{
    @Test
    @DisplayName("Тестирование формы регистрации")
    void testRegistrationStudent()
    {
        String firstName = "Maria";
        String lastName = "Mironova";
        String userEmail = "mm@mail.com";
        String gender = "Female";
        String userNumber = "1234567890";
        String subjects = "Biology";
        String hobbies = "Music";
        String currentAddress = "Street";
        String state = "NCR";
        String city = "Delhi";

        Allure.step("Открываем automation-practice-form", () ->{
            open("/automation-practice-form");
        });

        Allure.step("Заполняем поля на форме", () ->{
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(userEmail);
            $("#genterWrapper").$(byText(gender)).click();
            $("#userNumber").setValue(userNumber);

            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("September");
            $(".react-datepicker__year-select").selectOption("2000");
            $("[aria-label$='September 13th, 2000']").click();
            $("#subjectsInput").setValue(subjects).pressEnter();

            $(byText(hobbies)).click();
            $("#uploadPicture").uploadFromClasspath("file/1.png");
            $("#currentAddress").setValue(currentAddress);

            $("#state").click();
            $(byText(state)).click();
            $("#city").click();
            $(byText(city)).click();

            $("#submit").click();
        });

        Allure.step("Проверяем", () ->{
            $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(gender),
                    text(userNumber), text("September 13th,2000"), text(subjects), text(hobbies), text(currentAddress),
                    text(state), text(city));
        });
    }
}