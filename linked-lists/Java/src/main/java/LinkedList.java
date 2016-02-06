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

    public LinkedList<T> setData(T data) {
        this.data = data;
        return this;
    }

    public LinkedList getNext() {
        return next;
    }

    public LinkedList<T> setNext(LinkedList next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        LinkedList<T> head = this;
        String s = "";
        while (head.getNext() != null) {
            s += head.getData() + " -> ";
            head = head.getNext();
        }
        s += "null";
        return s;
    }
}
