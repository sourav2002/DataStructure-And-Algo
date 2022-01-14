package hashing;

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
    private class HashNode{
        private Integer key; // can be generic
        private String value; // can be generic
        private HashNode next;

        public HashNode(Integer key, String value){
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
                  return head.value;
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
        return head.value;
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
        System.out.println("removed "+table.remove(1));
        System.out.println("get "+table.get(1));
        System.out.println("get "+table.get(21));

    }

}

