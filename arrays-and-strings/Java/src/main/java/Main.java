import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * CTCI - Arrays and Strings.
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //String inputStr1 = input.next();
        //String inputStr2 = input.next();

        // q1_1(inputStr);
        // q1_3(inputStr1, inputStr2);
        // q1_5(inputStr1);
        q1_6();
    }

    // -------------------------------------------

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

    // -------------------------------------------

    // [1.3] Given two strings, write a method to decide
    // if one is a permutation of the other.
    public static void q1_3(String s1, String s2) {
        System.out.printf("%s is a permutation of %s = %b", s1, s2, arePermutations(s1, s2));
    }

    // [1.3] helper
    public static boolean arePermutations(String s1, String s2) {
        // trivial case
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();

        // hash character counts for first string
        char[] s1Chars = s1.toLowerCase().toCharArray();
        for (char c : s1Chars) {
            int charCount = charCounts.containsKey(c)? charCounts.get(c) + 1 : 1;
            charCounts.put(c, charCount);
        }

        // try to match string char-for-char counts
        char[] s2Chars = s2.toLowerCase().toCharArray();
        for (char c : s2Chars) {
            if (!charCounts.containsKey(c)) {
                return false;
            } else if (charCounts.get(c) > 1) {
                charCounts.put(c, charCounts.get(c) - 1);
            } else {
                charCounts.remove(c);
            }
        }
        return true;
    }

    // -------------------------------------------

    // [1.5] Implement a method to perform basic string compression using the counts
    // of repeated characters. For example, the string aabcccccaaa would become
    // a2blc5a3. If the "compressed" string would not become smaller than the original
    // string, your method should return the original string.
    public static void q1_5(String str) {
        System.out.printf("\"%s\" compressed = \"%s\"", str, simpleCompress(str));
    }

    // [1.5] helper
    public static String simpleCompress(String str) {
        String newString = ""; // TODO: better to replace with a mutable string

        char[] strChars = str.toCharArray();
        char current = strChars[0];
        int currentCharCount = 0;
        for (int i = 0; i < strChars.length; ) {
            while (i < strChars.length && strChars[i] == current) {
                currentCharCount++;
                i++;
            }
            newString += current + Integer.toString(currentCharCount);
            if (i < strChars.length) {
                current = strChars[i];
                currentCharCount = 0;
            }
        }
        return (newString.length() < str.length()) ? newString : str;
    }

    // -------------------------------------------

    // [1.6] Given an image represented by an NxN matrix, where each pixel in the image is
    // 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
    // place?
    public static void q1_6() {
        // convert to 2d char array
        char[][] image = {
            {'s','s','s','s','s','s','s','s'},
            {'s','s','s','s','s','s','s','s'},
            {'s','s','.','.','.','.','.','.'},
            {'s','s','s','s','s','s','s','s'},
            {'s','s','s','s','s','s','s','s'},
            {'.','.','.','.','.','.','s','s'},
            {'s','s','s','s','s','s','s','s'},
            {'s','s','s','s','s','s','s','s'}
        };

        System.out.println("Before rotation:");
        System.out.println("----------------");
        print2dCharArrayImage(image);
        System.out.println("----------------");
        System.out.println("");

        // transpose (reflect y = x)
        for(int y = 0; y < image.length; y++) {
            for(int x = y + 1; x < image[y].length; x++) {
                char cur = image[y][x];
                image[y][x] = image[x][y];
                image[x][y] = cur;
            }
        }
        // reflect rows (or columns to rotate 90 degrees)
        for(int y = 0; y <= image.length/2; y++) {
            for(int x = 0; x < image[y].length; x++) {
                char cur = image[image.length-1-y][x];
                image[image.length-1-y][x] = image[y][x];
                image[y][x] = cur;
            }
        }

        System.out.println("After rotation (left):");
        System.out.println("----------------");
        print2dCharArrayImage(image);
        System.out.println("----------------");
        System.out.println("");
    }

    // [1.6] helper
    public static void print2dCharArrayImage(char[][] image) {
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[y].length; x++) {
                System.out.print(image[y][x]);
            }
            System.out.println();
        }
    }


}
