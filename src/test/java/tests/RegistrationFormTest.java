package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.RegistartionFormPage;

/**
 * @author eazanova
 * @since 03.04.2022
 */
public class RegistrationFormTest extends TestBase
{
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.rickAndMorty().quote(),
            userNumber = "1234567890",
            gender = "Female",
            subject = "Biology",
            hobby = "Music",
            state = "NCR",
            city = "Delhi",
            path = "1.png",
            day = "13",
            month = "September",
            year = "2000";

    RegistartionFormPage registartionFormPage = new RegistartionFormPage();

    @Test
    @Description("Тестирование фрмы регистрации")
    void testRegistrationStudent()
    {
        Allure.step("Открываем automation-practice-form", () ->{
            registartionFormPage.openPage();
        });

        Allure.step("Заполняем поля на форме", () ->{
            registartionFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setDate(day, month, year)
                    .setSubject(subject)
                    .setHobby(hobby)
                    .setImage(path)
                    .setAddress(currentAddress)
                    .setState(state)
                    .setCity(city)
                    .clickSubmit();
        });

        Allure.step("Проверяем", () ->{
            registartionFormPage.checkResult(firstName)
                    .checkResult(lastName)
                    .checkResult(userEmail)
                    .checkResult(gender)
                    .checkResult(userNumber)
                    .checkResult(day)
                    .checkResult(month)
                    .checkResult(year)
                    .checkResult(subject)
                    .checkResult(hobby)
                    .checkResult(path)
                    .checkResult(currentAddress)
                    .checkResult(state)
                    .checkResult(city);
        });
    }
}
