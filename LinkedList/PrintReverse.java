package LinkedList;

public class PrintReverse {
    //Time Complexity O(n)
    //Space Complexity O(n)
    public static void printReverse(Node<Integer>head){
        if(head==null){
            return;
        }
        printReverse(head.next);
        System.out.print(head.data+" ");
    }
}
