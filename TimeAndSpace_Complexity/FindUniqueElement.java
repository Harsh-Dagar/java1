package TimeAndSpace_Complexity;
/*
   You have been given an integer array/list(ARR) of size N. Where N is equal to [2M + 1].
Now, in the given array/list, 'M' numbers are present twice and one number is present only once.
You need to find and return that number which is unique in the array/list.
*/

public class FindUniqueElement {
    /*
        Time Complexity O(n)
        Space Complexity O(1)
        where n is size of array
    */

    /*
        properties of XOR used:
         i)   a^a=0
         ii)  XOR is Associative
    */
    public static int findUnique(int arr[]){
        int xOR=0;
        for(int i=0;i<arr.length;i++){
            xOR^=arr[i];
        }
        return xOR;
    }
}
