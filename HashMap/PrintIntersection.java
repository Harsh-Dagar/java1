package HashMap;

// import java.util.HashMap;
import java.util.HashMap;

public class PrintIntersection {
    public static void printIntersection(int arr1[], int arr2[]) {
        // if(arr1.length==0||arr2.length==0){
        // return;
        // }
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        // int i=0,j=0;
        // while(i<arr1.length&&j<arr2.length){
        // if(arr1[i]==arr2[j]){
        // System.out.println(arr1[i]);
        // i++;j++;
        // }
        // if(arr1[i]>arr2[j]){
        // j++;
        // }
        // else if(arr1[i]<arr2[j]){
        // i++;
        // }
        // }

        HashMap<Integer, Integer> hm1 = new HashMap<>();
        for (int e : arr1) {
            hm1.put(e, hm1.getOrDefault(e, 0) + 1);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (hm1.containsKey(arr2[i])) {
                if (hm1.get(arr2[i]) != 1) {
                    System.out.println(arr2[i]);
                    hm1.put(arr2[i], hm1.get(arr2[i]) - 1);
                } else {
                    System.out.println(arr2[i]);
                    hm1.remove(arr2[i]);

                }
            }
        }

    }

}
