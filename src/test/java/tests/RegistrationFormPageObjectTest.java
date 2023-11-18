package tests;

import org.junit.jupiter.api.Test;
import utils.DataUser;
import pages.RegistrationFormPage;

public class RegistrationFormPageObjectTest extends BaseTest {
    RegistrationFormPage registrationPage = new RegistrationFormPage();
    DataUser fakerData = new DataUser();

    @Test
    void registrationForm() {



        registrationPage.openPage()
                .disableBanner()
                .setFirstName(fakerData.firstName)
                .setLastName(fakerData.lastName)
                .setUserEmail(fakerData.userEmail)
                .setGenderInput(fakerData.gender)
                .setUserNumber(fakerData.number)
                .setDateBirthday(fakerData.randomDayOnMonth, fakerData.monthBirth, fakerData.yearBirth)
                .setSubject(fakerData.subject)
                .setHobbies(fakerData.hobbies)
                .choosePicture(fakerData.picWithPath)
                .setAddress(fakerData.currentAddress)
                .setState(fakerData.getState)
                .setCity(fakerData.getCity)
                .setSubmit()

                .checkForm(fakerData.fieldStudentName, fakerData.firstName)
                .checkForm(fakerData.fieldStudentName, fakerData.lastName)
                .checkForm(fakerData.fieldStudentEmail,fakerData.userEmail)
                .checkForm(fakerData.fieldGender, fakerData.gender)
                .checkForm(fakerData.fieldNumber, fakerData.number)
                .checkForm(fakerData.fieldDateOfBirth, fakerData.randomDayOnMonth)
                .checkForm(fakerData.fieldDateOfBirth, fakerData.monthBirth)
                .checkForm(fakerData.fieldDateOfBirth, fakerData.yearBirth)
                .checkForm(fakerData.fieldSubjects, fakerData.subject)
                .checkForm(fakerData.fieldHobbies, fakerData.hobbies)
                .checkForm(fakerData.fieldPicture, fakerData.pic)
                .checkForm(fakerData.fieldAddress, fakerData.currentAddress)
                .checkForm(fakerData.fieldStateAndCity, fakerData.getState)
                .checkForm(fakerData.fieldStateAndCity, fakerData.getCity);
    }
    @Test
    void minimalFieldsData() {
        registrationPage.openPage()
                .setFirstName(fakerData.minFirstName)
                .setLastName(fakerData.minLastName)
                .setGenderInput(fakerData.gender)
                .setUserNumber(fakerData.number)
                .setSubmit()

                .checkForm(fakerData.fieldStudentName, fakerData.minFirstName)
                .checkForm(fakerData.fieldStudentName, fakerData.minLastName)
                .checkForm(fakerData.fieldGender, fakerData.gender)
                .checkForm(fakerData.fieldNumber, fakerData.number);

    }
    @Test
    void negativeTestData() {
        registrationPage.openPage()
                .setLastName(fakerData.lastName)
                .setGenderInput(fakerData.gender)
                .setUserNumber(fakerData.number)
                .setSubmit()

                .checkNameInputIsEmptyAndRedBordered()
                .checkLastNameField(fakerData.lastName)
                .checkGenderField(fakerData.gender)
                .checkNumberField(fakerData.number)
                .checkTableNotAppeared();
    }
}
