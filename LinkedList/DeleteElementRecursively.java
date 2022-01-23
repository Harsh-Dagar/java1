package LinkedList;

public class DeleteElementRecursively {
    public static Node<Integer> delete(Node<Integer>head,int pos){
        if(head==null){
            return head;
        }
        if(pos==0){
            Node<Integer>ans=head.next;
            head=null;
            return ans;
        }
        Node<Integer>smallAns=delete(head.next, pos-1);
        head.next=smallAns;
        return head;
    }
    public static void main(String[] args) {
        Node<Integer>head=LinkedListUse.takeInput();
        LinkedListUse.print(head);
        LinkedListUse.print(delete(head, 5));
    }
}
