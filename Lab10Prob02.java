import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class Lab10Prob02 {
    public static void main(String[] args) throws IOException {
        ArrayList<Person> people = new ArrayList<>();

        try (DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream("src/people.dat")))) {

            while (true) {
                int age = input.readInt();
                String name = input.readUTF();
                String address = input.readUTF();
                int zipCode = input.readInt();
                double salary = input.readDouble();

                Person person = new Person(age, name, address, zipCode, salary);
                people.add(person);
            }

        } catch (EOFException ex) {
            System.out.println("Done reading file");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Collections.sort(people);

        try (PrintWriter output = new PrintWriter(
                new BufferedWriter(new FileWriter("src/people-salary-sorted.dat")))) {

            for (Person person : people) {
                output.println(person.toString());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Code to read and verify the sorted file
        try (BufferedReader reader = new BufferedReader(new FileReader("src/people-salary-sorted.dat"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}