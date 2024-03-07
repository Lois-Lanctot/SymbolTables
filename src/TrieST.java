public class TrieST {
    // The key type is String
    // The value type is int

    private class Node {
        public int value;
        public Node[] next;     //array of children


        public Node() {
            next = new Node[256];
        }

    }


    private Node root;

    public TrieST() {
        root = new Node();
    }


    public void put(String key, int value) {
        root = put(root, key, value, 0);
    }
    // recursive helper method
    private Node put(Node current, String key, int value, int depth) {
        if (current == null) {
            // if I reached the bottom of the trie, the new node goes here
            current = new Node();
        }

        if (depth == key.length()) {
            // if I found the key, update its value
            current.value = value;
            return current;
        }

        // if not found at this level, need to go to the next level
        char c = key.charAt(depth);     // get the index of the subtree
        current.next[c] = put(current.next[c], key, value, depth + 1);

        return current;
    }



    public int get(String key) {
        Node current = get(root, key, 0);
        if (current == null) {
            return -1;
        }
        else {
            return current.value;
        }
    }

    // helper recursive method
    private Node get(Node current, String key, int depth) {
        if (current == null) {
            // key doesn't exist in the trie
            return null;
        }

        if (depth == key.length()) {
            // we found it!
            return current;
        }

        char c = key.charAt(depth);
        return get(current.next[0], key, depth + 1);

    }












}
