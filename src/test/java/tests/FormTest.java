package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Test";
    String lastName = "Testovy";
    String userEmail = "pochta@tail.ru";
    String gender = "Male";
    String userNumber = "0123456789";
    String day = "15";
    String month = "June";
    String year = "1999";
    String subject = "Maths";
    String hobby = "Reading";
    String namePicture = "picture.jpg";
    String adress = "Minsk";
    String state = "NCR";
    String city = "Delhi";
    String userName = firstName + " " + lastName;
    String date = day + " " + month + "," + year;


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage.openPage();
        registrationPage.verifyHeader();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(userEmail);
        registrationPage.setGender(gender);
        registrationPage.setUserNumber(userNumber);
        registrationPage.setBirthDate(day, month, year);
        registrationPage.setSubject(subject);
        registrationPage.setHobby(hobby);
        registrationPage.pictureUpload(namePicture);
        registrationPage.setAdress(adress);
        registrationPage.setState(state);
        registrationPage.setCity(city);
        registrationPage.sendForm();

        registrationPage.verifyForm(userName, userEmail, gender, userNumber, date, subject, hobby, namePicture, adress, state, city);

    }
}