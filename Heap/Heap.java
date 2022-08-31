package Heap;

// Max-Heap data structure in Java

class Heap {


    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        Heap ob = new Heap();
//        ob.sort(arr);
        ob.heapify(arr, n, 0);
        ob.deleteRoot(arr, n);

        System.out.println("Sorted array is");
        printArray(arr);
    }

    public void insert(int arr[], int n, int key) {
        n = n + 1;
        arr[n - 1] = key;
        // Find parent
        int i = n - 1;
        int parent = (i - 1) / 2;

        if (parent > 0) {
            // For Max-Heap
            // If current node is greater than its parent
            // Swap both of them and call heapify again
            // for the parent
            if (arr[i] > arr[parent]) {
//                swap(arr[i], arr[parent]);
                int temp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = temp;
                // Recursively heapify the parent node
                heapify(arr, n, parent);
            }
        }
    }

    // Function to delete the root from Heap
    int deleteRoot(int arr[], int n) {
        // Get the last element
        int lastElement = arr[n - 1];

        // Replace root with first element
        arr[0] = lastElement;

        // Decrease size of heap by 1
        n = n - 1;

        // heapify the root node
        heapify(arr, n, 0);

        // return new size of Heap
        return n;
    }

    // sort method
    public void sort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    // n (size of array) may vary ( in sort method we are calling heapify method for a specific range )
    public void heapify(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // check l < n && r < n because we are initializing left and right with 2 *  i + 1
        // so, it can exceed the size of array
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}