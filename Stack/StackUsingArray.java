package Stack;

public class StackUsingArray{
    private int data[];
    private int top;
    public StackUsingArray(){
        this.data=new int[10];
        this.top=-1;
    }
    public StackUsingArray(int capacity){
        this.data=new int[capacity];
        this.top=-1;
    }
    public boolean isEmpty(){
        // if(this.top==-1){
        //     return true;
        // }
        // else{
        //     return false;
        // }  

        return (top==-1);    
    }
    public int size(){
        return top+1;
    }
    private void restructure(){
        int temp[]=new int[data.length];
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
        temp=null;
    }
    public int top() throws StackEmptyException{
        if(size()==0){
            throw new StackEmptyException();
        }
        return data[top];
    }
    public void push(int element){
        if(size()==data.length){
            restructure();
        }
        top++;
        data[top]=element;
    }
    public int pop() throws StackEmptyException{
        if(size()==0){
            throw new StackEmptyException();
        }
        int var=data[top];
        top--;
        return var;
    }
    public static void main(String[]args){
        // StackUsingArray s=new StackUsingArray();
        // for(int i=0;i<10;i++){
        //     s.push(i+1);
        // }
        // for(int i=0;i<10;i++){
        //     try{
        //         System.out.println(s.pop());
        //         System.out.println("Size of stack is: "+s.size());
                
        //     }
        //     catch(StackEmptyException e){
        //         System.out.println(e);
        //     }
        // }
    }
}
