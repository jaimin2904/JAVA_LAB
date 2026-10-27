package com.minibank.util;
import com.minibank.model.Id;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
public class Repository<T> {
    private final HashMap<String, T> items = new HashMap<>();
    public T save(T item) {
        try {
            Class<?> type = item.getClass();
            while (type != null) {
                for (Field field : type.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Id.class)) {
                        field.setAccessible(true);
                        items.put(field.get(item).toString(), item);
                        return item;
                    }
                }
                type = type.getSuperclass();
            }
            throw new IllegalArgumentException("No @Id field found");
        } catch (ReflectiveOperationException e) { throw new IllegalArgumentException(e); }
    }
    public T findById(String id) { return items.get(id); }
    public ArrayList<T> findAll() { return new ArrayList<>(items.values()); }
    public boolean delete(String id) { return items.remove(id) != null; }
    @SafeVarargs public final void saveAll(T... values) { for (T value : values) save(value); }
    public static <N extends Number> double average(N[] values) {
        if (values.length == 0) return 0;
        double sum = 0;
        for (N value : values) sum += value.doubleValue();
        return sum / values.length;
    }
}
