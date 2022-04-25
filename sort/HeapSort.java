package sort;

public class HeapSort {
    public void inplaceHeapSort(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            int childIndex = i;
            int parentIndex = (i - 1) / 2;
            while (childIndex > 0) {
                if (arr[childIndex] < arr[parentIndex]) {
                    int temp = arr[childIndex];
                    arr[childIndex] = arr[parentIndex];
                    arr[parentIndex] = temp;
                    childIndex = parentIndex;
                    parentIndex = (childIndex - 1) / 2;
                } else {
                    break;
                }
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            int parentIndex = 0;
            int lChildIndex = 1;
            int rChildIndex = 2;
            while (lChildIndex < i) {
                int minIndex = parentIndex;
                if (arr[lChildIndex] < arr[parentIndex]) {
                    minIndex = lChildIndex;
                }
                if (rChildIndex < i && arr[rChildIndex] < arr[minIndex]) {
                    minIndex = rChildIndex;
                }
                if (minIndex == parentIndex) {
                    break;
                }
                temp = arr[minIndex];
                arr[minIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                parentIndex = minIndex;
                lChildIndex = 2 * parentIndex + 1;
                rChildIndex = 2 * parentIndex + 2;
            }

        }
    }
}
