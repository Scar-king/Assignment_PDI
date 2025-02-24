package Lab9;

import java.io.*;
import java.util.*;

class Employee {
    String id;
    String name;
    int age;
    String email;
    String salary;

    public Employee(String id, String name, int age, String email, String salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + email + "," + salary;
    }
}

public class Ex5 {
    private static final String FILE_NAME = "EmployeeData.csv";
    private static final String LOG_FILE = "ErrorLog.txt";

    public static void main(String[] args) {
        List<Employee> employees = loadEmployeesFromFile(FILE_NAME);
        
        System.out.println("\tThe Correct Format: \n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static List<Employee> loadEmployeesFromFile(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(fileName));  
            BufferedWriter logWriter = new BufferedWriter(new FileWriter(LOG_FILE));  

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                String id = data[0].trim();
                String name = data[1].trim();
                String ageStr = data[2].trim();
                String email = data[3].trim();
                String salary = data[4].trim();
                
                if (id.isEmpty() || name.isEmpty() || ageStr.isEmpty() || email.isEmpty() || salary.isEmpty()) {
                    logWriter.write("Missing values: " + line);
                    logWriter.newLine();
                    continue;
                }
                
                int age;
                try {
                    age = Integer.parseInt(ageStr);
                    if (age < 0) {
                        logWriter.write("Invalid age (negative): " + line);
                        logWriter.newLine();
                        continue;
                    }
                } catch (NumberFormatException e) {
                    logWriter.write("Invalid age format: " + line);
                    logWriter.newLine();
                    continue;
                }
                
                if (!salary.matches("\\d+")) {
                    logWriter.write("Invalid salary format: " + line);
                    logWriter.newLine();
                    continue;
                }
                
                employees.add(new Employee(id, name, age, email, salary));
            }

            br.close();
            logWriter.close();

        } catch (IOException e) {
            e.getStackTrace();
        }
        return employees;
    }
}
