public class BinarySearchST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

    //private fields
    private Key[] keys;
    private Value[] values;
    private int size;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];

    }

    private int rank(Key key) {
        //key is what we are looking for
        //returns the index of where the key is located
        // (or where it should be located)
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
        int i = rank(key);

        if (i < size && key.compareTo(keys[i]) == 0) {
            //we found the key in the keys array
            //so that means a value already exists
            //and we overwrite the existing value and DONE
            values[i] = val;
            return;
        }

        //if we get here, we know the key is not in the array
        //so shift items over to make room at position i
        for (int j = size; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }

        //once we get here, shifting is done and there's a spot
        keys[i] = key;
        values[i] = val;
        size++;
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param key
     */
    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        //rank() is going to give us the index of where key is located
        //       OR going to give us the index of where the key should go if it's not there

        if (i < size && key.compareTo(keys[i]) == 0) {
            return values[i];
        }
        else {
            return null;
        }

    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
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

        //walk through keys array and enqueue all the keys
        for (int i = 0; i < size; i++) {
            q.enqueue(keys[i]);
        }

        return q;
    }
}
