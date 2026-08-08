package pe.fudi.iam.domain.model.valueobjects;

import java.util.Locale;

public record Username(String value) {

    public Username {

        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Username must not be blank");

        value = value.trim().toLowerCase(Locale.ROOT);

        if (value.length() < 3 || value.length() > 30)
            throw new IllegalArgumentException("Username must be 3-30 characters");

        for (char c : value.toCharArray()) {
            boolean allowed = (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')  || c == '_' || c == '.';
            if (!allowed)
                throw new IllegalArgumentException("Username may only contain letters, numbers, underscores and periods");
        }

        if (value.startsWith(".") || value.endsWith(".") || value.contains(".."))
            throw new IllegalArgumentException("Username has invalid period placement");
    }
}
