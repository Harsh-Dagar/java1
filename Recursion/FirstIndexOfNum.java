package Recursion;


public class FirstIndexOfNum {
    private static int firstIndex(int input[],int index,int x){
        if(index==input.length){
            return -1;
        }
        if(input[index]==x){
            return index;
        }
        int smallAns=firstIndex(input, index+1,x);
        return smallAns;
    }
    public static int firstIndex(int input[], int x) {
        return firstIndex(input, 0, x);
	}



    public static int firstIndex2(int input[],int x){
        if(input.length==0){
            return -1;
        }
        if(input[0]==x){
            return 0;
        }
        int smallInput[]=new int[input.length-1];
        for(int i=0;i<smallInput.length;i++){
            smallInput[i]=input[i+1];
        }
        int smallAns=firstIndex2(smallInput, x);
        if(smallAns==-1){
            return -1;
        }
        else{
            return smallAns+1;
        }
    }
}
