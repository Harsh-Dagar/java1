package classes_and_object;

public class DynamicArray {
    private int[]data;
    private int nextIndex;
    DynamicArray(){
        data=new int[5];
        nextIndex=0;
    }
    private void restructure(){
        int[] tempArr=new int[data.length+10];
        for(int i=0;i<data.length;i++){
            tempArr[i]=data[i];
        }
        data=tempArr;
        tempArr=null;
    }
    public void add(int x){
        if(nextIndex==data.length){
            restructure();
        }
        data[nextIndex]=x;
        nextIndex++;
    }
    public int size(){
        return nextIndex;
    }
    public void set(int index,int element){
        if(index>nextIndex){
            return;
        }
        else if(index==nextIndex){
            add(element);
        }
        else{
            data[index]=element;
        }
    }
    public int get(int index){
        return data[index];
    }
    public boolean isEmpty(){
        if(nextIndex==0){
            return true;
        }
        return false;
    }
    public void removeLast(){
        data[nextIndex-1]=0;
        nextIndex--;
    }

}
