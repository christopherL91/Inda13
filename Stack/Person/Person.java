public class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}	

	public int compareTo(Person other) {
		int ageDiff = this.age - other.getAge();
		if(ageDiff == 0) {
			int nameDiff = this.name.compareTo(other.getName());
			return nameDiff;
		}
		return ageDiff;
	}
}