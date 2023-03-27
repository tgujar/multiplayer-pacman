//package com.game.mutliplayerpacman.models;
//
//import com.game.mutliplayerpacman.service.impl.Cell;
//import jakarta.persistence.AttributeConverter;
//import jakarta.persistence.Converter;
//import java.io.*;
//
//@Converter(autoApply = true)
//public class CellArrayConverter implements AttributeConverter<Cell[][], byte[]> {
//
//    @Override
//    public byte[] convertToDatabaseColumn(Cell[][] lc) {
//        try {
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//            objectOutputStream.writeObject(lc);
//            objectOutputStream.flush();
//            return byteArrayOutputStream.toByteArray();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Cell[][] convertToEntityAttribute(byte[] bytes) {
//        try {
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//            return (Cell[][]) objectInputStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}