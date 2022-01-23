package LinkedList.LinkedListPracticeProblem;
import LinkedList.*;
/*
Given a singly linked list of integers and 
an integer n, find and return the index for 
the first occurrence of 'n' in the linked list. 
-1 otherwise.

Follow a recursive approach to solve this.
*/

public class ReturnNodeIndexRecursive {
    private static int findNodeRec(Node<Integer>head,int n,int si){
        if(head==null){
            return -1;
        }
        int smallAns=findNodeRec(head.next, n, si+1);
        if(head.data==n){
            return si;
        }
        return smallAns;
    }
    public static int findNodeRec(Node<Integer>head,int n){
        return findNodeRec(head,n,0);
    }
 
}
