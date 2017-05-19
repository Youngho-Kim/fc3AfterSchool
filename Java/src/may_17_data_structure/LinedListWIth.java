package may_17_data_structure;

/**
 * Created by DoDo on 2017-05-17.
 */
public class LinedListWIth<T> {
    Node<T> head;
    int length;
    public void add(T data){
        add(length-1,data);
    }

    public void add(int index, T data) {
        if(index<1){
            Node<T> temp = new Node<>(data);
            temp.setNext(head);
            return;
        }
        Node<T> before = get(index - 1);
        Node<T> current = before.getNext();
        before.setNext(new Node<>(data));
        before.getNext().setNext(current.getNext());
    }

    public Node<T> get(int index){
        Node<T> temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp;
    }

    public void remove(int index){
        if(index<1){
            head = head.getNext();
            return;
        } else if(index == length - 1){
            get(index - 1).setNext(null);
            return;
        }
        Node<T> before = get(index - 1);
        before.setNext(before.getNext().getNext());
    }

    class Node<P>{
        private P value;
        private Node<P> next;

        public Node(P value) {
            this.value = value;
        }

        public P getValue() {
            return value;
        }
        public void setValue(P value) {
            this.value = value;
        }
        public Node<P> getNext() {
            return next;
        }
        public void setNext(Node<P> next) {
            this.next = next;
        }
    }
}
