package RecursionPracticeProblem;

public class BinarySearchRecursive {
    private static int binarySearch(int input[],int x,int si,int ei){
        if(si>ei){
            return -1;
        }
        int ans;
        int mid=(si+ei)/2;
        if(input[mid]==x){
            return mid;
        }
        else if(input[mid]>x){
            ans=binarySearch(input, x, si, mid-1);
        }
        else{
            ans=binarySearch(input, x, mid+1, ei);
        }
        return ans;    
    }
    public static int binarySearch(int[]input,int x){
        int ans=binarySearch(input, x, 0, input.length-1);
        return ans;
    }
}
