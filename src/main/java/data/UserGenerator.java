package data;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {


    @Step("Создание случайного пользователя")
    public static UserData getRandomUser() {
        String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);

        return new UserData(email, password, name);
    }

}
