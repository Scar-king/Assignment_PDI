package Lab9;

import java.io.*;
import java.util.*;

class Student {
    String id;
    String name;
    String major;

    public Student(String id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + major;
    }
}

public class Ex3 {
    private static final String FILE_NAME = "StudentData.csv";

    public static void main(String[] args) {
        List<Student> students = loadStudentsFromFile(FILE_NAME);
        
        System.out.println("\tData from ArrayList: \n");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static List<Student> loadStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    students.add(new Student(data[0], data[1], data[2]));
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}

