package Stack.StackPracticeProblems;
import java.util.Stack;
/*
For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.

A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.
*/

public class CheckRedundantBrackets {
    private static boolean findChar(char c){
        if(c=='+'||c=='-'||c=='/'||c=='*'){
            return true;
        }
        return false;
    } 
    public static boolean checkRedundantBrackets(String expression){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='('||findChar(expression.charAt(i))){
                s.push(expression.charAt(i));

            }
            else if(expression.charAt(i)==')'){
                boolean flag=false;
                while(!s.isEmpty()&&s.peek()!='('){
                    s.pop();
                    flag=true;
                }
                if(!flag){
                    return true;
                }
                if(!s.isEmpty()){
                    s.pop();
                }

            }
        }
        return false;
    }
    // public static void main(String[] args) {
    //     System.out.println(checkRedundantBrackets("(a+b*(a+b))"));
    // }
}
