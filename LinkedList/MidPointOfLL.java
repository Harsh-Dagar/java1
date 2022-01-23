package LinkedList;

public class MidPointOfLL {
    public static Node<Integer> midPoint(Node<Integer> head){
        if(head==null){
            return head;
        }
        Node<Integer>slow=head;
        Node<Integer>fast=head;
        while(fast.next!=null){
            fast=fast.next.next;
            if(fast==null){
                break;
            }
            slow=slow.next;
        }
        return slow;
    }
}
