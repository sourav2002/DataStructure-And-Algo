package array;

public class ArrayInsert {
    public static void main(String args[]) {
        int arr[] = new int[5];

        insertAtEnd(arr, 2);
        insertAtEnd(arr, 3);
        insertAtEnd(arr, 4);
        insertAtEnd(arr, 5);

        printArray(arr);

        insertAtStart(arr, 1);

        printArray(arr);
        insertAtPos(arr, 2, 20);
        printArray(arr);

    }
    static int count = 0;

    //insert array element at end
    static void insertAtEnd(int arr[], int val) {
        arr[count++] = val;
    }

    //insert array element at start

    static void insertAtStart(int arr[], int val) {
        for (int i = count; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = val;
    }

    //insert element at given position
    static void insertAtPos(int arr[], int pos, int val) {
        for (int i = count; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = val;
    }


    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
