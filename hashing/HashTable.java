package hashing;

import java.util.HashMap;

public class HashTable {
    private HashNode[] buckets;
    private final int numOfBuckets;
    private int size;

    public HashTable(){
        numOfBuckets = 10;
        buckets = new HashNode[10];
    }
    public HashTable(int capacity){
        this.numOfBuckets = capacity;
        buckets = new HashNode[capacity];
    }
    private class HashNode<K, V>{
        private K key; // can be generic
        private V value; // can be generic
        private HashNode next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }


    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    // hash function
    public int getBucketIndex(Integer key){
        return key % buckets.length;
    }

    // hash function if the key is a String
    public int hashForString(String key){
        // Traverse the string
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += ((int)key.charAt(i)) * Math.pow(  31, (key.length()-(i+1)  ));
        }
        return hash %10;
    }

    // 3 main methods

    public void put(Integer key, String value){
        if (key == null || value == null){
            throw new IllegalArgumentException("Key or value is null");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null){
            if (head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key,value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    public String get(Integer key){
        if (key == null){
            throw new IllegalArgumentException("Key is null");
        }
          int bucketIndex = getBucketIndex(key);
          HashNode head = buckets[bucketIndex];
          while (head != null){
              if (head.key.equals(key)){
                  return head.value.toString();
              }
              head = head.next;
          }
        return null;
    }

    public String remove(Integer key){
        if (key == null){
            throw new IllegalArgumentException("Key is null");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode prev = null;
        while (head != null){
            if (head.key.equals(key)){
                break; // because we only wants to get head and prev at their required position
            }
            prev = head;
            head = head.next;
        }
        if (head == null) return null; // if head.key not found then head.next become null
        size--;
        if (prev == null){
            buckets[bucketIndex] = head.next;
        }else {
            prev.next = head.next;
        }
        return head.value.toString();
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put(105, "Tom");
        table.put(21, "Sana");
        table.put(21, "Mery");
        table.put(101, "cat");
        table.put(1, "sourav");

        System.out.println("size is = " + table.size());

        System.out.println("get "+table.get(101));
        System.out.println("get "+table.get(1));
        HashMap n = new HashMap();
        System.out.println("removed "+table.remove(1));
        System.out.println("get "+table.get(1));
        System.out.println("get "+table.get(21));

        System.out.println(table.hashForString("a"));
    }

}

