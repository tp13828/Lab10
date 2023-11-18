public class Person implements Comparable<Person> {
	private int age;
	private String name;
	private String address;
	private int zipCode;
	private double salary;

	public Person(int age, String name, String address, int zipCode, double salary) {
		this.age = age;
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.salary = salary;
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


	public void setName(String name) {
		this.name = name;

	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public int compareTo(Person otherPerson) {
		// Implement comparison logic based on salary in descending order
		return Double.compare(otherPerson.salary, this.salary);
	}
	/*public int compareTo(Person o) {
		if (this.getSalary() < o.getSalary()) {
			return 1;
		} else if (this.getSalary() > o.getSalary()) {
			return -1;
		} else {
			return 0;
		}
	}*/

@Override
		public String toString(){
			return String.format("Age: %d\nFirst and Last Name: %s\nAddress: %s\nZip Code: %d\nSalary: %,.02f\n\n", age,
					name, address, zipCode, salary);

		}


}
