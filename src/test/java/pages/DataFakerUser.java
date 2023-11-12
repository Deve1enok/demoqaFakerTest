package pages;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataFakerUser {

    private final Faker ruFaker = new Faker(new Locale("ru"));
    private final Faker enFaker = new Faker(new Locale("en"));

    public String firstName = ruFaker.name().firstName();
    public String lastName = ruFaker.name().lastName();
    public String userEmail = enFaker.internet().emailAddress();
    public String number = ruFaker.phoneNumber().subscriberNumber(10);
    public String gender = ruFaker.options().option("Male", "Female", "Other");
    public String dayBirth = String.valueOf(ruFaker.number().numberBetween(1, 31));
    public String monthBirth = ruFaker.options().option("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    public String yearBirth = String.valueOf(ruFaker.number().numberBetween(1900, 2100));
    public String subject = ruFaker.options().option("Math", "English", "Chemistry", "Physics", "Computer Science", "Economics", "Arts",
            "Social Studies", "History", "Civics", "Hindi", "Biology", "Accounting", "Commerce");
    public String hobbies = ruFaker.options().option("Sports", "Reading", "Music");
    public String currentAddress = ruFaker.letterify("А123БЮабвгд");
    public String getState = ruFaker.options().option("NCR", "Utta Pradesh", "Haryana", "Rajasthan");
    public String getCity = randomCity(getState);
    public String minFirstName = ruFaker.letterify("?");
    public String minLastName = ruFaker.letterify("?");

    public static String randomCity (String state) {
        Faker faker = new Faker();
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Utta Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipat");


            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
        }
        return state;
    }
}

