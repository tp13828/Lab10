

//import java.io.* to get all import
import java.io.*;

public class Lab10Prob01 {
    public static void main(String[] args) throws IOException {
        try (DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream("src/people.dat")));
             DataOutputStream output = new DataOutputStream(
                     new BufferedOutputStream(new FileOutputStream("src/people-copy.dat")));) {

            while (true) {
                // Variables
                int age = input.readInt();
                String name = input.readUTF();
                String address = input.readUTF();
                int zipCode = input.readInt();
                double salary = input.readDouble();

                // Write file
                output.writeInt(age);
                output.writeUTF(name);
                output.writeUTF(address);
                output.writeInt(zipCode);
                output.writeDouble(salary);

                // Print to console
                //System.out.printf("%s %d %s %d %.02f\n", name, age, address, zipCode, salary);
                // Create a Person object
                Person person = new Person(age, name, address, zipCode, salary);
                System.out.println(person.toString());

            }
        } catch (EOFException ex) {
        }
    }
}