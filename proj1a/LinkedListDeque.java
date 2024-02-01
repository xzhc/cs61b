/**
 * Deque implimented by LinkedList
 * @author 18389
 */
public class LinkedListDeque<T> {
    /** Inner class Node */
    public class Node {
        // the item stored on this node
        private T item;
        // the node before thie node
        private Node pre;
        //the node after this node
        private Node next;

        //constructor for Node
        public Node(T n, Node ppre, Node nnext) {
            item = n;
            pre = ppre;
            next = nnext;
        }

        //constructor for Sentinel node
        public Node(Node ppre, Node nnext) {
            pre = ppre;
            next = nnext;
        }
    }
    /** sentinel node */
    private Node sentinel;
    /** deque size */
    private int size;

    /** constructor for deque */
    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.pre = newNode;
        sentinel.next = newNode;
        size++;
    }

    /** Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = newNode;
        sentinel.pre = newNode;
        size++;
    }

    /** Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the numbers of items in the deque */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space*/
    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.println(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    /** Removes and returns the item at the front of the deque,
     * if no such ite exists , returns null */
    public T removeFirst() {
        if (size == 0) {
            return  null;
        }
        T item = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return  item;
    }

    /** Removes and returns the item at the back of the deque,
     * if no such item exists, return null */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return item;
    }

    /** Gets the item at the given index, where 0 is front, 1 is the next item,
     * and so forth. If no such item exists, return null. Must not alter the deque
     */
    public T get(int index) {
        if (index > size) {
            return null;
        }
        Node ptr = sentinel;
        for (int i = 0; i <= index ; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    /** Same as get, but uses recursion */
    private T getRecursiveHelp(Node start, int index) {
        if (index == 0) {
            return start.item;
        }
        return getRecursiveHelp(start.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }
}

