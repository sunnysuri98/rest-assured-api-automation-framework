package com.demo.api.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestDataGenerator {

    private static final Faker DATA = new Faker(new Locale("en-IND"));

    public static String firstName() {
        return DATA.name().firstName();
    }

    public static String lastName() {
        return DATA.name().lastName();
    }

    public static String email() {
        return firstName().toLowerCase() + "." + lastName().toLowerCase() + "@" + DATA.internet().domainName();
    }

    public static String mobileNumber() {
        return DATA.numerify("##########");
    }

    public static String username() {
        return firstName().toLowerCase() + lastName().toLowerCase() + DATA.number().digits(3);
    }

    public static String password() {
        return DATA.internet().password(8, 16, true, true, true);
    }

}
