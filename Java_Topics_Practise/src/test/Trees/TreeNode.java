package test.Trees;

public class TreeNode<E> {
    
    int data;
    
    public TreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    TreeNode<E> rightChild;
    
    TreeNode<E> leftChild;

}
