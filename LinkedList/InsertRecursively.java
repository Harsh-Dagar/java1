package LinkedList;

public class InsertRecursively {

    public static Node<Integer> insert(Node<Integer>head,int pos,int element){
        if(pos==0){
            Node<Integer> newNode=new Node<>(element);
            newNode.next=head;
            return newNode;
        }
        Node<Integer>temp=head;
        Node<Integer>smallAns=insert(temp.next, pos-1, element);
        head.next=smallAns;
        return head;
    } 
    public static void main(String[] args) {
        //give LL of size greater then 5 
        Node<Integer>head=LinkedListUse.takeInput();
        LinkedListUse.print(head);
        Node<Integer>ll1=insert(head, 5, 69);
        LinkedListUse.print(ll1);
    }
}
