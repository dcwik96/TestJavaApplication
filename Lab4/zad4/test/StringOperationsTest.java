import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringOperationsTest {

    String actualNotPalindrome = "dawid";
    String actualIsPalindrome = "tomot";
    String expectedNotPalindrome = "diwad";
    String expectedIsPalindrome = "tomot";

    StringOperations method = new StringOperations();

    @Test
    public void checkIfReverse() {
        String actual = method.reverse(actualNotPalindrome);
//        assertThat(actual, equalToIgnoringCase(expectedNotPalindrome));
        assertThat(actual).containsIgnoringCase(expectedNotPalindrome);
    }

    @Test
    public void checkIfConcat() {
        String actual = method.concat(actualNotPalindrome, actualIsPalindrome);
//        assertThat(actual, equalToIgnoringCase(actualNotPalindrome + actualIsPalindrome));
        assertThat(actual).containsIgnoringCase(actualNotPalindrome + actualIsPalindrome);
    }

    @Test
    public void checkIfConcatProperOrder() {
        String actual = method.concat(actualNotPalindrome, actualIsPalindrome);
//        assertThat(actual, startsWithIgnoringCase(actualNotPalindrome));
//        assertThat(actual, endsWithIgnoringCase(actualIsPalindrome));
        assertThat(actual).startsWith(actualNotPalindrome).endsWith(actualIsPalindrome).hasSize(actualNotPalindrome.length() + actualIsPalindrome.length());
    }

    @Test
    public void checkIfIsPalindrome() {
        boolean actual = method.isPalindrome(actualIsPalindrome);
        System.out.println(actual);
        assertThat(actual).isTrue();
    }

    @Test
    public void chechIfConcatWithSecondArgNull() {
        String actual = method.concat(actualNotPalindrome, null);
        assertThat(actual).containsIgnoringCase(actualNotPalindrome);
    }

    @Test
    public void checkIfConcatWithFirstArgNull() {
        String actual = method.concat(null, null);
        assertThat(actual).isNull();
    }

    @Test
    public void checkIfConcatWithFirstArgZeroLength() {
        String actual = method.concat("", null);
        assertThat(actual).isNull();
    }
}
