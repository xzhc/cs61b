/**
 * @author 18389
 */
public interface Deque<T> {
    /**
     * Adds an item to the front of the deque.
     * @param item the item to add
     */
    void addFirst(T item);

    /**
     * Adds an item to the end of the deque.
     * @param item the item to add
     */
    void addLast(T item);

    /**
     * Returns true if the deque is empty.
     * @return true if the deque is empty
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the deque.
     * @return the number of items in the deque
     */
    int size();

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    void printDeque();

    /**
     * Removes and returns the first item in the deque.
     * @return the first item in the deque
     */
    T removeFirst();

    /**
     * Removes and returns the last item in the deque.
     * @return the last item in the deque
     */
    T removeLast();

    /**
     * Returns the item at the specified index.
     * @param index the index of the item
     * @return the item at the specified index
     */
    T get(int index);
}
