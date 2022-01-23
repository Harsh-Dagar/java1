package LinkedList.LinkedListPracticeProblem;
import LinkedList.*;
/*
You have been given a singly linked list of integers along with two integers, 
'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, 
then delete the next 'N' nodes. Continue the same until the end of the 
linked list.

To put it in other words, in the given linked list, you need to delete N 
nodes after every M nodes.
 */

public class DeleteEveryNNodes {
    public static Node<Integer> skipMdeleteN(Node<Integer>head,int m,int n){
        if(head==null||m==0){
            return null;
        }
        if(n==0){
            return head;
        }
        Node<Integer>temp1=null;
        Node<Integer>temp2=head;
        int t1=1; //  for m
        int t2=1; // for n
        while(temp2!=null){
            while(t1<=m&&temp2!=null){
                if(temp1==null){
                    temp1=temp2;
                }
                else{ 
                    temp1.next=temp2;
                    temp1=temp2;
                }
                temp2=temp2.next;
                t1++;     
            }
            while(t2<=n&&temp2!=null){
                temp2=temp2.next;
                t2++;
            }
            t1=1;
            t2=1;
        }
        if(temp1!=null){
            temp1.next=null;
        }
        return head;
    }
    public static void main(String[]args){
        Node<Integer>head=LinkedListUse.takeInput();
        LinkedListUse.print(skipMdeleteN(head, 2, 3));
    }
    
}
