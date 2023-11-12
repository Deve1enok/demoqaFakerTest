package tests;

import org.junit.jupiter.api.Test;
import pages.DataFakerUser;
import pages.RegistrationFormPage;

public class RegistrationFormPageObjectTest extends BaseTest {
    RegistrationFormPage registrationPage = new RegistrationFormPage();
    DataFakerUser fakerData = new DataFakerUser();




    @Test
    void registrationForm() {



        registrationPage.openPage()
                .disableBanner()
                .setFirstName(fakerData.firstName)
                .setLastName(fakerData.lastName)
                .setUserEmail(fakerData.userEmail)
                .setGenderInput(fakerData.gender)
                .setUserNumber(fakerData.number)
                .setDateBirthday(fakerData.dayBirth, fakerData.monthBirth, fakerData.yearBirth)
                .setSubject(fakerData.subject)
                .setHobbies(fakerData.hobbies)
                .choosePicture("img/CssNEO.jpg")
                .setAddress(fakerData.currentAddress)
                .setState(fakerData.getState)
                .setCity(fakerData.getCity)
                .setSubmit()



                .checkForm("Student Name", fakerData.firstName)
                .checkForm("Student Name", fakerData.lastName)
                .checkForm("Student Email",fakerData.userEmail)
                .checkForm("Gender", fakerData.gender)
                .checkForm("Mobile", fakerData.number)
                .checkForm("Date of Birth", fakerData.dayBirth)
                .checkForm("Date of Birth", fakerData.monthBirth)
                .checkForm("Date of Birth", fakerData.yearBirth)
                .checkForm("Subjects", fakerData.subject)
                .checkForm("Hobbies", fakerData.hobbies)
                .checkForm("Picture", "CssNEO.jpg")
                .checkForm("Address", fakerData.currentAddress)
                .checkForm("State and City", fakerData.getState)
                .checkForm("State and City", fakerData.getCity);

    }
    @Test
    void minimalFieldsData() {
        registrationPage.openPage()
                .setFirstName(fakerData.minFirstName)
                .setLastName(fakerData.minLastName)
                .setGenderInput(fakerData.gender)
                .setUserNumber(fakerData.number)
                .setSubmit()

                .checkForm("Student Name", fakerData.minFirstName)
                .checkForm("Student Name", fakerData.minLastName)
                .checkForm("Gender", fakerData.gender)
                .checkForm("Mobile", fakerData.number);

    }
    @Test
    void negativeTestData() {
        registrationPage.openPage()
                .setEmptyFirstName("")
                .setLastName(fakerData.lastName)
                .setGenderInput(fakerData.gender)
                .setUserNumber(fakerData.number)
                .setSubmit()

                .checkNameInputIsEmptyAndRedBordered()
                .checkTableNotAppeared();
    }
}
