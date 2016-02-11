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

    // return circular linked list where the tail is linked to head
    public static <T> LinkedList<T> getCircularLinkedList(T[] srcArray) {
        LinkedList<T> listHead = getCustomList(srcArray);
        LinkedList<T> listPtr = listHead;
        while (listPtr.getNext() != null) {
            listPtr = listPtr.getNext();
        }
        listPtr.setNext(listHead);
        return listHead;
    }

    public static <T> int getLength(LinkedList<T> head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.getNext();
        }
        return length;
    }

    // combine list1 and list2 by adding list2 at the end of list1
    public static <T> LinkedList<T> combineLists(LinkedList<T> list1, LinkedList<T> list2) {
        LinkedList<T> listHead = list1;
        while (list1.getNext() != null) {
            list1 = list1.getNext();
        }
        list1.setNext(list2);
        return listHead;
    }
}
