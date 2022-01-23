package LinkedList;

public class PalindromeLL {
    public static boolean isPalindrome(Node<Integer> head) {
        if(head==null||head.next==null){
            return true;
        }
        Node<Integer>temp=head;
        Node<Integer>f=head;
        Node<Integer>s=head;   
        while(true){
            if(f==null){
                break;
            }
            if(f.next==null){
                s=s.next;
                break;
            }
            f=f.next.next;
            s=s.next;
        }
        s=ReturnReversedLL.reverseLinkedList(s);
        while(s!=null){
            if(temp.data!=s.data){
                return false;
            }
            s=s.next;
            temp=temp.next;
        }                                                            
        return true;     
    }  
    public static void main(String[] args) {
        Node<Integer>head=LinkedListUse.takeInput();
        System.out.println(isPalindrome(head));  
    }     
}
