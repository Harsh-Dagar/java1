package Queue;

public class QueueUsingArray {
    private int data[];
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray() {
        data = new int[10];
        front = -1;
        rear = -1;
        size = 0;
    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    private void restructure(){
        int temp[]=new int[2*data.length];
        for(int i=front;i<data.length;i++){
            temp[i-front]=data[i];
        }
        for(int i=0;i<=front-1;i++){
            temp[front+i]=data[i];
        }
        data=temp;
        temp=null;
        front=0;
        rear=size-1;

    } 

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];

    }

    public void enqueue(int element) /*throws QueueFullException*/ {
        if (size == data.length) {
            // throw new QueueFullException();
            restructure();
        }

        if (size == 0) {
            front = 0;
        }
        size++;
        /* ---------same as rear=(rear+1)%data.length--------------- */
        // rear++;
        // if(rear==data.length){
        // rear=0;
        // }
        rear = (rear + 1) % data.length;
        data[rear] = element;

    }

    public int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        int temp = data[front];
        /*---------same as  front=(front+1)%data.length------------------------ */
        // front++;
        // if(front==data.length){
        // front=0;
        // }
        front = (front + 1) % data.length;
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }
    public static void main(String[] args) throws Exception {
        // QueueUsingArray q=new QueueUsingArray();
        // q.enqueue(0);
        // q.enqueue(1);
        // for(int i=0;i<10;i++){
        //     int a=q.dequeue();
        //     int b=q.dequeue();
        //     q.enqueue(b);
        //     q.enqueue(a+b);
        //     System.out.print(a+" ");
        // }
        // for(int i=0;i<=10;i++){
        //     q.enqueue(i+1);
        // }
        // for(int i=0;i<=10;i++){
        //     System.out.println("1st"+q.front());
        //     System.out.println(q.dequeue());
        // }
        // System.out.println(q.size());
        
    }

}
