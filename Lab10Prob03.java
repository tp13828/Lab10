/**
* File: Lab 10 Prob03.java
* Class: CSCI 1302
* Author: Stella Pham and Thi Tran
* Created on: Nov 17, 2023
* Last Modified: Nov 18, 2023
* Description: File that reads people.dat and processes into Person arrayList, then writes Person instances into
*              new file using Person arrayList
*/

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

        // To test the newly created file
        try (ObjectInputStream inputFile = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("src/people-salary-sorted.dat")))) {

            while (true) {
            	Person readPerson = (Person)inputFile.readObject();
                System.out.printf("%s", readPerson.toString());
            }
        } catch (EOFException ex) {
            System.out.println("Done processing output file");
        } catch (Exception ex2) {
        	System.out.println("Error");
        }
    }
}
