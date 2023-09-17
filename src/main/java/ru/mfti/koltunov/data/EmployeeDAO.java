package ru.mfti.koltunov.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static Connection conn;

    private static Statement stm;

//    public static List<Employee> getAll(){
//        List<Employee> lst = new ArrayList<>();
//        try {
//            ResultSet rs = stm.executeQuery("select * from employee");
//            while (rs.next()){
//                lst.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3)));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return lst;
//    }
//
//    public List<Employee> getEmployeesById(int i) {
//        List<Employee> result = new ArrayList<>();
//        try {
//            ResultSet rs = stm.executeQuery("select * from imployee where id = " + i + ";");
//            while (rs.next()) {
//                if (rs.getInt(1) == i) {
//                    result.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3)));
//                }
//            }
//        } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        return result;
//    }
//
//    public static void addEmployee (Employee e){
//        try {
//            stm.execute("insert into employee (id, departmentId, name) values (" + e.id + "," + e.departmentId + ",'"
//                    + e.name + "');");
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    public static void popEmployeeById(int i) {
//        try {
//            stm.execute("delete from imployee where id = " + i + ";");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void updateEmployeeId(int oldId, int newId) {
//        try {
//            stm.execute("Update employee\n" + "set id = " + newId + "where id = " + oldId + ";");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
