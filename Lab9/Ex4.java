package Lab9;

import java.io.*;
import java.util.*;

class Student {
    String name;
    String id;
    String major;

    public Student(String name, String id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }

    @Override
    public String toString() {
        return id + "," + name + "," +  major;
    }
}

public class Ex4 {
    private static final String FILE_NAME = "StudentData.csv";

    public static void main(String[] args) {
        List<Student> students = loadStudentsFromFile(FILE_NAME);
        Scanner scanner = new Scanner(System.in);
        
        for(int i = 0; i < 2; i++){
            System.out.print("\nEnter Student ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student MAJOR: ");
            String major = scanner.nextLine();
            students.add(new Student(id, name, major));
        }

        students.sort(Comparator.comparing(s -> s.name));
        
        writeStudentsToFile(FILE_NAME, students);

        scanner.close();
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
            e.getStackTrace();
        }
        return students;
    }

    private static void writeStudentsToFile(String fileName, List<Student> students) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            // bw.write("ID,NAME,MAJOR\n");
            for (Student student : students) {
                bw.write(student.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
