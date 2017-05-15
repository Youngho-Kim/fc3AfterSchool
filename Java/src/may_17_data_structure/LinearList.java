package may_17_data_structure;

/**
 * Created by DoDo on 2017-05-14.
 */
public class LinearList<T>{

    private T[] mData;

    public LinearList(T... datas){
        mData = datas;
    }

    public int size(){
        return mData.length;
    }

    public void add(int index, T data){
        //1. 공간 확보
        T[] temp = (T[]) new Object[mData.length +1];
        //2.1 위치 이전 원소들 배치
        for(int i = 0; i <index ; i++){
            temp[i] = mData[i];
        }
        //2.2 위치 이후 원소들 배치 (위치 +1)
        for(int i = index; i< mData.length; i++){
        temp[i+1] = mData[i];
        }
        //3. 삽입
        temp[index] = data;
        mData = temp;
        }

    public T remove(int index){
        T returnValue = mData[index];
        //1. 삭제
        T[] temp = (T[]) new Object[mData.length -1];
        //2.1 위치 이전 원소들 배치
        for(int i = 0; i <index ; i++){
            temp[i] = mData[i];
        }
        //2.2 위치 이후 원소들 배치 (위치 -1)
        for(int i = index + 1; i <mData.length ; i++){
            temp[i-1] = mData[i];
        }
        //3. 공간 제거
        mData = temp;
        return returnValue;
    }
    public T get(int index){
        T result = mData[index];
        return result;
    }

    public void print(){
        System.out.print("{");
        for(T data : mData){
            System.out.print(data.toString()+", ");
        }
        System.out.print("}");
    }
}
