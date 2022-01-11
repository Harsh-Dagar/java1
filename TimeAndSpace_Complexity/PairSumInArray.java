package TimeAndSpace_Complexity;
import sort.MergeSort;
/*
You have been given an integer array/list(ARR) and a number 'num'. 
Find and return the total number of pairs in the array/list which 
sum to 'num'.
 */

public class PairSumInArray {
    // Time Complexity O(n^2)
    public static int pairSum1(int arr[], int x) {
        int flag=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i==j){
                    break;
                }
                else if((arr[i]+arr[j])==x){
                    flag++;
                }
            }
        }
        return flag;
    }


    /* Time Complexity O(n*log(n))

       if all the elements of the arr are same, 
       then Time Complexity will be O(n^2)
    */

    public static int pairSum(int[]arr,int num){
        MergeSort.sort(arr);
        int si=0,ei=arr.length-1;
        int ans=0;
        while(si<ei){
            if(arr[si]+arr[ei]>num){
                ei--;
            }
            else if(arr[si]+arr[ei]<num){
                si++;
            }
            else{
                if(arr[si]==arr[ei]){
                    int n=ei-si+1;
                    int temp=n*(n-1)/2;
                    ans+=temp;
                    si=ei;
                }
                else{
                int tempIndex1=si;
                int tempIndex2=ei;
                while(arr[tempIndex1]==arr[si]){
                    tempIndex1++;
                }
                while(arr[tempIndex2]==arr[ei]){
                    tempIndex2--;
                }
                ans+=(tempIndex1-si)*(ei-tempIndex2);
                si=tempIndex1;
                ei=tempIndex2;
                }
            }
        }
        return ans;
    }
}
