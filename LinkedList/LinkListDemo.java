package LinkedList;

public class LinkListDemo {
    public static void main(String[] args) {
        // taking input(size>5)
        Node<Integer>head=LinkedListUse.takeInput();
        LinkedListUse.print(head);
        Node<Integer>n2=LinkedListUse.deleteNode(head, 7);
        LinkedListUse.print(n2);
    }
}
