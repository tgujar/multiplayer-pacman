package com.game.mutliplayerpacman.models;

import com.game.mutliplayerpacman.service.impl.Coordinate;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.io.*;
import java.util.*;

@Converter(autoApply = true)
public class CoordinateListConverter implements AttributeConverter<List<Coordinate>, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(List<Coordinate> lc) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(lc);
            objectOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Coordinate> convertToEntityAttribute(byte[] bytes) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (List<Coordinate>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}