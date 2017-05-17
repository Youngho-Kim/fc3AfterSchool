package may_17_data_structure;

import sun.reflect.generics.tree.Tree;

/**
 * Created by DoDo on 2017-05-14.
 */
public class BinaryTree<T> {
    TreeNode<T> root;

    public BinaryTree(){}
    public BinaryTree(T rootData) {
        this.root = new TreeNode<>(rootData);
    }


    public TreeNode<T> searchEmptyNode(TreeNode<T> root){
        if(root.getLeft() == null){
            return root;
        }else if(root.getRight() == null){
            return root;
        }else{
            TreeNode<T> temp = null;
            if((temp = searchEmptyNode(root.getLeft())) == null){
                return temp;
            }else if( (temp = searchEmptyNode(root.getRight())) != null)
                return temp;
        }
        return null;
    }

    public void addNode(TreeNode<T> node){
        TreeNode<T> emptyNode = searchEmptyNode(root);
        if(emptyNode == null)
            throw new NullPointerException("No node is detected");
        if(emptyNode.getLeft() == null){
            emptyNode.setLeft(node);
            return;
        }else if(emptyNode.getRight() == null){
            emptyNode.setRight(node);
            return;
        }
    }

    public void preOrder(){
        System.out.print(root.getValue().toString());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void preOrder(TreeNode root){
        System.out.print(root.getValue().toString());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(){
        inOrder(root.getLeft());
        System.out.print(root.getValue().toString());
        inOrder(root.getRight());
    }
    public void inOrder(TreeNode root){
        inOrder(root.getLeft());
        System.out.print(root.getValue().toString());
        inOrder(root.getRight());
    }

    public void postOrder(){
        postOrder(root.getLeft());
        System.out.print(root.getValue().toString());
        postOrder(root.getRight());
    }
    public void postOrder(TreeNode root){
        postOrder(root.getLeft());
        System.out.print(root.getValue().toString());
        postOrder(root.getRight());
    }


    class TreeNode<T>{
        TreeNode left;
        TreeNode right;
        T value;

        public TreeNode(T value) {
            this.value = value;
        }
        public TreeNode getLeft() {
            return left;
        }
        public void setLeft(TreeNode left) {
            this.left = left;
        }
        public TreeNode getRight() {
            return right;
        }
        public void setRight(TreeNode right) {
            this.right = right;
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
    }
}
