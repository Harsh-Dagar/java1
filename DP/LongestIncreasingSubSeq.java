package DP;
/*
Given an array with N elements, you need to find the length of the longest subsequence in the given array such that all elements of the subsequence are sorted in strictly increasing order.
 */

public class LongestIncreasingSubSeq {

    public static int lisDP(int arr[]){
        int n=arr.length;
        int storage[]=new int[n];
        storage[0]=1;
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    if(storage[j]>max){
                        max=storage[j];
                    }
                }
            }
            storage[i]=max+1;
        }
        int ans=-1;
        for(int i=0;i<storage.length;i++){
            if(storage[i]>ans){
                ans=storage[i];
            }
        }
        return ans;
    }
}

