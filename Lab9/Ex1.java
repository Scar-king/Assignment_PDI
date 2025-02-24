package Lab9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {
        Random random = new Random();

        try {
            FileWriter writer = new FileWriter("D:\\Java\\JavaForPDI\\IO\\Assignment\\LuckyNumber.txt");

            int max = 0;
            int min = 0;

            for (int i = 0; i < 10; i++) {
                int numbers = random.nextInt(1000);
                writer.write(numbers + "\n");

                if(numbers > max){
                    max = numbers;
                }
                if(numbers < min){
                    min = numbers;
                }
            }

            writer.write("\nThe Biggest number is " + max);
            writer.write("\nThe smallest number is " + min);

            writer.close();

            System.out.println("Program terminates!");

            BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\JavaForPDI\\IO\\Assignment\\LuckyNumber.txt"));

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}