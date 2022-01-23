package LinkedList.LinkedListPracticeProblem;
import LinkedList.*;
/*
  For a given singly linked list of integers, arrange the elements 
  such that all the even numbers are placed after the odd numbers. 
  The relative order of the odd and even terms should 
  remain unchanged.
 */

public class EvenAfterOddLL {
    public static Node<Integer> evenAfterOdd(Node<Integer>head){
        if(head==null||head.next==null){
            return head;
        }
        Node<Integer>evenH=null;
        Node<Integer>evenT=null;
        Node<Integer>oddH=null;
        Node<Integer>oddT=null;
        while(head!=null){
            if(head.data%2==0){
                if(evenH==null){
                    evenH=head;
                    evenT=head;
                    head=head.next;
                }
                else{
                    evenT.next=head;
                    evenT=head;
                    head=head.next;
                }
            }
            else{
                if(oddH==null){
                    oddH=head;
                    oddT=head;
                    head=head.next;
                }
                else{
                    oddT.next=head;
                    oddT=head;
                    head=head.next;
                }
            }
        }
          
        if(oddH==null){
            evenT.next=null;
            return evenH;
        }
        if(evenH==null){
            oddT.next=null;
            return oddH;   
        }
        evenT.next=null;
        oddT.next=evenH;
        return oddH;
    }   
}
