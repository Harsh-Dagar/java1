package LinkedList.LinkedListPracticeProblem;
import LinkedList.*;

public class ReverseK {
    private static int length(Node<Integer>head){
        int size=0;
        Node<Integer>temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        return size;
    }
    private static Node<Integer> rev(Node<Integer>head){
        if(head==null||head.next==null){
            return head;
        }
        Node<Integer>head2=head.next;
        Node<Integer>t1=head;
        Node<Integer>t2=head.next.next;
        t1.next=null;
        while(t2!=null){
            head2.next=t1;
            t1=head2;
            head2=t2;
            t2=t2.next;
        }
        head2.next=t1;
        return head2;
    }
    public static Node<Integer> kReverse(Node<Integer>head,int k){
        if(k==0){
            return head;
        }
        if(head==null||head.next==null){
            return head;
        }
        if(length(head)<=k){
            Node<Integer>newHead=rev(head);
            return newHead;
        }
        Node<Integer>smallNode=head;
        Node<Integer>temp=head;
        for(int i=0;i<k;i++){
            smallNode=smallNode.next;
        }
        for(int i=1;i<k;i++){
            temp=temp.next;
        }
        Node<Integer>smallAns=kReverse(smallNode,k);
        temp.next=null;
        head=rev(head);
        Node<Integer>temp2=head;
        while(temp2.next!=null){
            temp2=temp2.next;
        }
        temp2.next=smallAns;
        return head;
    }
    public static void main(String[] args) {
        Node<Integer>head=LinkedListUse.takeInput();
        LinkedListUse.print(kReverse(head, 3));
        head=rev(head);
        // LinkedListUse.print(head);
        // System.out.println(length(head));
        
    }
}
