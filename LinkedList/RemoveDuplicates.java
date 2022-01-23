package LinkedList;

public class RemoveDuplicates {
    public static Node<Integer> removeDuplicates(Node<Integer>head){
        // Node<Integer>temp=head;
        // if(temp.next==null){
        //     return head;
        // }
        // Node<Integer>smallAns=removeDuplicates(head.next);
        // if(temp.data==temp.next.data){
        //     return smallAns;
        // }
        // else{
        //     temp.next=smallAns;
        // }
        // return temp;
        if(head==null){
            return head;
        }
        Node<Integer>t1=head;
        while(t1.next!=null){
            if(t1.data.equals(t1.next.data)){
                t1.next=t1.next.next;
            }
            else{
                t1=t1.next;
            }
        }
        return head;
    }
}
