package ru.mfti.koltunov.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationContext;
import java.util.Scanner;

@SpringBootConfiguration
public class SpringBootUpp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootUpp.class, args);

        EmployeeRepo employeeRepo = context.getBean(EmployeeRepo.class);
        Scanner scanner = context.getBean(Scanner.class);

        String command = "";
        printMenu();

        while (!command.equals("5")) {
            command = scanner.nextLine();

            switch (command) {
                case "1" -> {
                    command = "";
                    System.out.println("Enter the name or type 5 for exit");
                    String name = scanner.nextLine();

                    if (name.equals("5")) {
                        break;
                    }

                    System.out.println("Enter the Department ID or type 5 for exit");
                    String departmentIdStr = scanner.nextLine();

                    if (departmentIdStr.equals("5")) {
                        break;
                    }

                    long departmentId = Long.parseLong(departmentIdStr);
                    Employee employee = new Employee();
                    employee.departmentId = departmentId;
                    employee.name = name;

                    employeeRepo.save(employee);
                    System.out.println("saved " + employee);
                }
                case "2" -> {
                    command = "";
                    System.out.println("Enter employee's name or id:");
                    String param = scanner.next();
                    if (isLong(param)) {
                        Long employeeId = Long.valueOf(param);
                        employeeRepo.findById(employeeId).ifPresent(employeeRepo::delete);
                        System.out.println("Delete by id: " + employeeId);
                    } else {
                        Iterable<Employee> employees = employeeRepo.findByName(param);
                        for (Employee employee : employees) {
                            employeeRepo.delete(employee);
                        }
                        System.out.println("Delete by name: " + param);
                    }
                }
                case "3" -> {
                    command = "";
                    System.out.println("Enter employee's name or id:");
                    String param = scanner.next();
                    Employee employee;
                    if (isLong(param)) {
                        Long employeeId = Long.valueOf(param);
                        employee = employeeRepo.findById(employeeId).orElse(null);
                    } else {
                        Iterable<Employee> employees = employeeRepo.findByName(param);
                        employee = employees.iterator().next();
                    }
                    if (employee == null) {
                        System.out.println();
                        break;
                    }
                    System.out.println("Enter new name");
                    employee.name = scanner.next();
                    System.out.println("Enter new Department id");
                    employee.departmentId = Long.valueOf(scanner.next());
                    employeeRepo.save(employee);
                    System.out.println("Saved: " + employee);
                }
                case "4" -> {
                    command = "";
                    System.out.println(employeeRepo.findAll());
                }
                case "5" -> {
                }
                case "6" -> {
                    printMenu();
                }
                default -> {
                    command = "";
                    System.out.println("Enter command please");
                }
            }
        }


    }

    public static void printMenu() {
        System.out.println("Select * for employees actions:");
        System.out.println("select 1 for add");
        System.out.println("select 2 for delete");
        System.out.println("select 3 for edit");
        System.out.println("select 4 for all");
        System.out.println("select 5 for exit");
        System.out.println("select 6 for repeat menu");

    }

    public static boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

