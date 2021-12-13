package Recursion;


public class LastIndexOfNum {
    public static int lastIndex(int input[], int x) {
        if(input.length==0){
            return -1;
        }
        int smallInput[]=new int[input.length-1];
        for(int i=0;i<smallInput.length;i++){
            smallInput[i]=input[i+1];
        }
        int ans=lastIndex(smallInput, x);
        if(ans!=-1){
            return ans+1;
        }
        else{
            if(input[0]==x){
                return 0;
            }
            else{
                return -1;
            }
        }
	}  
    private static int lastIndex2(int input[],int x,int startIndex){
        if(startIndex==input.length){
            return -1;
        }
        int ans=lastIndex2(input,x,startIndex+1);
        if(ans!=-1){
            return ans;
        }
        if(input[startIndex]==x){
            return startIndex;
        }
        else{
            return -1;
        }
    }
    public static int lastIndex2(int input[],int x){
        return lastIndex2(input,x,0);
    }
}
