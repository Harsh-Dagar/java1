package Queue.QueuePracticeQuestions;
import java.util.Queue;


public class ReverseQueue {
    
    public static void reverseQueue(Queue<Integer> input){
        if(input.size()<=1){
            return;
        }
        int t=input.poll();
        reverseQueue(input);
        input.add(t);
    }
}
