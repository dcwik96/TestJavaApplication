

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import zad3.src.StringOperations;

public class StringOperationsTest {

	String actualNotPalindrome = "dawid";
	String actualIsPalindrome = "tomot";
	String expectedNotPalindrome = "diwad";
	String expectedIsPalindrome = "tomot";
	
	StringOperations method = new StringOperations();
	
	@Test
	public void checkIfReverse() {
		String actual = method.reverse(actualNotPalindrome);
		assertThat(actual, equalToIgnoringCase(expectedNotPalindrome));
	}
	
	@Test
	public void checkIfConcat(){
		String actual = method.concat(actualNotPalindrome, actualIsPalindrome);
		assertThat(actual, equalToIgnoringCase(actualNotPalindrome+actualIsPalindrome));
	}
	
	@Test
	public void checkIfConcatProperOrder(){
		String actual = method.concat(actualNotPalindrome, actualIsPalindrome);
		assertThat(actual, startsWithIgnoringCase(actualNotPalindrome));
		assertThat(actual, endsWithIgnoringCase(actualIsPalindrome));
	}
	
	@Test
	public void checkIfIsPalindrome() {
		boolean actual = method.isPalindrome(actualIsPalindrome);
		System.out.println(actual);
		assertThat(actual, is(true));
	}

	@Test(expected = NullPointerException.class)
	public void checkIfIsPalindromeWithNull(){
		boolean actual = method.isPalindrome("");
		assertThat(actual, is(true));
	}
	
	@Test
	public void chechIfConcatWithSecondArgNull(){
		String actual = method.concat("asd", null);
		assertThat(actual,equalToIgnoringWhiteSpace("asd"));
	}
	
	@Test
	public void checkIfConcatWithFirstArgNull(){
		String actual = method.concat(null, null);
		assertThat(actual, is(nullValue()));
	}
	
	@Test
	public void checkIfConcatWithFirstArgZeroLength(){
		String actual = method.concat("", null);
		assertThat(actual, is(nullValue()));
	}
}
