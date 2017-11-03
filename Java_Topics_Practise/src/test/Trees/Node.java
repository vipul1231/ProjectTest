package test.Trees;

public class Node<E> {
    private Node<E> next;
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }
    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }
    private E data;
    
}
