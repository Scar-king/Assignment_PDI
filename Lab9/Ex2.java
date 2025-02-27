package Lab9;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex2 {
    private static final String FILE_NAME = "StudentData.csv";
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            Scanner scanner = new Scanner(System.in);

            String name;
            String id;
            String major;
            
            //Header
            writer.write("id,name,major\n");

            for(int i = 0; i < 3; i++){
                System.out.println("\n\n\t*** Getting data for student " + (i + 1));
                System.out.print("Enter Student Name: ");
                name = scanner.nextLine();
                System.out.print("Enter Student ID: ");
                id = scanner.nextLine();
                System.out.print("Enter Student Major: ");
                major = scanner.nextLine();

                writer.write(id + "," + name + "," + major + "\n");
            }

            System.out.println("Process Completed!");

            scanner.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
