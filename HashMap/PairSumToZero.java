package HashMap;

import java.util.HashMap;

public class PairSumToZero {
    public static int PairSum(int[] arr, int num){
        if(arr.length==0||arr.length==1){
            return 0;
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int element: arr){
            hm.put(element,hm.getOrDefault(element,0)+1);
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])&&hm.containsKey(-arr[i])){
                count+=hm.get(-arr[i]);
                if(arr[i]==0){
                    count--;
                }
                if(hm.get(arr[i])!=1){
                    hm.put(arr[i],hm.get(arr[i])-1);
                }
                else{
                    hm.remove(arr[i]);
                }
            }
        }
        return count;
    } 
}
