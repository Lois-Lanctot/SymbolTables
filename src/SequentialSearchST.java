//linked list
public class SequentialSearchST<Key, Value>
        implements SymbolTable<Key, Value> {

    private Node head;
    private int size;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;

        }
    }


    /**
     * Constructor for SequentialSearchST
     *
     */
    public SequentialSearchST() {
        head = null;
        size = 0;
    }

    /**
     * Put a key-value pair into the table
     *
     * @param key a given key
     * @param val a given value
     */
    @Override
    public void put(Key key, Value val) {
        //if the key is not in the list put it up front
        //but if the key is already in the list, replace the value
        //is that node

        //loop through the nodes to see if the key is there
        Node current = head;
        while (current != null) {
            if (key.equals(current.key)) {
                //we found the key! so replace the value
                current.value = val;
                return;
            }
            current = current.next;
        }

        //if we got here, we know key doesn't't exist in the list
        //so, we make a new node and put it at the front
        head = new Node(key, val, head);
        size++;
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param key returns the value paired with the given key
     */
    @Override
    public Value get(Key key) {
        Node current = head;
        while (current != null) {
            if (key.equals(current.key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return the number of key-value pairs
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedQueue<>();

        Node current = head;
        while (current != null) {
            q.enqueue(current.key);
            current = current.next;
        }

        return q;
    }
}
