package org.example.HomeWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public ValidateEmail() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate(final String str) {
        matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
