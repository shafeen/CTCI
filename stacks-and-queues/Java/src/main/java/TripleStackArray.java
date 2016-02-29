import java.util.ArrayList;

public class TripleStackArray {
    static int INITIAL_CAPACITY = 6;

    private int stack1size = 0, stack2size = 0, stack3size = 0;
    private int stack1base = 0, stack2base = 1, stack3base = 2;
    private int currentInternalArrayCapacity = INITIAL_CAPACITY;
    private ArrayList<Integer> internalArray = new ArrayList<Integer>(INITIAL_CAPACITY);

    public TripleStackArray() {
        initArrayWithNull(this.internalArray, 0, INITIAL_CAPACITY-1);
    }

    public void stack1push(Integer data) {
        this.stack1size += 1;
        if ((this.stack1size)*3 > this.currentInternalArrayCapacity) {
            this.doubleInternalArrayCapacity();
        }
        this.internalArray.add(this.stack1base + (this.stack1size-1)*3, data);
    }

    public Integer stack1pop() {
        if (this.stack1size == 0) {
            throw new RuntimeException("Cannot pop an empty stack!!");
        }
        this.stack1size -= 1;
        int poppedIndex = stack1base + stack1size*3;
        Integer data = this.internalArray.get(poppedIndex);
        this.internalArray.set(poppedIndex, null);
        return data;
    }

    public int stack1size() {
        return this.stack1size;
    }

    public void stack2push(Integer data) {
        this.stack2size += 1;
        if ((this.stack2size)*3 > this.currentInternalArrayCapacity) {
            this.doubleInternalArrayCapacity();
        }
        this.internalArray.add(this.stack2base + (this.stack2size-1)*3, data);
    }

    public Integer stack2pop() {
        if (this.stack2size == 0) {
            throw new RuntimeException("Cannot pop an empty stack!!");
        }
        this.stack2size -= 1;
        int poppedIndex = stack2base + stack2size*3;
        Integer data = this.internalArray.get(poppedIndex);
        this.internalArray.set(poppedIndex, null);
        return data;
    }

    public int stack2size() {
        return this.stack2size;
    }

    public void stack3push(Integer data) {
        this.stack3size += 1;
        if ((this.stack3size)*3 > this.currentInternalArrayCapacity) {
            this.doubleInternalArrayCapacity();
        }
        this.internalArray.add(this.stack3base + (this.stack3size-1)*3, data);
    }

    public Integer stack3pop() {
        if (this.stack3size == 0) {
            throw new RuntimeException("Cannot pop an empty stack!!");
        }
        this.stack3size -= 1;
        int poppedIndex = stack3base + stack3size*3;
        Integer data = this.internalArray.get(poppedIndex);
        this.internalArray.set(poppedIndex, null);
        return data;
    }

    public int stack3size() {
        return this.stack3size;
    }

    /** ONLY call this when internalArray capacity is no
     *  longer enough for any single of the 3 stacks */
    private void doubleInternalArrayCapacity() {
        this.currentInternalArrayCapacity *= 2;
        ArrayList<Integer> newInternalArray = new ArrayList<Integer>(currentInternalArrayCapacity);
        for (Integer i : this.internalArray) {
            newInternalArray.add(i);
        }
        initArrayWithNull(newInternalArray,
                currentInternalArrayCapacity/2,
                currentInternalArrayCapacity-1);
        this.internalArray = newInternalArray;
    }

    private void initArrayWithNull(ArrayList<Integer> array, int offset, int endIndex) {
        for (int i = offset; i <= endIndex ; i++) {
            array.add(null);
        }
    }

}
