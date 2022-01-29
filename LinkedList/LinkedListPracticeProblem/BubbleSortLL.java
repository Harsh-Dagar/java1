package LinkedList.LinkedListPracticeProblem;
import LinkedList.*;

public class BubbleSortLL {
    private static int length(Node<Integer>head){
        int count=0;
        Node<Integer>temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    public static Node<Integer> sort(Node<Integer>head){
        if(head==null||head.next==null){
            return head;
        }
        int length=length(head);
        for(int i=0;i<length-1;i++){
            Node<Integer>t1=head;
            Node<Integer>t2=head.next;
            Node<Integer>t3=null;
            for(int j=0;t2!=null;j++){
                if(j==0&&(t1.data>t2.data)){
                    t3=t2;
                    t1.next=t2.next;
                    t2.next=t1;
                    head=t2;
                    // t1=t2;
                    t2=t1.next;
                }
                else if(j==0){
                    t3=t1;
                    t1=t2;
                    t2=t2.next;
                }
                else if(t1.data>t2.data){
                    t3.next=t2;
                    t1.next=t2.next;
                    t2.next=t1;
                    t3=t2;
                    t2=t1.next;
                }
                else{
                    t3=t1;
                    t1=t2;
                    t2=t2.next;
                }
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node<Integer>head=LinkedListUse.takeInput();
        LinkedListUse.print(sort(head));
    }
}
