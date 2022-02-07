package Stack;
import LinkedList.*;

public class StackUsingLinkedList<T> {
    private Node<T> top;
    private int size;

    public StackUsingLinkedList(){
        // head=null;    // by default non premitive data types are initialized by null
        // size=0;       // by default premitive data types are initialized by 0
    }
    public int size(){
        return size;
    }
    public T top() throws StackEmptyException{
        if(size()==0){
            throw new StackEmptyException();
        }
        return top.data;
    }
    public boolean isEmpty(){
        if(size()==0){
            return true;
        }
        else{
            return false;
        }
    }
    public void push(T element){
        Node<T> newTop=new Node<>(element);
        size++;
        newTop.next=top;
        top=newTop;
    }
    public T pop() throws StackEmptyException{
        if(size()==0){
            throw new StackEmptyException();
        }
        T data=top.data;
        top=top.next;
        size--;
        return data;
    }
    public static void main(String[] args) {
        // StackUsingLinkedList<Integer> s=new StackUsingLinkedList<>();
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
