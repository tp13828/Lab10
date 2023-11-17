/**
 * File: Person.java Class: CSCI 1302 Author: Stella Pham and Thi Tran Created
 * on: Nov 17, 2023 Last Modified: Nov 17, 2023 Description: Person class
 */

public class Person implements Comparable<Person> {
	private int age;
	private String name;
	private String address;
	private int zipCode;
	private double salary;

	public Person() {
	}

	// Accessors
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public double getSalary() {
		return salary;
	}
	
	

	@Override
	public int compareTo(Person o) {
	if (this.getSalary() < o.getSalary()) {
		return 1;
	} else if (this.getSalary() > o.getSalary()) {
		return -1;
	} else {
		return 0;
	}
	
	}
	
	

}
