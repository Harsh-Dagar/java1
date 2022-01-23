package LinkedList;

public class MergeSortLL {
    public static Node<Integer> sort(Node<Integer>head){
        if(head==null||head.next==null){
            return head;
        }
        Node<Integer>h=head;
        Node<Integer>t=head;
        Node<Integer>slow=head;
        Node<Integer>fast=head;
        while(true){
            if(fast==null){
                break;
            }
            if(fast.next==null){
                slow=slow.next;
                break;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        while(t.next!=slow){
            t=t.next;
        }
        t.next=null;
        Node<Integer> head1=sort(h);
        Node<Integer>head2=sort(slow);
        Node<Integer>finalAns=MergeTwoSortedLL.merge(head1,head2);
        return finalAns;
    }
    public static void main(String[] args) {
        Node<Integer>head=LinkedListUse.takeInput();
        LinkedListUse.print(sort(head));      
    }
}
