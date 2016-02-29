import java.util.ArrayList;
import java.util.List;

/**
 * CTCI - Stacks and Queues
 */
public class Main {

    public static void main(String[] args) {
        q3_1();
    }

    // [3.1] Describe how you could use a single array to implement three stacks
    public static void q3_1() {
        TripleStackArray tripleStackArray = new TripleStackArray();
        tripleStackArray.stack1push(1);
        tripleStackArray.stack1push(2);
        tripleStackArray.stack1push(3);

        System.out.println();

        while (tripleStackArray.stack1size() > 0) {
            System.out.println(tripleStackArray.stack1pop());
        }

        tripleStackArray.stack2push(5);
        tripleStackArray.stack2push(6);
        tripleStackArray.stack2push(7);
        while (tripleStackArray.stack2size() > 0) {
            System.out.println(tripleStackArray.stack2pop());
        }
    }

}
