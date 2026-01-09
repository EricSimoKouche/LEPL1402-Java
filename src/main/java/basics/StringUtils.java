package basics;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {


    /**
     * Split a string according to a delimiter
     *
     * @param str The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     *          between two consecutive occurence of the delimiter.
     *          If there is no occurence of the delimiter, it should
     *          return an array of size 1 with the string at element 0
     */
    public static String [] split(String str, char delimiter){

        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c != delimiter) {
                s.append(c);
            } else {
                res.add(s.toString());
                s = new StringBuilder();
            }
        }

        res.add(s.toString());
        return res.toArray(new String[0]);

    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     *          the substring in str or -1 if sub does not appear
     *          in str
     */
    public static int indexOf(String str, String sub){

        if (str.length() < sub.length()) return -1;

        int j = 0; // this is the index that will go through the sub
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == sub.charAt(j)) {
                while ( i + j < str.length() && j < sub.length() ) {
                    if (str.charAt(i+j) != sub.charAt(j)) {
                        j = 0;
                        break;
                    }
                    j++;
                }
                if (j == sub.length()) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     *          character put to lower case.
     */
    public static String toLowerCase(String str){

        StringBuilder lower = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            lower.append(Character.toLowerCase(str.charAt(i)));
        }
        return lower.toString();
    }


    /**
     * Check if a string is a palyndrome
     *
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str){

        int right = str.length() - 1;
        for (int i = 0; i <= right; i++) {
            if (str.charAt(i) != str.charAt(right)) {
                return false;
            }
            right--;
        }
        return true;
    }
}