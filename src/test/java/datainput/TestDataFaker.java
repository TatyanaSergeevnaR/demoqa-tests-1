package datainput;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataFaker {
    Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String streetAddress = faker.address().streetAddress();
    public String genter = faker.options().option("Male", "Female", "Other");
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String monthOfBirth = faker.options().option
            ("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String yearOfBirth = String.format("%s",faker.number().numberBetween(1980,2020));
    public String dayOfBirth = String.format("%s",faker.number().numberBetween(1,28));
    public String subject = faker.options().option("Maths", "Accounting", "Social Studies", "Arts", "Physics");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity();

    public String getRandomCity()
    {
        if (state.equals( "NCR"))
        {
            city = faker.options().option("Delhi","Gurgaon","Noida");
        }
        if (state.equals("Uttar Pradesh"))
        {
            city = faker.options().option("Agra","Lucknow","Merrut");
        }
        if (state.equals("Haryana"))
        {
            city = faker.options().option("Karnal","Panipat");
        }
        if (state.equals("Rajasthan"))
        {
            city = faker.options().option("Jaipur","Jaiselmer");
        }
        return city;
    }
}
