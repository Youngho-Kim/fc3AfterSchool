package may_17_data_structure;

/**
 * Created by DoDo on 2017-05-14.
 */
public class BinarySearchTree<T>{
    SearchTreeNode root;
    int rootKey;
    public BinarySearchTree(T rootData, int rootKey) {
        root = new SearchTreeNode(rootData,(this.rootKey =rootKey));
    }

    public SearchTreeNode<T> search(SearchTreeNode<T> root, int key){
        SearchTreeNode<T> temp = root;
        if(temp == null)
            return null;
        if(key == temp.getKey()){
            return temp;
        }else{
            if(key < temp.getKey())
                temp = temp.getLeft();
            if(key> temp.getKey())
                temp = temp.getRight();
            return search(temp,key);
        }
    }
    public SearchTreeNode<T>[] searchTreeNodeAndParent(SearchTreeNode<T> root, SearchTreeNode<T> parent, int key){
        SearchTreeNode<T> temp = root;
        SearchTreeNode<T> pTemp = parent;
        if(temp == null)
            return null;
        if(key == temp.getKey()){
            return new SearchTreeNode[]{temp, pTemp};
        }else{
            pTemp = temp;
            if(key < temp.getKey())
                temp = temp.getLeft();
            if(key> temp.getKey())
                temp = temp.getRight();
            return searchTreeNodeAndParent(temp,pTemp,key);
        }
    }

    public void insert(SearchTreeNode<T> root, int key, T value){
        SearchTreeNode<T> temp = root, temq = null;
        do{
            // key와 현재 노드와의 키가 같으면, 이미 트리에 키가 존재하는 것으로 삽입 과정을 멈춘다.
            if(key == temp.getKey())
                return;
            // 비어있는 노드의 조상을 임시 노드에 넣어둔다.
            temq = temp;
            // key가 temp의 키값보다 작을 경우 temp에 현재 temp노드의 좌측 자식을 대입한다.
            if(key < temp.getKey()) {
                temp = temp.getLeft();
            // key가 temp의 키값보다 클 경우 temp에 현재 temp노드의 우측 자식을 대입한다.
            }else{
                temp = temp.getRight();
            }
        } while(temp != null);
        //반복문이 멈췄을 때
        // 위에서 임시 노드에 대입한 조상 노드의 키값이 삽입하려는 키값보다 작을 경우 좌측 자식에 클 경우 우측 자식에 새 노드를 삽입한다.
        if(temq.getKey()< key){
            temq.setLeft(new SearchTreeNode<T>(value,key));
        }else{
            temq.setRight(new SearchTreeNode<T>(value,key));
        }
    }

    public SearchTreeNode<T> delete(SearchTreeNode<T> root,SearchTreeNode<T> parent ,int key){
        SearchTreeNode<T>[] deletables = searchTreeNodeAndParent(root,parent, key);
        SearchTreeNode<T> deletable = deletables[0];
        SearchTreeNode<T> deletableParent = deletables[1];
        if(deletable == null)
            return null;
        if(deletable.getLeft() == null && deletable.getRight() == null){
            if(deletableParent.getLeft() == deletable){
                deletableParent.setLeft(null);
            }else if(deletableParent.getRight() == deletable){
                deletableParent.setRight(null);
            }
        }else if(deletable.getLeft() != null && deletable.getRight() != null){
            SearchTreeNode<T> replaceable = null;
            boolean left = true;
            if(left){
                replaceable = getMax(deletable.getLeft());
            }else{
                replaceable = getMax(deletable.getRight());
            }
            if(deletableParent.getLeft() == deletable){
                deletableParent.setLeft(replaceable);
                replaceable.setLeft(deletable.getLeft());
                replaceable.setRight(deletable.getRight());
            }else{
                deletableParent.setRight(replaceable);
                replaceable.setLeft(deletable.getLeft());
                replaceable.setRight(deletable.getRight());
            }
        }else if(deletable.getLeft() != null){
            if(deletableParent.getLeft() == deletable){
                deletableParent.setLeft(deletable.getLeft());
            }else if(deletableParent.getRight() == deletable){
                deletableParent.setRight(deletable.getLeft());
            }
        }else if(deletable.getRight() != null){
            if(deletableParent.getLeft() == deletable){
                deletableParent.setLeft(deletable.getRight());
            }else if(deletableParent.getRight() == deletable){
                deletableParent.setRight(deletable.getRight());
            }
        }
        return deletable;
    }

    public SearchTreeNode<T> getMin(SearchTreeNode<T> root){
        if(root.getRight() == null){
            return root;
        }else {
            return getMin(root.getRight());
        }
    }
    public SearchTreeNode<T> getMax(SearchTreeNode<T> root){
        if(root.getLeft() == null){
            return root;
        }else {
            return getMax(root.getLeft());
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
