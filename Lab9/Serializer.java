package Lab9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {
    private static final String FILE_NAME = "Person.csv";
    public static void main(String[] args) {
        Person person = new Person("Davin", 20, "p20230018");
        try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
        ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            fileOut.close();
            out.close();
            System.out.println("Object Person serialized to " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
