package ru.mfti.koltunov;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class DefaultValues {
    static final Map<Class<?>, Object> defaultValues = new HashMap<Class<?>, Object>();

    public static final <T> T defaultValueFor(@NotNull Class<T> tClass) {
        return (T) defaultValues.get(tClass);
    }

    static {
        defaultValues.put(boolean.class, Boolean.FALSE);
        defaultValues.put(byte.class, (byte) 0);
        defaultValues.put(short.class, (short) 0);
        defaultValues.put(int.class, 0);
        defaultValues.put(long.class, 0L);
        defaultValues.put(char.class, '\0');
        defaultValues.put(float.class, 0.0F);
        defaultValues.put(double.class, 0.0);
    }

    @Override
    public String toString() {
        return "DefaultValues{}";
    }
}
