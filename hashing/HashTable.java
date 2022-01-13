package hashing;

public class HashTable {
    private HashNode[] buckets;
    private final int numOfBuckets;
    private int size;

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
        return null;
    }

    public String remove(Integer key){
        return null;
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put(105, "Tom");
        table.put(21, "Sana");
        table.put(21, "Mery");

        System.out.println(table.size());

    }

}

