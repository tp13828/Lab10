import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class Lab10Prob03 {
    public static void main(String[] args) throws IOException {
        ArrayList<Person> peopleList = new ArrayList<>();


        try (DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream("src/people.dat")))) {

            while (true) {
                // Variables
                int age = input.readInt();
                String name = input.readUTF();
                String address = input.readUTF();
                int zipCode = input.readInt();
                double salary = input.readDouble();

                // Create a Person instance
                Person person = new Person(age, name, address, zipCode, salary);

                // Add the person to the ArrayList
                peopleList.add(person);
            }

        } catch (EOFException ex) {
            System.out.println("Done processing input file");
        }

        // Sort the ArrayList by salary
        Collections.sort(peopleList);

        
        //Write object instances in Person array list to new file
        try ( ObjectOutputStream objectOutput = new ObjectOutputStream(new BufferedOutputStream
        		(new FileOutputStream("src/people-salary-sorted.dat")));
        		) {
        			for (Person person : peopleList) {
        				objectOutput.writeObject(person);
        			}
        		}
        // Open the output stream outside the try-with-resources block
        /*try {
            output = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream("src/people-salary-sorted.dat")));

            // Write the sorted data to the output file
            for (Person person : peopleList) {
                output.writeInt(person.getAge());
                output.writeUTF(person.getName());
                output.writeUTF(person.getAddress());
                output.writeInt(person.getZipCode());
                output.writeDouble(person.getSalary());
            }

            System.out.println("Sorting and writing to file completed.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the output stream in the finally block to ensure it gets closed
            if (output != null) {
                output.close();
            }
        }*/

        // To test the newly created file
        try (ObjectInputStream inputFile = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("src/people-salary-sorted.dat")))) {

            while (true) {
            	Person readPerson = (Person)inputFile.readObject();
            	/*
                int age = inputFile.readInt();
                String name = inputFile.readUTF();
                String address = inputFile.readUTF();
                int zipCode = inputFile.readInt();
                double salary = inputFile.readDouble();
                */

                System.out.printf("Age: %d\nFirst and Last Name: %s\nAddress: %s\nZip Code: %d\nSalary: %.02f\n\n",
                        readPerson.getAge(), readPerson.getName(), readPerson.getAddress(), readPerson.getZipCode(), readPerson.getSalary());
            }
        } catch (EOFException ex) {
            System.out.println("Done processing output file");
        } catch (Exception ex2) {
        	System.out.println("Error");
        }
    }
}
