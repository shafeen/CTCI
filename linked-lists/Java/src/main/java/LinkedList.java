/**
 * A very simple implementation of a linked list
 */
public class LinkedList<T> {

    private T data;
    private LinkedList next;

    public LinkedList(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }



}
