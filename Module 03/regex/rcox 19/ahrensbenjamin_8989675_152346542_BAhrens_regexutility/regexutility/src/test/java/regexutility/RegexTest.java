package regexutility;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.neumont.csc180.cox.regexutil.Regex;

public class RegexTest {
	public static Regex regex;
	@BeforeClass
	public static void init() {
		regex = new Regex();
	}
	@Test
	public void regexName() {
		String testName = "Nami E Solo";
		String testName2 = "Mr.Solo";
		String testName3 = "Miss Solo";
		if(!regex.isValidHumanName(testName)) {
			Assert.fail("Name 1");
		}else if(!regex.isValidHumanName(testName2)) {
			Assert.fail("Name 2");
		}else if(!regex.isValidHumanName(testName3)) {
			Assert.fail("Name 3");
		}
	}
	@Test
	public void regexPhoneNumber() {
		String testPhone = "1-815-456-5438";
		String testPhone2 = "815-456-5438";
		String testPhone3 = "15-815-456-5438";
		if(!regex.isValidPhoneNumber(testPhone)) {
			Assert.fail("Phone 1");
		}else if(!regex.isValidPhoneNumber(testPhone2)) {
			Assert.fail("Phone 2");
		}else if(!regex.isValidPhoneNumber(testPhone3)) {
			Assert.fail("Phone 3");
		}
	}
	@Test
	public void regexStreetAddress() {
		String address = "644 West Winding Creek North Apt#335\r\n" + 
				"McHenry, IL\r\n" + 
				"55655";
		if(!regex.isValidUSStreetAddress(address)) {
			Assert.fail("Address 1");
		}
	}
	@Test
	public void regexSSN() {
		String testSSN = "102-339-9920";
		String testSSN2 = "102-000-9920"; //Should fail
		String testSSN3 = "901-339-9920"; //Should fail
		String testSSN4 = "666-339-9920"; //Should fail
		if(!regex.isValidSSN(testSSN)) {
			Assert.fail("SSN 1");
		}else if(regex.isValidSSN(testSSN2)) {
			Assert.fail("SSN 2");
		}else if(regex.isValidSSN(testSSN3)) {
			Assert.fail("SSN 3");
		}else if(regex.isValidSSN(testSSN4)) {
		Assert.fail("SSN 4");
		}
	}
	
	@Test
	public void regexEmailAddress() {
		String testAddress = "Bpa99@comcast.net";
		String testAddress2 = "124@keppo.net";
		String testAddress3 = "Apple@2.net";
		if(!regex.isValidPhoneNumber(testAddress)) {
			Assert.fail("Address 1");
		}else if(regex.isValidPhoneNumber(testAddress2)) {
			Assert.fail("Address 2");
		}else if(!regex.isValidPhoneNumber(testAddress3)) {
			Assert.fail("Address 3");
		}
	}
	@Test
	public void regexPassword() {
		String password = "Ka1#1234";
		String password2 = "Ka1#"; //Too short
		if(!regex.validatePasswordComplexity(password, 8, 1, 1, 1, 1)) {
			Assert.fail("password 1");
		}else if(regex.validatePasswordComplexity(password2, 8, 1, 1, 1, 1)) {
			Assert.fail("password 2");
		}
	}
	@Test
	public void regexContains() {
		String contains = "There's about two times that two gets typed in this string";
		if(!(regex.countContains("two", contains) == 2)) {
			Assert.fail("contains 1");
		}
	}
	@Test
	public void regexHTMLTag() {
		String HTML = "<help>anything can be in here</help>";
		String tagContents = regex.getHTMLTagContents(HTML, "help");
		if(!tagContents.equals("anything can be in here")) {
			Assert.fail("tag 1");
		}
	}
	@Test
	public void regexHTMLTags() {
		String HTML = "<help>anything can be in here</help> <help>or in here</help>";
		String[] tagContents = regex.getHTMLTagsContents(HTML, "help");
		if(!tagContents[0].equals("anything can be in here")) {
			Assert.fail("tag 1");
		}else if(!tagContents[1].equals("or in here")) {
			Assert.fail("tag 2");
		}
	}
	@Test
	public void regexHTMLLink() {
		String HTML = "<a href=\"https://regex101.com/\"> <a href=\"https://www.w3schools.com/html/html_links.asp>\"";
		String[] tagContents = regex.getHTMLLinkURL(HTML);
		if(!tagContents[0].equals("https://regex101.com/")) {
			Assert.fail("link 1");
		}else if(!tagContents[1].equals("https://www.w3schools.com/html/html_links.asp")) {
			Assert.fail("link 2");
		}
	}
	//TODO Link URL
}
