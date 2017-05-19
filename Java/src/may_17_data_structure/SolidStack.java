package may_17_data_structure;

import java.lang.reflect.Array;

/**
 * Created by DoDo on 2017-05-14.
 */
public class SolidStack<T> {
    private int top;
    private T[] mData;

    private SolidStack(int stackSize){
        mData = (T[]) new Object[stackSize];
        top = -1;
    }
    public void push(T data){
        if(mData.length-1 < ++top) {
            top--;
            throw new ArrayIndexOutOfBoundsException("Out of stack boundary");
        }
        /*
        * if(mData.length-1<top+1){
        *   throw new ArrayIndex~
        * }
        * top++;
        *
        * */
        mData[top] = data;
    }
    public T pop(){
        if(top == -1)
            throw new NullPointerException("No element");
        return mData[top--];
//        return mData[top];
//        top = top -1;
    }
    public T peak(){
        if(top == -1)
            throw new NullPointerException("No element");
        return mData[top];
    }
}
