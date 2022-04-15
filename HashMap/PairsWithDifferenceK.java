package HashMap;

import java.util.HashMap;

public class PairsWithDifferenceK {
    public static int getPairWithDifferenceK(int arr[], int k) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                if (hm.containsKey(arr[i] + k)) {
                    count += hm.get(arr[i] + k);
                    if (k == 0) {
                        count--;
                    }
                }
                if (hm.containsKey(arr[i] - k) && k != 0) {
                    count += hm.get(arr[i] - k);
                }
                if (hm.get(arr[i]) != 1) {
                    hm.put(arr[i], hm.get(arr[i]) - 1);
                } else {
                    hm.remove(arr[i]);
                }

            }
        }
        return count;
    }
}
