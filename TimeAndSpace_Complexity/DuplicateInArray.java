package TimeAndSpace_Complexity;
import sort.*;
/*
 You have been given an integer array/list(ARR) of size N which contains 
 numbers from 0 to (N - 2). Each number is present at least once. That 
 is, if N = 5, the array/list constitutes values ranging from 0 to 3, 
 and among these, there is a single integer value that is present twice. 
 You need to find and return that duplicate number present in the array.
*/

public class DuplicateInArray {
    // Time Complexity O(n*Log(n)) , where n is size of array
    public static int findDuplicate1(int[]arr){
        MergeSort.sort(arr);

        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }

    // Time Complexity O(n)
    public static int findDuplicate2(int arr[]){
        int sumOfElementsInArr=0;
        for(int i=0;i<arr.length;i++){
            sumOfElementsInArr+=arr[i];
        }
        int sum=0; // sum of first n-2 whole numbers
        for(int i=0;i<=(arr.length-2);i++){
            sum+=i;
        }
        return sumOfElementsInArr-sum;
    }
}
