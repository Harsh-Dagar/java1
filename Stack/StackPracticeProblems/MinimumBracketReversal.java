package Stack.StackPracticeProblems;

import java.util.Stack;

/*
For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.

If the expression can't be balanced, return -1.
*/

public class MinimumBracketReversal {

    public static int countBracketReversals(String input) {
        if (input.length() % 2 == 1) {
            return -1;
        }
        if (input.length() == 0) {
            return 0;
        }
        Stack<Character> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                s.push('{');
            } else if (!s.isEmpty() && s.peek() == '{') {
                s.pop();
            } else {
                s.push(input.charAt(i));
            }
        }

        while (!s.isEmpty()) {
            int c1 = s.pop();
            int c2 = s.pop();
            if (c1 == c2) {
                ans++;
            } else if (c1 != c2) {
                ans += 2;
            }
        }
        return ans;
    }
}
