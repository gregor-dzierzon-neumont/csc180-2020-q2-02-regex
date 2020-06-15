package edu.neumont.csc180.cox.regexutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex implements RegexUtility {
	// DONE!
	public boolean isValidHumanName(String name) {
		String regex = "([A-Z][a-z]+)[\\s|.]([A-Z][a-z]*)[ ]?([A-Z][a-z]*)?";
		return name.matches(regex);
	}

	public boolean isValidEmailAddress(String email) {
		String regex = "([A-z][A-z0-9_.]*)@([A-z][A-z0-9]*).([A-z]{3,4})";
		return email.matches(regex);
	}

	public boolean isValidPhoneNumber(String phone) {
		String regex = "(\\d{1}-|\\d{2}-)?(\\d{3})(-\\d{3})(-\\d{4}|\\d{3})";
		return phone.matches(regex);
	}

	public boolean isValidSSN(String ssn) {
		String regex = "([0-8][0-9][0-9])-([0-9]{3})-([0-9]{4})";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(ssn);
		if (m.matches()) {// If it even looks like a SSN
			// Check for 666 and 0's in all
			if (m.group(1).equals("000") || m.group(1).equals("666") || m.group(2).equals("000")
					|| m.group(3).equals("0000")) {
				return false;
			}
			return true;
		}
		return false;
	}

	public boolean isValidUSStreetAddress(String street) {
		String regex = "(\\d*) (north|south|west|east) ([A-z0-9]*) (north|south|west|east) (Apt#[\\d]+|Suite#[\\d]+|#[\\d]+)\\n([A-z ]*), ([A-Z]{2})[ |\\n]?(\\d{5})-?(\\d{4})?";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = pattern.matcher(street);
		return m.matches();
	}

	public boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower,
			int minNumeric, int minSymbols) {
		// Make multiple checks to see if it adhears to the password specifications
		if (countContains("[a-z]", password) >= minLower && countContains("[A-Z]", password) >= minUpper
				&& countContains("\\d", password) >= minNumeric && countContains("\\W", password) >= minSymbols
				&& password.length() >= minLength) {
			return true;
		}
		return false;
	}

	public int countContains(String needle, String haystack) {
		String regex = needle;// Looks for a exact match either way
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(haystack);
		int count = 0;
		while (m.find()) {
			count++;
		}
		return count;
	}

	public String getHTMLTagContents(String html, String tagName) {
		String result = null;
		String regex = "<" + tagName + ">(.*)<\\/" + tagName + ">";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(html);
		if(m.matches()) {
			result = m.group(1).toString();
		}
		return result;
	}

	public String[] getHTMLTagsContents(String html, String tagName) {
		String regex = "<" + tagName + ">(.*)<\\/" + tagName + ">";
		int count = countContains(regex, html);
		String[] result = new String[count];
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(html);
		for(int i = 0; i < count; i++) {
			result[i] = m.group(1).toString();
		}
		return result;
	}

	public String[] getHTMLLinkURL(String html) {
		String regex = "<a href=(.*)>";
		int count = countContains(regex, html);
		String[] result = new String[count];
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(html);
		for(int i = 0; i < count; i++) {
			result[i] = m.group(1).toString();
		}
		return result;
	}

}
