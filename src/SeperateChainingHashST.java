public class SeperateChainingHashST <K, V> implements SymbolTable<K, V> {

    // private fields
    // array of linked lists
    private SequentialSearchST<K, V>[] table;
    private int tableSize;
    private int size;

    public SeperateChainingHashST(int tableSize) {
        this.tableSize = tableSize;
        size = 0;

        // creates an array (each element is default initialized to null
        table = new SequentialSearchST[tableSize];

        // loop through array, replace null with an empty linked list object
        for (int i = 0; i < tableSize; i++) {
            table[i] = new SequentialSearchST();
        }
    }


    public SeperateChainingHashST() {
        // call the other constructor and set up 997 buckets - random number for now
        this(997);
        size = 0;
    }


    // private helper method - the hash function
    private int hash(K key) {
        // take a key and generate an index number
//        return key.hashCode() % tableSize;

        // if you want more mixing up
        return (key.hashCode() & 0x7fffffff) % tableSize;

    }




    /**
     * Put a key-value pair into the table
     *
     * @param k
     * @param val
     */
    @Override
    public void put(K k, V val) {
        // if the table doesn't contain the key, bump the size up
        if (!table[hash(k)].contains(k)) {
            size++;
        }

        // add the new key, or replace the value associated with the key if already there
        table[hash(k)].put(k, val);
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param k
     */
    @Override
    public V get(K k) {
        return table[hash(k)].get(k);
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
    public Iterable<K> keys() {
        // create an empty queue as a collector/container
        Queue<K> q = new LinkedQueue();

        // loop through table and collect keys
        for (int i = 0; i < tableSize; i++) {
            for (K singleKey : table[i].keys()) {
                q.enqueue(singleKey);
            }
        }

        return q;
    }
}


