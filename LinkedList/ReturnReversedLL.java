package LinkedList;

class DoubleNode {
    Node<Integer> head;
    Node<Integer> tail; 
}

public class ReturnReversedLL {
    //Time Complexity O(n)
    //Space Complexity O(1)
    public static Node<Integer> reverseLinkedList(Node<Integer>head){
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

     // Time Complexity O(n^2)
     // Space Complexity O()
    public static Node<Integer> reverseLinkedListRecursive(Node<Integer>head){
        if(head==null||head.next==null){
            return head;
        }
        Node<Integer>finalHead=reverseLinkedListRecursive(head.next);
        Node<Integer>temp=finalHead;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        head.next=null;
        return finalHead;
    }

         // Time Complexity O(n)  
         // Space Complexity O()
    private static DoubleNode helperReverseLLBetter(Node<Integer>head){
        if(head==null||head.next==null){
            DoubleNode ans=new DoubleNode();
            ans.head=head;
            ans.tail=head;
            return ans;
        }
        DoubleNode smallAns=helperReverseLLBetter(head.next);
        smallAns.tail.next=head;
        head.next=null;

        DoubleNode ans=new DoubleNode();
        ans.head=smallAns.head;
        ans.tail=head;
        return ans;
    }
    public static Node<Integer> reverseLLBetter(Node<Integer> head){
        DoubleNode ans=helperReverseLLBetter(head);
        return ans.head;
    }

    //Time Complexity--> O(n)
    public static Node<Integer> reverseLLBetter2(Node<Integer> head){
        if(head==null||head.next==null){
            return head;
        }
        Node<Integer> tail=head.next;
        Node<Integer>finalHead=reverseLLBetter2(head.next);
        tail.next=head;
        head.next=null;
        return finalHead;
    }
    public static void main(String[] args) {
        // Node<Integer>head=LinkedListUse.takeInput(); 
        // LinkedListUse.print(reverseLLBetter2(head));
    }
}
