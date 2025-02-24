package Lab9;

import java.io.Serializable;

public class Person implements Serializable{
    String name;
    int age;
    String id;
    public Person(String name, int age, String id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public void displayInfo(){
        System.out.println("NAME,AGE,ID\n");
        System.out.println(name + "," + age + "," + id);
    }
}
