package org.tgo.jpa.util.people;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class ClientStatusConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean active) {
        return active ? 1 : 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer active) {
        return active == 1;
    }

}
