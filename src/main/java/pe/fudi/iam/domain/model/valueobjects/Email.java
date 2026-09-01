package pe.fudi.iam.domain.model.valueobjects;

import java.util.Locale;

public record Email(String value) {

    public Email {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email must not be blank");
        }

        value = value.trim().toLowerCase(Locale.ROOT);

        if (value.length() > 120) {
            throw new IllegalArgumentException("Email is too long");
        }

        int at = value.indexOf('@');
        String domain = at < 0 ? "" : value.substring(at + 1);

        boolean valid = at > 0
                && at == value.lastIndexOf('@')
                && domain.contains(".")
                && !domain.startsWith(".")
                && !domain.endsWith(".");

        if (!valid) {
            throw new IllegalArgumentException("Email format is invalid");
        }
    }
}
