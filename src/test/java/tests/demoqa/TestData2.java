package tests.demoqa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;

import java.util.Locale;

public class TestData2 {
    Faker faker = new Faker(new Locale("en"));
    String firstName,
            lastName,
            userEmail,
            userNumber,
            gender,
            userPic,
            day,
            month,
            year,
            userAddress,
            city,
            state,
            subject,
            hobby;

    @BeforeEach
    void prepareTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        gender = "Male";
        userPic = "DSC07524.JPG";
        userNumber = faker.phoneNumber().subscriberNumber(10);
        day = faker.number().numberBetween(1, 28) + "";
        month = "July";
        userAddress = faker.address().fullAddress();
        year = faker.number().numberBetween(2000, 2010) + "";
        city = "NCR";
        state = "Delhi";
        subject = "Math";
        hobby = "Sports";

    }
}
