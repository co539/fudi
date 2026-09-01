package pe.fudi.iam.infrastructure.persistence.jpa.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import pe.fudi.iam.domain.model.valueobjects.Username;

@Converter(autoApply = true)
public class UsernameConverter implements AttributeConverter<Username, String> {

    @Override
    public String convertToDatabaseColumn(Username attribute) {
        return attribute == null ? null : attribute.value();
    }

    @Override
    public Username convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new Username(dbData);
    }
}