package Lab9;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("D:\\Java\\JavaForPDI\\IO\\Assignment\\Person.csv");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Person person = (Person) in.readObject();
        in.close();
        fileIn.close();

        person.displayInfo();
    }
}
