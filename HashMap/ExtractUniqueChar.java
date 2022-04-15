package HashMap;
/*
Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.
 */

import java.util.HashMap;

public class ExtractUniqueChar {
    public static String uniqueChar(String str) {
        HashMap<Character, Boolean> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hm.put(str.charAt(i), true);
        }
        String output = "";
        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(str.charAt(i))) {
                output = output + str.charAt(i);
                hm.remove(str.charAt(i));
            }
        }
        return output;
    }
}
