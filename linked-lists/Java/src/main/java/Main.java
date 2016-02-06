import java.util.HashSet;

/**
 * CTCI - Linked Lists.
 */
public class Main {

    public static void main(String[] args) {
        q2_1(getUnsortedLinkedList());
    }

    public static LinkedList<Integer> getUnsortedLinkedList() {
        LinkedList<Integer> unsortedList = new LinkedList<Integer>(1);
        unsortedList.setNext(new LinkedList<Integer>(3)).getNext()
                .setNext(new LinkedList<Integer>(2)).getNext()
                .setNext(new LinkedList<Integer>(2)).getNext()
                .setNext(new LinkedList<Integer>(4)).getNext()
                .setNext(new LinkedList<Integer>(4)).getNext()
                .setNext(new LinkedList<Integer>(2)).getNext()
                .setNext(new LinkedList<Integer>(3));
        return unsortedList;
    }

    // -----------------------------------------------

    // [2.1] Write code to remove duplicates from an unsorted linked list.
    // FOLLOW UP (OPTIONAL)
    // How would you solve this problem if a temporary buffer is not allowed?
    public static void q2_1(LinkedList<Integer> unsortedList) {
        // print the list with and w/o the duplicates
        System.out.println(unsortedList);
        System.out.println(getListWithoutDuplicates(unsortedList));
    }

    // [2.1] helper
    public static LinkedList<Integer> getListWithoutDuplicates(LinkedList<Integer> list) {
        LinkedList<Integer> prev = null;
        LinkedList<Integer> head = list;
        HashSet<Integer> integerSet = new HashSet<Integer>();
        while (head != null) {
            if (!integerSet.contains(head.getData())) {
                integerSet.add(head.getData());
                prev = head;
            } else {
                prev.setNext(head.getNext());
            }
            head = head.getNext();
        }
        return list;
    }

    // -----------------------------------------------

    // [2.2] Implement an algorithm to find the kth
    // to last element of a singly linked list
    public static void q2_2() {

    }

}
