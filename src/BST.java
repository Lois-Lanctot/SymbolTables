//BST - Binary Search Tree
// see code in textbook p. 398-399
public class BST<K extends Comparable<K>, V> implements SymbolTable<K, V> {

    private Node root;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int nodesIntSubtree;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            nodesIntSubtree = 0;
        }
    }


    public BST () {
        root = null;
    }


    /**
     * Put a key-value pair into the table
     *
     * @param k
     * @param val
     */
    @Override
    public void put(K k, V val) {
        root = put(root, k, val); //starts the recursion
    }

    private Node put(Node current, K key, V val) {
        if (current == null) {
            Node theNewNode = new Node(key, val);
            theNewNode.nodesIntSubtree = 1;
            return theNewNode;
        }

        int cmp = key.compareTo(current.key);

        if (cmp < 0) {
            current.left = put(current.left, key, val);
        }
        else if (cmp > 0) {
            current.right = put(current.right, key, val);
        }
        else {
            current.value = val;
        }

        current.nodesIntSubtree = size(current.left) + size(current.right) + 1;
        return current;
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param
     * @param keyToFind
     */
    @Override
    public V get(K keyToFind) {
        return get(root, keyToFind);
    }

    private V get(Node current, K keyToFind) {
        if (current == null) {
            return null;
        }

        int cmp = keyToFind.compareTo(current.key);

        if (cmp < 0) { //left -1
            return get(current.left, keyToFind);
        }
        else if (cmp > 0) { //right +1
            return get(current.right, keyToFind);
        }
        else { //got it! 0
            return current.value;
        }
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param keyToFind
     */
    public V getIterative(K keyToFind) {
        Node current = root;

        while (current != null) {
            int cmp = keyToFind.compareTo(current.key);
            if (cmp < 0) {
                //got to left -1
                current = current.left;
            }
            else if (cmp > 0) {
                //go to right +1
                current = current.right;

            }
            else {
                //found it! 0
                return current.value;

            }
        }

        return null;
    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(Node current) {
//        return size(current.left) + size(current.right) + 1;
        if (current == null) {
            return 0;
        }
        else {
            return current.nodesIntSubtree;
        }
    }

    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<K> keys() {

        Queue<K> q = new LinkedQueue<K>();

        inorder(root, q);
        return q;
    }

    private void inorder(Node current, Queue<K> q) {
        if (current == null) {
            return;
        }

        //recursive calls:
        inorder(current.left, q);
        q.enqueue(current.key);

        inorder(current.right, q);

    }
}
