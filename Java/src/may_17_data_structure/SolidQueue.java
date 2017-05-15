package may_17_data_structure;

/**
 * Created by DoDo on 2017-05-14.
 */
public class SolidQueue<T> {
    private int front;
    private int rear;
    private T[] mData;
    public SolidQueue(int queueSize){
        mData = (T[]) new Object[queueSize];
        front = -1;
        rear = -1;
    }
    public void enQueue(T data){
        //0. 큐의 길이를 초과했는지 확인한다.
        //1. rear +1
        if(mData.length-1 < ++rear) {
            rear--;
            throw new ArrayIndexOutOfBoundsException("Out boundary");
        }
        //2. rear위치에 새 값을 넣는다.
        mData[rear] = data;
    }
    public T deQueue(){
        //0. 큐에 원소가 있는지 확인한다.
        if(front == rear)
            throw new NullPointerException("No Data");
        //1. front+1
        T temp = mData[++front];
        //2. front위치의 값을 뺀다.
        mData[front] = null;
        return temp;
    }
}
