import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        File file = new File("../library-sp18/data/words.txt");
        try {
            Scanner in = new Scanner(file);
            Palindrome palindrome = new Palindrome();
            while (in.hasNext()) {
                String word = in.next();
                if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                    System.out.println(word);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        }
    }

}

