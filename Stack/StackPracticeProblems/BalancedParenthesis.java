package Stack.StackPracticeProblems;
import Stack.*;
/*
For a given a string expression containing only round brackets or parentheses, 
check if they are balanced or not. Brackets are said to be balanced if the 
bracket which opens last, closes first.
 */

public class BalancedParenthesis {
    public static boolean isBalanced(String input) throws Exception{
        StackUsingLinkedList<Character> s=new StackUsingLinkedList<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                s.push('(');
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                else{
                    s.pop();
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    } 
}
