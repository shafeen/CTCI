import java.util.HashSet;

/**
 * CTCI - Linked Lists.
 */
public class Main {

    public static void main(String[] args) {
        //q2_1(getUnsortedLinkedList());
        q2_2(getUnsortedLinkedList(), 2);
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
    // NOTE: I'm assuming 2nd to last means 2 away from the null node
    public static void q2_2(LinkedList<Integer> list, int k) {
        if (k < 1) {
            throw new RuntimeException("k must be a nonzero positive integer!");
        }
        System.out.printf("The kth (k = %d) to last element of:\n%s\nis = %d\n",
                k, list, getKthToLastElementInList(list, k));
    }

    private static Integer getKthToLastElementInList(LinkedList<Integer> list, int k) {
        int headToFollowDistance = k; // 2nd to last means follow behind by 2

        // propagate head to the headToFollowDistance
        LinkedList<Integer> headPtr = list;
        LinkedList<Integer> followPtr = list;
        while (headToFollowDistance != 0) {
            if (headPtr == null) {
                throw new RuntimeException("There aren't enough elements in this list!");
            }
            headPtr = headPtr.getNext();
            headToFollowDistance--;
        }

        // now move both pointers until headPtr reaches the end of the list
        // at that point, the followPtr will be pointing at the kth to last element
        while (headPtr != null) {
            headPtr = headPtr.getNext();
            followPtr = followPtr.getNext();
        }

        return followPtr.getData();
    }

    // -----------------------------------------------


}
