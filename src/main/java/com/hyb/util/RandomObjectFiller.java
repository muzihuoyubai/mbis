package com.hyb.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomObjectFiller {

    private Random random = new Random();

    public <T> T createAndFill(Class<T> clazz) throws Exception {
        T instance = clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = getRandomValueForField(field);
            field.set(instance, value);
        }
        return instance;
    }

    public <T> T createAndFill(Class<T> clazz, int index) throws Exception {
        T instance = clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = getRandomValueForField(field,index);
            field.set(instance, value);
        }
        return instance;
    }

    private Object getRandomValueForField(Field field) throws Exception {
        Class<?> type = field.getType();
        // Note that we must handle the different types here! This is just an 
        // example, so this list is not complete! Adapt this to your needs!
        if (type.isEnum()) {
            Object[] enumValues = type.getEnumConstants();
            return enumValues[random.nextInt(enumValues.length)];
        } else if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            return random.nextInt(5000);
        } else if (type.equals(Long.TYPE) || type.equals(Long.class)) {
            return random.nextLong();
        } else if (type.equals(Double.TYPE) || type.equals(Double.class)) {
            return random.nextDouble();
        } else if (type.equals(Float.TYPE) || type.equals(Float.class)) {
            return random.nextFloat();
        } else if (type.equals(String.class)) {
            return UUID.randomUUID().toString();
        } else if (type.equals(Byte.class)) {
            return new Byte((byte)0x01);
        }else if (type.equals(BigInteger.class)) {
            return BigInteger.valueOf(random.nextInt());
        } else if (type.equals(BigDecimal.class)) {
            return BigDecimal.valueOf(random.nextDouble()).setScale(2,BigDecimal.ROUND_UP);
        } else if (type.equals(Date.class)) {
            return new Date(System.currentTimeMillis() + random.nextInt(100000000));
        } else if (type.equals(Boolean.class)) {
            return random.nextBoolean();
        }
        return createAndFill(type);
    }

    private Object getRandomValueForField(Field field, int index) throws Exception {
        Class<?> type = field.getType();
        // Note that we must handle the different types here! This is just an
        // example, so this list is not complete! Adapt this to your needs!

        if (type.equals(String.class)) {
            return field.getName() + "_" + index;
        } else {
            return getRandomValueForField(field);
        }
    }
}