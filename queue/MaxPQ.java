package queue;

public class MaxPQ {
    Integer[] heap;
    int n;

    public MaxPQ(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(3);
//        System.out.println("size is : "+pq.size());
//        System.out.println("heap empty : "+pq.isEmpty());
        pq.insert(5);
        pq.insert(2);
        pq.insert(7);
        pq.insert(9);
        pq.insert(8);
        pq.insert(3);
        pq.insert(6);
        System.out.println("heap  before deletion : ");
        pq.printMaxHeap();
        System.out.println("size is : " + pq.size());
        pq.delete();
//        pq.delete();
//        pq.delete();
        System.out.println("heap after deletion: ");
        pq.printMaxHeap();
        System.out.println("size is : " + pq.size());

//        System.out.println("real size of current heap array is : "+pq.heap.length);
//        System.out.println("heap empty : "+pq.isEmpty());
//
//        int [] abc = {2,4,5,6,7,8,8};
//        System.out.println("abc length : "+abc.length);
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(int data) {
        // in Heap, we store value in array from index 1 not from index 0.
        // so initial value of n is 0 and before inserting we are increasing value of n by 1.
        if (n == heap.length - 1) {  // we are doing -1 because of starting from 1st index of array
            resize(2 * heap.length);
        }
        n++;
        heap[n] = data;
        swim(n);

    }

    private void swim(int n) {
        while (n > 1 && heap[n / 2] < heap[n]) {
            Integer temp = heap[n];
            heap[n] = heap[n / 2];
            heap[n / 2] = temp;
            n = n / 2; // because we need to continue shifting till new value inserted at correct position
        }
    }

    private void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void printMaxHeap() {
        for (int i = 1; i <= n; i++) {
            if (heap[i] != null) {
                System.out.print(heap[i] + " ");
            }
        }
        System.out.println();
    }

    public void delete() {
//        if (n == 0){
//            return;
//        }else {
//            for (int j = 1; j < n ; j++){
//                heap[j] = heap[j+1];
//            }
//            n--;
//            for (int a = n; a >=1; a--){
//                swim(a);
//            }
//        }

        if (isEmpty()) {
            return;
        } else {
            heap[1] = heap[n];
            n = n - 1;
            int i = 1;
            while (i < n) {
                int largest;
                if (i * 2 < n) {
                    int left = i * 2;
                    int right = i * 2 + 1;
                    largest = heap[left] > heap[right] ? 2 * i : 2 * i + 1;
                } else if (i * 2 + 1 <= n) {
                    largest = i * 2;
                } else {
                    largest = i;
                }

                if (heap[i] < heap[largest]) {
                    Integer temp = heap[i];
                    heap[i] = heap[largest];
                    heap[largest] = temp;
                    i = largest;
                } else {
                    return;
                }
            }
        }
    }
}
