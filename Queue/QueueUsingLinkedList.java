package Queue;
import LinkedList.*;

public class QueueUsingLinkedList <T> {
    private Node<T>front;
    private Node<T>rear;
    private int size;
    public QueueUsingLinkedList(){
        front=null;
        rear=null;
        size=0;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        if(this.size==0){
            return true;
        }
        return false;
    }
    public T front() throws QueueEmptyException{
        if(this.isEmpty()){
            throw new QueueEmptyException();
        }
        return this.front.data;
    }
    public void enqueue(T element){
        Node<T>newRear=new Node<>(element);
        if(this.size==0){
            this.front=newRear;
            this.rear=newRear;
        }
        this.size++;
        this.rear.next=newRear;
        this.rear=newRear;
    }
    public T dequeue() throws QueueEmptyException{
        if(this.isEmpty()){
            throw new QueueEmptyException();
        }
        this.size--;
        T temp=this.front.data;
        this.front=this.front.next;
        return temp;
    }  
}
