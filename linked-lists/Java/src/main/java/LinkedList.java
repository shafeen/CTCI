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
        return this.data;
    }

    public LinkedList<T> setData(T data) {
        this.data = data;
        return this;
    }

    public LinkedList<T> getNext() {
        return this.next;
    }

    public LinkedList<T> setNext(LinkedList<T> next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        LinkedList<T> head = this;
        String s = "";
        while (head != null) {
            s += head.getData() + " -> ";
            head = head.getNext();
        }
        s += "null";
        return s;
    }

    // return a custom LinkedList using the data from the srcArray
    public static <T> LinkedList<T> getCustomList(T[] srcArray) {
        LinkedList<T> head = null; // to be set when list initialized
        LinkedList<T> customListPtr = null;
        for (T i : srcArray) {
            if (customListPtr == null) {
                customListPtr = new LinkedList<T>(i);
                head = customListPtr;
            } else {
                customListPtr = customListPtr.setNext(new LinkedList<T>(i)).getNext();
            }
        }
        return head;
    }
}
