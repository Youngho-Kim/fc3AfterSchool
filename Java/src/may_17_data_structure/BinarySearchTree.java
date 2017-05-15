package may_17_data_structure;

/**
 * Created by DoDo on 2017-05-14.
 */
public class BinarySearchTree<T>{
    SearchTreeNode root;
    public BinarySearchTree(T rootData) {
        root = new SearchTreeNode(rootData,);
    }
    public SearchTreeNode<T> search(SearchTreeNode<T> root, int key){
        if(key == root.getKey()){
            return root;
        }else if(key < root.getKey()){
            return search(root.getLeft(), key);
        }else{
            return search(root.getRight(), key);
        }
    }

    public void insert(SearchTreeNode<T> root, int key, T value){
        SearchTreeNode<T> temp = root, temporary;
        if(key == temp.getKey()){
            return;
        }else if(key < temp.getKey()){
            insert(root.getLeft(),key,value);
        }else if(key > temp.getKey()){
            insert(root.getRight(),key,value);
        }
    }

    class SearchTreeNode<T>{
        private int key;
        private T value;
        private SearchTreeNode<T> left;
        private SearchTreeNode<T> right;
        public SearchTreeNode(T value, int key) {
            this.key = key;
        }
        public int getKey() {
            return key;
        }
        public void setKey(int key) {
            this.key = key;
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
        public SearchTreeNode<T> getLeft() {
            return left;
        }
        public void setLeft(SearchTreeNode<T> left) {
            this.left = left;
        }
        public SearchTreeNode<T> getRight() {
            return right;
        }
        public void setRight(SearchTreeNode<T> right) {
            this.right = right;
        }
    }
}
