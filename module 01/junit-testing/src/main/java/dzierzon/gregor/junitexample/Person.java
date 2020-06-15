package dzierzon.gregor.junitexample;

public class Person {

	private static final int MAX_AGE = 970;

	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.isEmpty()) {
//			throw new InvalidPersonNameException("name cannot be null or empty");
		}
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 0 || age > MAX_AGE) {
			throw new InvalidPersonAgeException("");
		}
		this.age = age;
	}
	
}
