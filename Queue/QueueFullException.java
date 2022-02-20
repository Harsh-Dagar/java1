package Queue;

public class QueueFullException extends Exception {
    @Override
    public String toString(){
        return "Queue is full";
    }
    
}
