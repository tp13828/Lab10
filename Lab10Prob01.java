/**
* File: Lab 10 Prob01.java
* Class: CSCI 1302
* Author: Stella Pham and Thi Tran
* Created on: Nov 17, 2023
* Last Modified: Nov 17, 2023
* Description: File reading people.dat
*/

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
				System.out.printf("Age: %d\nFirst and Last Name: %s\nAddress: %s\nZip Code: %d\nSalary: %.02f\n\n", age,
						name, address, zipCode, salary);

			}
		} catch (EOFException ex) {
			System.out.println("Done processing");
		}
	}
}
