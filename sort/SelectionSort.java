package sort;

public class SelectionSort {
    public static void sort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int minValue=arr[i];
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(minValue>arr[j]){
                    minValue=arr[j];
                    minIndex=j;
                }
            }
            arr[minIndex]=arr[i];
            arr[i]=minValue;
        }
    }
}
