package com.minibank.util;
import com.minibank.model.MaxLength;
import com.minibank.model.Positive;
import java.lang.reflect.Field;
public class AnnotationValidator {
    public static boolean isValid(Object object) {
        try {
            Class<?> type = object.getClass();
            while (type != null) {
                for (Field field : type.getDeclaredFields()) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(Positive.class) && field.getLong(object) < 0) return false;
                    if (field.isAnnotationPresent(MaxLength.class)) {
                        Object value = field.get(object);
                        if (value != null && value.toString().length() > field.getAnnotation(MaxLength.class).value()) return false;
                    }
                }
                type = type.getSuperclass();
            }
            return true;
        } catch (ReflectiveOperationException e) { return false; }
    }
}
