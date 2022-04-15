package HashMap;
/*
You are given an array of unique integers that contain numbers in random order. You have to find the longest possible sequence of consecutive numbers using the numbers from given array.

You need to return the output array which contains starting and ending element. If the length of the longest possible sequence is one, then the output array must contain only single element.
*/

import java.util.ArrayList;
import java.util.HashMap;


public class LongestConsecutiveSequence {
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[]arr){
        HashMap<Integer,Boolean> hm=new HashMap<>();
        HashMap<Integer,Integer> hm1=new HashMap<>();
        int start=-1,maxLen=0;
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],true);
        }
        for(int i=0;i<arr.length;i++){
            hm1.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int len=1;
                int j=1;
                int sE=arr[i];
                while(hm.containsKey(arr[i]+j)){
                    len++;
                    hm.remove(arr[i]+j);
                    j++;
                }
                j=1;
                while(hm.containsKey(arr[i]-j)){
                    len++;
                    sE=arr[i]-j;
                    hm.remove(arr[i]-j);
                    j++;
                }
                hm.remove(arr[i]);
                if(maxLen==len&&hm1.get(sE)<hm1.getOrDefault(start,arr.length)){
                    start=sE;
                }
                if(maxLen<len){
                    maxLen=len;
                    start=sE;
                }
            }
        }
        ArrayList<Integer>output=new ArrayList<>();
        output.add(start);
        if(maxLen!=1)output.add(start-1+maxLen);
        return output; 
    }   
}