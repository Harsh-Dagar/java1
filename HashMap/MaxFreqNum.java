package HashMap;

import java.util.HashMap;

public class MaxFreqNum {
    public static int maxFrequencyNumber(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // if(map.get(arr[i])==null){
            // map.put(arr[i],1);
            // }
            // else{
            // map.put(arr[i], 1+map.get(arr[i]));

            // }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int e : arr) {
            if (max < map.get(e)) {
                max = map.get(e);
                ans = e;
            }
        }
        return ans;
    }
}
