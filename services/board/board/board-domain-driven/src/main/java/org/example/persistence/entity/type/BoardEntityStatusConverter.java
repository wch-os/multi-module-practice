package org.example.persistence.entity.type;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BoardEntityStatusConverter implements AttributeConverter<BoardEntityStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BoardEntityStatus status) {
        return (status != null) ? status.getValue() : null;
    }

    @Override
    public BoardEntityStatus convertToEntityAttribute(Integer value) {
        return (value != null) ? BoardEntityStatus.valueOf(value) : null;
    }
}
