package may_17_data_structure;

/**
 * Created by DoDo on 2017-05-14.
 */
public class DualLinkedListed<T> {
    DualNode<T> head;

    public DualLinkedListed(){}
    public DualLinkedListed(T... data) {
        this.head = new DualNode<>(data[0]);
        DualNode<T> temp = null;
        DualNode<T> before = head;
        for(int i =1 ; i< data.length; i++){
            temp = new DualNode<>(data[i]);
            before.setNext(temp);
            temp.setBefore(before);
            before = temp;
        }
    }
    public void add(int index, T data){
        //0. 생성할 위치에 있던 노드를 가져온다.
        DualNode next = get(index);
        //1. 생성
        DualNode<T> temp = new DualNode<>(data);
        //2. 생성할 위치에 있던 노드를 새 노드가 가리키게 한다.
        temp.setNext(next);
        //3. 생성할 위치에 있던 노드 이전 노드를 새 노드가 가리키게 한다.
        temp.setBefore(next.getBefore());
        //4. 생성할 위치에 있던 노드 이전 노드가 새 노드를 가리키게 한다.
        next.getBefore().setNext(temp);
        //5. 생성할 위치에 있던 노드가 새노드를 가리키게한다.
        next.setBefore(temp);
    }

    public T remove(int index){
        //0. 삭제할 노드를 찾는다.
        DualNode<T> deletable = get(index);
        //1. 삭제할 노드의 다음 노드가 삭제할 노드의 이전 노드를 가리키게 한다.
        deletable.getNext().setBefore(deletable.getBefore());
        //2. 삭제할 노드의 이전 노드가 삭제할 노드의 다음 노드를 가리키게 한다.
        deletable.getBefore().setNext(deletable.getNext());
        return deletable.getValue();
    }

    public DualNode<T> get(int index){
        DualNode<T> result = head;
        for(int i = 0; i < index; i++){
            result = result.getNext();
        }
        return result;
    }
    class DualNode<T> {
        private DualNode<T> before;
        private DualNode<T> next;
        private T value;

        public DualNode(T value) {
            this.value = value;
        }
        public DualNode<T> getBefore() {
            return before;
        }
        public void setBefore(DualNode<T> before) {
            this.before = before;
        }
        public DualNode<T> getNext() {
            return next;
        }
        public void setNext(DualNode<T> next) {
            this.next = next;
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
    }
}
