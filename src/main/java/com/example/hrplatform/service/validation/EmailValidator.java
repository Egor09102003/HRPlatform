package com.example.hrplatform.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    final Pattern pattern;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate(final String hex) {
        Matcher matcher = pattern.matcher(hex);

        return matcher.matches();
    }
}
