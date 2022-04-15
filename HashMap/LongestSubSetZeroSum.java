package HashMap;

import java.util.HashMap;

public class LongestSubSetZeroSum {
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
        }
        int maxLen=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                if(maxLen<i+1){
                    maxLen=i+1;
                }
            }
            else if(hm.containsKey(arr[i])){
                if(maxLen<i-hm.get(arr[i])){
                    maxLen=i-hm.get(arr[i]);
                }
            }
            else {
                hm.put(arr[i], i);
            }
        }
        return maxLen;

    }
}
