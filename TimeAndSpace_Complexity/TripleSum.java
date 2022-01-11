package TimeAndSpace_Complexity;
import java.util.Arrays;

public class TripleSum {
    //Time Complexity O(n^3)
    public static int tripleSum(int arr[],int num){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(i!=j){
                        if(arr[i]+arr[j]+arr[k]==num){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
    // Time Complexity O(n^2*log(n))

    public static int tripleSum2(int arr[],int num){
        Arrays.sort(arr);
        int ans=0;
        for(int i=0;i<arr.length;i++){
            int pairSum=pairSum(arr,i+1,arr.length-1,num-arr[i]);
            ans+=pairSum;
        }
        return ans;
    }
    private static int pairSum(int[]arr,int startIndex,int endIndex,int x){
        int ans=0;
        while(startIndex<endIndex){
            if(arr[startIndex]+arr[endIndex]<x){
                startIndex++;
            }
            else if(arr[startIndex]+arr[endIndex]>x){
                endIndex--;
            }
            else{
                if(arr[startIndex]==arr[endIndex]){
                    int n=endIndex-startIndex+1;
                    ans+=(n)*(n-1)/2;
                    startIndex=endIndex;
                }
                else{
                    int tempIndex1=startIndex;
                    int tempIndex2=endIndex;
                    while(arr[tempIndex1]==arr[startIndex]){
                        tempIndex1++;
                    }
                    while(arr[tempIndex2]==arr[endIndex]){
                        tempIndex2--;
                    }
                    ans+=(tempIndex1-startIndex)*(endIndex-tempIndex2);
                    startIndex=tempIndex1;
                    endIndex=tempIndex2;
                }

            }
        }
        return ans;
    }
}
