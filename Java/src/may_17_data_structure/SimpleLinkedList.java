package may_17_data_structure;

/**
 * Created by DoDo on 2017-05-14.
 */
public class SimpleLinkedList<T>{
    private Node<T> mHead;

    public SimpleLinkedList(){
    }

    public SimpleLinkedList(T... datas) {
        this.mHead = new Node<T>(datas[0]);
        if(datas.length<2)
            return;
        Node<T> current = mHead;
        Node<T> temp = null;
        for(int i = 1; i < datas.length ;i++){
            temp = new Node<>(datas[i]);
            current.setNext(temp);
        }
    }
    public void add(int index, T data){
        if(index<1){
            Node<T> temp = new Node<>(data);
            temp.setNext(mHead);
            return;
        }
        //0. 생성할 위치를 가리키는 노드를 가져온다.
        Node<T> before = getNode(index-1);
        Node<T> next = before.getNext();

        // 1. 새 노드를 생성한다.
        Node<T> temp = new Node<>(data);
        // 2. 새 노드가 해당 위치의 기존 노드를 가리키게 한다.
        temp.setNext(next);
        //3. 기존 노드의 앞의 노드가 새 노드를 가리키게 한다.
        before.setNext(temp);
    }
    public T remove(int index){
        if(index<1){
            T returnValue = mHead.getValue();
            mHead = mHead.getNext();
            return returnValue;
        }
        //0. 삭제할 위치를 가리키는 노드를 가져온다.
        Node<T> before = getNode(index-1);
        //1. 삭제할 노드를 가져온다.
        Node<T> temp = before.getNext();
        //2. 삭제할 노드의 앞의 노드가 삭제할 노드의 다음 노드를 가리키게한다.
        Node<T> next = temp.getNext();
        before.setNext(next);

        return temp.getValue();
    }

    public Node<T> getNode(int index){
        Node<T> result = mHead;
        for(int i = 0; i < index ; i++){
            result = result.getNext();
        }
        return result;
    }

    public Node<T> searchNode(T data){
        Node<T> result = mHead;
        while(result != null){
            if(result.getValue().equals(data)){
                return result;
            }
            result = result.getNext();
        }
        return null;
    }

    public void print(){
        System.out.print("{");
        Node<T> point = mHead;
        while(point!= null){
            System.out.print(point.getValue());
            point = point.getNext();
        }
        System.out.print("}");
    }

    public class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

