package Stack.StackPracticeProblems;
import java.util.Stack;
/*
Afzal has been working with an organization called 
'Money Traders' for the past few years. The organization 
is into the money trading business. His manager assigned 
him a task. For a given array/list of stock's prices for 
N days, find the stock's span for each day.

The span of the stock's price today is defined as the 
maximum number of consecutive days(starting from today 
and going backwards) for which the price of the stock 
was less than today's price.

For example, if the price of a stock over a period of 
7 days are [100, 80, 60, 70, 60, 75, 85], then the 
stock spans will be [1, 1, 1, 2, 1, 4, 6].
*/
public class StockSpan {
    
    public static int[] stockSpan(int[]price){
        Stack<Integer>s=new Stack<>();
        int ans[]=new int[price.length];
        s.push(0);
        ans[0]=1;
        for(int i=1;i<price.length;i++){
            while(price[s.peek()]<price[i]){
                s.pop();
                if(s.isEmpty()){
                    break;
                }
            }
            if(s.isEmpty()){
                ans[i]=i+1;
            }
            else{
                ans[i]=i-s.peek();
                
            }
            s.push(i);
        }
        return ans;
    }
    // public static void main(String[] args) {
    //     int arr[]=stockSpan(new int[]{71,762,53,5455,54});
    //     for(int i=0;i<arr.length;i++){
    //         System.out.println(arr[i]);
            
    //     }
    // }
}
