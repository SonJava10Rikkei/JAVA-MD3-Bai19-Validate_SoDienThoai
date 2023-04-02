package rikkei.academy.validate;

import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static final String PHONE_REGEX = "^\\d{2}-0\\d{9}$";

    public ValidatePhoneNumber() {

    }

    public boolean validate(String regex) {
        return Pattern.matches(PHONE_REGEX, regex);
    }

}
