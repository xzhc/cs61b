import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {

        // 测试回文字符串
        Assert.assertTrue(palindrome.isPalindrome("racecar"));
        Assert.assertTrue(palindrome.isPalindrome("madam"));
        Assert.assertTrue(palindrome.isPalindrome("kayak"));

        //测试非回文字符串
        Assert.assertFalse(palindrome.isPalindrome("race"));
        Assert.assertFalse(palindrome.isPalindrome("mad"));
        Assert.assertFalse(palindrome.isPalindrome("kay"));

        //测试空字符串
        Assert.assertTrue(palindrome.isPalindrome(""));

        //测试长度为1的字符串
        Assert.assertTrue(palindrome.isPalindrome("a"));
    }
}
