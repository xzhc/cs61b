/**
 * deque implimented by array
 * @author 18389
 */
public class ArrayDeque<T> {
    /** array to save data */
    private T []array;
    /** size of the deque */
    private int size;
    /** length of array */
    private int length;
    /** front index */
    private int front;
    /** last index */
    private int last;

    /** constructor for ArrayDeque */
    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        length = 8;
        front = 4;
        last = 4;
    }

    /** Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        return size == 0;
    }

    /**  Returns the number of items in the deque */
    public int size() {
        return size;
    }

    /** return the "index+1"*/
    private int plusOne(int index, int module) {
        index %= module;
        if (index == module -1) {
            return 0;
        }
        return index + 1;
    }

    /** return the "index-1" */
    private int minusOne(int index) {
        if (index == 0) {
            return length - 1;
        }
        return index - 1;
    }

    /** array grow */
    public void grow() {
        T[] newArray = (T[]) new Object[length * 2];
        int ptr1 = front;
        int ptr2 = length;
        while (ptr1 != last) {
            newArray[ptr2] = array[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length * 2);
        }
        front = length;
        last = ptr2;
        array = newArray;
        length *= 2;
    }

    /** array shrink */
    public void shrink() {
        T[] newArray = (T[]) new Object[length / 2];
        int ptr1 = front;
        int ptr2 = length / 2;
        while (ptr1 != last) {
            newArray[ptr2] = array[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length / 2);
        }
        front = length / 4;
        last = ptr2;
        array = newArray;
        length /= 2;
    }

    /** Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        if (size == length - 1) {
            grow();
        }
        front = minusOne(front);
        array[front] = item;
        size++;
    }
    /** Add an item of type T to the last of the deque */
    public void addLast(T item) {
        if (size == length - 1) {
            grow();
        }
        array[last] = item;
        last = plusOne(last, length);
        size++;
    }

    /** Prints the items in the deque from the first to last, separated by a space*/
    public void printDeque() {
        int ptr = front;
        while (ptr != last) {
            System.out.println(array[ptr] + " ");
            ptr = plusOne(ptr, length);
        }
    }

    /** Removes and returns the item at the front of the deque. If not such item, return
     * null
     */
    public T removeFirst() {
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        if (size == 0) {
            return null;
        }
        T res = array[front];
        front = plusOne(front, length);
        size--;
        return  res;
    }

    /** Removes and returns the item at the back of the deque. If not such item, return null
     */
    public T removeLast() {
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        if (size == 0) {
            return null;
        }
        last = minusOne(last);
        T res = array[last];
        size--;
        return res;
    }

    /** Gets the item at the given index */
    public T get(int index) {
        if (index > size) {
            return null;
        }
        int ptr = front;
        for (int i = 0; i < index; i++) {
            ptr = plusOne(ptr, length);
        }
        return array[ptr];
    }


}
