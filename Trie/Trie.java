package Trie;

public class Trie {
    private static final int ALPHABET_SIZE = 26;
    private TrieNode root;

    public Trie() {
        root = new TrieNode(); // root is empty
    }

    // Returns true if root has no children, else false
    static boolean isEmpty(TrieNode root) {
        for (int i = 0; i < ALPHABET_SIZE; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();

//        obj.insert("car");
//        obj.insert("cat");
//        obj.insert("cab");
//        obj.insert("son");
//        obj.insert("so");


        String keys[] = {"car", "cat", "cab", "son", "so" };
        String[] output = {"Not present in trie", "Present in trie" };

        for (int i = 0; i < keys.length; i++) {
            obj.insert(keys[i]);
        }

        System.out.println("Values inserted successfully");

        // Search for different keys
        if (obj.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        // Search for different keys
        if (obj.search("car") == true)
            System.out.println("car --- " + output[1]);
        else System.out.println("car --- " + output[0]);
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("invalid input");
        }
        word = word.toLowerCase();


        // whenever we start inserting word, start from root node
        TrieNode current = root; // start with root node
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);  // now get every character of the word
            int index = c - 'a'; // then find the index where it should be stored.
            if (current.children[index] == null) { // if there is not any alphabet already present like there and their
                TrieNode node = new TrieNode(); // creating new node
                current.children[index] = node;  // add new array node on that index where alphabet is stored
                current = node; // and set the position of current_node to new initialized array where
                // we will store next alphabet
            } else { // if any alphabet is already present ex- there and their ...t h e is same alphabet
                current = current.children[index]; // then just move current node to that next already_present node
            }
        }
        current.isWord = true; // after inserting all alphabet of the word finally set isWord = true
    }//end of insert method

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) { // if the alphabet is not present on that particular index
                // then return false
                return false;
            }
            // and after that move to next node ..ex- root node to 0th index node
            current = current.children[index];
        }
        // after the end of loop if every alphabet is present then isWord will give true,
        // because in insert method we end the word with isWord = true
        // another wise upper if condition will throw false for isWord

        return (current != null && current.isWord); // finally at the end of for loop, value of current will be last alphabet index and
        // if it is present than it will surely give us true
    }

    public TrieNode remove(String word, int depth) {
        // If tree is empty
        if (root == null)
            return null;

        // If last character of key is being processed    #BASE CASE
        if (depth == word.length()) {
            // This node is no more end of word after
            // removal of given key
            if (root.isWord)
                root.isWord = false;

            // If given is not prefix of any other word
            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }
        // If not last character, recur for the child
        // obtained using ASCII value
        int index = word.charAt(depth) - 'a';
        root.children[index] =
                remove(word, depth + 1);

        // If root does not have any child (its only child got
        // deleted), and it is not end of another word.
        if (isEmpty(root) && root.isWord == false) {
            root = null;
        }

        return root;
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[ALPHABET_SIZE]; // storing english words a to z
            this.isWord = false;
        }
    }//end of trie node class
}
