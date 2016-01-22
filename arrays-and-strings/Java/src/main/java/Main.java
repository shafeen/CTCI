import java.util.HashSet;
import java.util.Scanner;

/**
 * CTCI - Arrays and Strings.
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputStr = input.next();

        q1_1(inputStr);
    }

    // [1.1] Implement an algorithm to determine if a string has all unique characters. What
    //       if you cannot use additional data structures?
    public static void q1_1(String str) {
        System.out.printf("\"%s\" has all unique characters = %b\n", str, hasAllUniqueChars(str));
        System.out.printf("\"%s\" has all unique characters = %b\n", str, hasAllUniqueChars_nohashmap(str));
    }

    // [1.1] helper
    public static boolean hasAllUniqueChars(String str) {
        HashSet<Character> uniqueCharSet = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (uniqueCharSet.contains(str.charAt(i))) {
                return false;
            }
            uniqueCharSet.add(str.charAt(i));
        }
        return true;
    }

    // [1.1] w/o addition data structures -
    // for each char in string, compare with every other char for duplicates
    public static boolean hasAllUniqueChars_nohashmap(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (c == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
