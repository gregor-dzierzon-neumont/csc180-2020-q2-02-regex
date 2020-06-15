package dzierzon.gregor.junitexample.tests;

import dzierzon.gregor.junitexample.InvalidPersonNameException;
import dzierzon.gregor.junitexample.Person;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonTester {

	private static Person p;
	
	@BeforeClass
	public static void init() {
		p = new Person();
	}
	
	@Before
	public void beforeEveryTest() {
		
	}
	
	@Test
	public void a_testSetName() {
		p.setName("Jane");
		assertEquals("Frank", p.getName());
	}
	
	@Test(expected=InvalidPersonNameException.class)
	public void b_testSetNameInvalid() {
		p.setName("");
	}
}



