import java.util.HashSet;

/**
 * CTCI - Linked Lists.
 */
public class Main {

    public static void main(String[] args) {
        //q2_1(getCustomLinkedList(new Integer[]{1, 3, 2, 2, 4, 4, 2, 3}));
        q2_2(getCustomLinkedList(new Integer[]{1, 2, 3, 4}), 2);
    }

    // common helper function for use by all questions
    public static LinkedList<Integer> getCustomLinkedList(Integer[] srcArray) {
        LinkedList<Integer> head = null; // to be set when list initialized
        LinkedList<Integer> customListPtr = null;
        for (Integer i : srcArray) {
            if (customListPtr == null) {
                customListPtr = new LinkedList<Integer>(i);
                head = customListPtr;
            } else {
                customListPtr = customListPtr.setNext(new LinkedList<Integer>(i)).getNext();
            }
        }
        return head;
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
