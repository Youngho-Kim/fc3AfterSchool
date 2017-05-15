package may_17_data_structure;

/**
 * Created by DoDo on 2017-05-14.
 */
public class CircularQueue<T> {
    private int front = -1;
    private int rear = -1;
    private T[] data;
    public CircularQueue(int queueSize){
        data = (T[]) new Object[queueSize];
    }
    public boolean isEmpty(){
        return (front == rear);
    }
    public boolean isFull(){
        return ((rear+1)%data.length == front);
    }
    private int upRear(){
       return rear =  ++rear%data.length;
    }
}
