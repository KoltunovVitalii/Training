package ru.mfti.koltunov.data;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UNIEmployeeDAO<T> {
    private static Connection conn;

    private static Statement stm;
    T t;

    public List<T> getAll() {
        List<T> lst = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery("SELECT * FROM " + t.getClass().getSimpleName());
            while (rs.next()) {
                T obj = createObjectFromResultSet(rs);
                lst.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }

    private T createObjectFromResultSet(ResultSet rs) {
        T obj;
        try {
            obj = (T) t.getClass();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = rs.getObject(fieldName);
                field.set(obj, value);
            }
        } catch (IllegalAccessException | SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
}
