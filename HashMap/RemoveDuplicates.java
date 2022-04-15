package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> output=new ArrayList<>();
        HashMap<Integer,Boolean> seen=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(seen.containsKey(arr[i])){
                continue;
            }
            else{
                output.add(arr[i]);
                seen.put(arr[i],true);
            }
        } 
        return output;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 3, 5, 56, 6, 5, 5, 5, 5, 34, 65, 56, 56 };
        ArrayList<Integer> al = removeDuplicates(arr);
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
    }
}
