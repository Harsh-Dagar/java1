package sort;

public class BubbleSort {
    // public static void sort(int arr[]){
    //     for(int i=0;i<arr.length-1;i++){
    //         for(int j=0;j<arr.length-1-i;j++){
    //             if(arr[j]>arr[j+1]){
    //                 int temp=arr[j];
    //                 arr[j]=arr[j+1];
    //                 arr[j+1]=temp;
    //             }
    //         }
    //     }
    // }

    public static void sort(int arr[]){
        // int x=1;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    // x=0;
                }
            }
            // if(x==1){
            //     break;
            // }
        }
    }
    public static void main(String[] args) {
        int arr[]={43,56,78,43,32,509,75,24};
        sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
