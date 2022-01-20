package array;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 5, 7, 8, 9};
        int arr2[] = {2, 3, 5, 6, 8};
        System.out.println("Union set is: ");
        Union(arr1, arr2);
        System.out.println();
        System.out.println("Intersection is: ");
        Intersection(arr1, arr2);
    }

    private static void Intersection(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            }
        }
    }

    private static void Union(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            } else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j] + " ");
                j++;
            } else if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            System.out.print(arr1[i] + " ");
            i++;
        }
        while (j < arr2.length) {
            System.out.print(arr2[j] + " ");
            j++;
        }
    }
}

