package Trie;

import java.util.HashMap;
import java.util.Map;
class TrieNode{
    TrieNode[] child;
    boolean isWord;
    int cp;
    public TrieNode(){
        this.child = new TrieNode[26];
        this.isWord = false;
        cp = 0;
    }
}
public class Trie_codestudio_ll {

    public static class Trie {

        public static void main(String[] args) {
            insert("coding");
            insert("ninja");
            System.out.println("count words equal to = "+countWordsEqualTo("coding"));
            System.out.println("prefix count = "+countWordsStartingWith("ni"));
            erase("coding");
            System.out.println("count words equal to = "+countWordsEqualTo("coding"));
        }
        static TrieNode root;
        static Map<String, Integer> map = new HashMap();
        public Trie() {
            // Write your code here.
            root = new TrieNode();
        }


        public static void insert(String word) {
            word = word.toLowerCase();
            TrieNode cur = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                int index = c -'a';
                if(cur.child[index] == null){
                    TrieNode node = new TrieNode();
                    cur.child[index] = node;
                    cur.cp +=1;
                    cur = node;
                }else{
                    cur.cp += 1;
                    cur = cur.child[index];
                }
            }
            cur.isWord = true;
            map.put(word, map.getOrDefault(word, 0)+1);

        }

        public static int countWordsEqualTo(String word) {
            // Write your code here.
            try{
                return map.get(word);
            }
            catch(Exception e){
            }
            return 0;
        }

        public static int countWordsStartingWith(String word) {
            // Write your code here.
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                int index = c - 'a';
                if(cur.child[index] == null){
                    return 0;
                }
                cur = cur.child[index];
            }
            return cur.cp;
        }

        public static void erase(String word) {
            // Write your code here.
            word = word.toLowerCase();
            TrieNode cur = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                int index = c -'a';
                if(cur.child[index] == null){
                    TrieNode node = new TrieNode();
                    cur.child[index] = node;
                    cur.cp -=1;
                    cur = node;
                }else{
                    cur.cp -= 1;
                    cur = cur.child[index];
                }
            }
            cur.isWord = false;
            map.put(word, map.getOrDefault(word, 0)-1);
        }
    }


}
