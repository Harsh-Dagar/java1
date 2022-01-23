package LinkedList;

public class MergeTwoSortedLL {
    public static Node<Integer> merge(Node<Integer>head1,Node<Integer>head2){
        Node<Integer>t1=head1;
        Node<Integer>t2=head2;
        Node<Integer>headFinal;
        Node<Integer>tailFinal;
        if(t1.data<t2.data){
            headFinal=t1;
            tailFinal=t1;
            t1=t1.next;
        }
        else{
            headFinal=t2;
            tailFinal=t2;
            t2=t2.next;
        }
        while(t1!=null&&t2!=null){
            if(t1.data<t2.data){
                tailFinal.next=t1;
                t1=t1.next;
                tailFinal=tailFinal.next;
            }
            else{
                tailFinal.next=t2;
                t2=t2.next;
                tailFinal=tailFinal.next;
            } 
        }
        if(t1!=null){
            tailFinal.next=t1;
        }
        if(t2!=null){
            tailFinal.next=t2;
        }
        return headFinal;
    }
    public static void main(String[] args) {
        Node<Integer> h1=LinkedListUse.takeInput();
        Node<Integer> h2=LinkedListUse.takeInput();
        LinkedListUse.print(merge(h1, h2));
    }
}
