import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * CTCI - Linked Lists.
 */
public class Main {

    public static void main(String[] args) {
        //q2_1(LinkedList.getCustomList(new Integer[]{1, 3, 2, 2, 4, 4, 2, 3}));
        //q2_2(LinkedList.getCustomList(new Integer[]{1, 2, 3, 4}), 2);
        //q2_3(LinkedList.getCustomList(new Integer[]{1,2,3,4,5}), 2);
        //q2_4(LinkedList.getCustomList(new Integer[]{5,4,3,2,1}), 3);
        //q2_5(LinkedList.getCustomList(new Integer[]{7,1,6}), LinkedList.getCustomList(new Integer[]{5,9,2}));
        //q2_6(LinkedList.getCircularLinkedList(new Character[]{'A','B','C','D','E'}));
        q2_7(LinkedList.getCustomList(new Character[]{'H','A','N','N','A','H'}));

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

    // [2.2] helper
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

    // [2.3] Implement an algorithm to delete a node in the middle
    // of a singly linked list, given only access to that node.
    // EXAMPLE:
    // Input: the node c from the linked list a->b->c->d->e
    // Result: nothing is returned, but the new linked list looks like a->b->d->e
    public static void q2_3(LinkedList<Integer> originalList, int nodeNumToRemove) {
        System.out.printf("Removing node %d (from head) of list: %s\n", nodeNumToRemove, originalList);
        removeNodeFromList(originalList, getNthNodeFromHead(originalList, nodeNumToRemove));
        System.out.printf("The resulting list is: %s\n", originalList);
    }

    // [2.3] helper
    public static void removeNodeFromList(LinkedList<Integer> head, LinkedList<Integer> node) {
        // convert node to next node and remove next node
        LinkedList<Integer> nextNode = node.getNext();
        if (nextNode == null) {
            throw new RuntimeException("node must be in the middle of the LinkedList");
        }
        node.setData(nextNode.getData()).setNext(nextNode.getNext());
    }

    // [2.3] helper
    public static LinkedList<Integer> getNthNodeFromHead(LinkedList<Integer> head, int n) {
        if (n < 1) {
            throw new RuntimeException("n must be a positive integer");
        }
        while (n != 0) {
            head = head.getNext();
            n--;
        }
        return head;
    }

    // -----------------------------------------------

    // [2.4] Write code to partition a linked list around a value x, such that
    // all nodes less than x come before all nodes greater than or equal to x.
    // NOTE: my solution will return a new partitioned list
    // TODO: clean up this solution (refactor the functions)
    public static void q2_4(LinkedList<Integer> head, int x) {
        System.out.printf("Partitioning list: [ %s ] \naround value = %d\n", head, x);
        // create the 2 separate partitioned lists (< x and >= x)
        LinkedList<Integer> curNode = head;
        LinkedList<Integer> listLessThanX = null, listLessThanXHead = null;
        LinkedList<Integer> listGrtOrEqToX = null, listGrtOrEqToXHead = null;
        while (curNode != null) {
            if (curNode.getData() < x) {
                if (listLessThanX == null) {
                    listLessThanXHead = listLessThanX = new LinkedList<Integer>(curNode.getData());
                } else {
                    listLessThanX.setNext(new LinkedList<Integer>(curNode.getData()));
                    listLessThanX = listLessThanX.getNext();
                }
            } else {
                if (listGrtOrEqToX == null) {
                    listGrtOrEqToXHead = listGrtOrEqToX = new LinkedList<Integer>(curNode.getData());
                } else {
                    listGrtOrEqToX.setNext(new LinkedList<Integer>(curNode.getData()));
                    listGrtOrEqToX = listGrtOrEqToX.getNext();
                }
            }
            curNode = curNode.getNext();
        }

        // combine the 2 partitioned lists and return head of this list
        while (listGrtOrEqToXHead != null) {
            listLessThanX.setNext(new LinkedList<Integer>(listGrtOrEqToXHead.getData()));
            listLessThanX = listLessThanX.getNext();
            listGrtOrEqToXHead = listGrtOrEqToXHead.getNext();
        }
        LinkedList<Integer> partitionedList = listLessThanXHead;
        System.out.printf("Newly partitioned list: [ %s ]\n", partitionedList);
    }

    // -----------------------------------------------

    // [2.5] You have two numbers represented by a linked list, where each node contains a single digit.
    // The digits are stored in reverse order, such that the Ts digit is at the head of the list.
    // Write a function that adds the two numbers and returns the sum as a linked list.
    // EXAMPLE
    // Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
    // Output: 2 -> 1 -> 9.That is, 912.
    // FOLLOW UP
    // Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
    // Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
    // Output: 9 -> 1 -> 2.That is, 912.
    public static void q2_5(LinkedList<Integer> numAsList1, LinkedList<Integer> numAsList2) {
        int sum = getNumFromList(numAsList1) + getNumFromList(numAsList2);
        LinkedList<Integer> sumAsList = getNumAsList(sum);
        System.out.printf("Num1 = %s = %d\nNum2 = %s = %d\nSum = %s = %d",
                numAsList1, getNumFromList(numAsList1),
                numAsList2, getNumFromList(numAsList2),
                sumAsList, sum);
    }

    // [2.5] helper
    private static int getNumFromList(LinkedList<Integer> numAsList1) {
        int num = 0, multiplier = 1;
        while (numAsList1 != null) {
            num += numAsList1.getData() * multiplier;
            multiplier *= 10;
            numAsList1 = numAsList1.getNext();
        }
        return num;
    }

    // [2.5] helper
    private static LinkedList<Integer> getNumAsList(int num) {
        LinkedList<Integer> numAsList = null, numAsListHead = null;
        while (num != 0) {
            if (numAsList == null) {
                numAsList = numAsListHead = new LinkedList<Integer>(num % 10);
            } else {
                numAsList.setNext(new LinkedList<Integer>(num % 10));
                numAsList = numAsList.getNext();
            }
            num /= 10;
        }
        return numAsListHead;
    }

    // -----------------------------------------------

    // [2.6] Given a circular linked list, implement an algorithm which returns the node
    // at the beginning of the loop.
    // DEFINITION
    // Circular linked list: A (corrupt) linked list in which a node's next pointer
    // points to an earlier node, so as to make a loop in the linked list.
    // EXAMPLE
    // Input:A->B->C->D->E->C (the same C as earlier) Output:C
    public static void q2_6(LinkedList<Character> circularList) {
        int maxNodeChecks = 100;
        int nodeNum = 1;
        HashSet<LinkedList<Character>> nodeSet = new HashSet<LinkedList<Character>>();
        LinkedList<Character> listPtr = circularList;
        System.out.println("Checking list..");
        while (!nodeSet.contains(listPtr) && nodeNum < maxNodeChecks) {
            nodeSet.add(listPtr);
            listPtr = listPtr.getNext();
            nodeNum++;
        }
        System.out.printf("Node %d containing '%s' is a repeat node\n", nodeNum, listPtr.getData());
    }

    // -----------------------------------------------

    // [2.7] Implement a function to check if a linked list is a palindrome.
    public static void q2_7(LinkedList<Character> palindromeList) {
        int length = LinkedList.getLength(palindromeList);
        int midpoint = length/2;
        List<Character> listHalfChars = new ArrayList<Character>();
        LinkedList<Character> listPtr = palindromeList;
        for (int i = 0; i < midpoint; i++) {
            listHalfChars.add(listPtr.getData());
            listPtr = listPtr.getNext();
        }

        boolean isPalindrome = true;
        int secondHalfStartingPoint = midpoint;
        if (length % 2 == 1) {
            secondHalfStartingPoint++;
            listPtr = listPtr.getNext();
        }
        for (int i = 0; (i + secondHalfStartingPoint < length); i++) {
            if (listPtr.getData() != listHalfChars.get(midpoint-1-i)) {
                isPalindrome = false;
                break;
            }
            listPtr = listPtr.getNext();
        }

        System.out.printf("List [ %s ] is a palindrome = %b", palindromeList, isPalindrome);
    }

    // -----------------------------------------------
}
