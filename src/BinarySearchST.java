public class BinarySearchST<Key extends Comparable, Value> implements SymbolTable<Key, Value> {

    //private fields
    private Key[] keys;
    private Value[] values;
    private int size;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];

    }

    private int rank(Key key) {
        //returns the index of where the key is located
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) /2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {  //if key < keys[mid]
                high = mid - 1;
            }
            else if (cmp > 0) { //else if key > keys[mid]
                low = mid + 1;
            }
            else { //else we know key == keys[mid]
                return mid;
            }
        }

        return low;
    }

    /**
     * Put a key-value pair into the table
     *
     * @param key
     * @param val
     */
    @Override
    public void put(Key key, Value val) {

    }

    /**
     * Returns the value paired with the given key.
     *
     * @param key
     */
    @Override
    public Value get(Key key) {
        return null;
    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
