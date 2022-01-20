package Heap;// Java program to connect n
// ropes with minimum cost

// A class for Min Heap
class ConnectNRopesInMinCost {
    int[] harr; // Array of elements in heap
    int heap_size; // Current number of elements in min heap
    int capacity; // maximum possible size of min heap

    // Constructor: Builds a heap from
    // a given array a[] of given size
    public ConnectNRopesInMinCost(int a[], int size)
    {
        heap_size = size;
        capacity = size;
        harr = a;
        int i = (heap_size - 1) / 2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    // A recursive method to heapify a subtree
    // with the root at given index
    // This method assumes that the subtrees
    // are already heapified
    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i])
            smallest = l;
        if (r < heap_size && harr[r] < harr[smallest])
            smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            MinHeapify(smallest);
        }
    }

    int parent(int i) { return (i - 1) / 2; }

    // to get index of left child of node at index i
    int left(int i) { return (2 * i + 1); }

    // to get index of right child of node at index i
    int right(int i) { return (2 * i + 2); }

    // Method to remove minimum element (or root) from min heap
    int extractMin()
    {
        if (heap_size <= 0)
            return Integer.MAX_VALUE;
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }

        // Store the minimum value, and remove it from heap
        int root = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MinHeapify(0);

        return root;
    }

    // Inserts a new key 'k'
    void insertKey(int k)
    {
        if (heap_size == capacity) {
            System.out.println("Overflow: Could not insertKey");
            return;
        }

        // First insert the new key at the end
        heap_size++;
        int i = heap_size - 1;
        harr[i] = k;

        // Fix the min heap property if it is violated
        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // A utility function to check
    // if size of heap is 1 or not
    boolean isSizeOne()
    {
        return (heap_size == 1);
    }

    // A utility function to swap two elements
    void swap(int x, int y)
    {
        int temp = harr[x];
        harr[x] = harr[y];
        harr[y] = temp;
    }

    // The main function that returns the
    // minimum cost to connect n ropes of
    // lengths stored in len[0..n-1]
    static int minCost(int len[], int n)
    {
        int cost = 0; // Initialize result

        // Create a min heap of capacity equal
        // to n and put all ropes in it
        ConnectNRopesInMinCost minHeap = new ConnectNRopesInMinCost(len, n);

        // Iterate while size of heap doesn't become 1
        while (!minHeap.isSizeOne()) {
            // Extract two minimum length ropes from min heap
            int min = minHeap.extractMin();
            int sec_min = minHeap.extractMin();

            cost += (min + sec_min); // Update total cost

            // Insert a new rope in min heap with length equal to sum
            // of two extracted minimum lengths
            minHeap.insertKey(min + sec_min);
        }

        // Finally return total minimum
        // cost for connecting all ropes
        return cost;
    }

    // Driver code
    public static void main(String args[])
    {
        int len[] = { 4, 3, 2, 6 };
        int size = len.length;

        System.out.println("Total cost for connecting ropes is " + minCost(len, size));
    }
};

// This code is contributed by Jayti Garg
