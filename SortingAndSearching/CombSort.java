package SortingAndSearching;

class CombSort {
    public static void main(String args[]) {
        CombSort ob = new CombSort();
        int array[] = {7, 5, 2, 49, 4, -24, 31, -3, 0, 38};

        ob.sort(array);

        System.out.println("sorted arrayay");

        for (int i = 0; i < array.length; ++i)
            System.out.print(array[i] + " ");

    }

    int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    void sort(int array[]) {
        int n = array.length;

        int gap = n;

        boolean isSwapped = true;

        while (gap != 1 || isSwapped == true) {
            gap = getNextGap(gap);

            isSwapped = false;

            for (int i = 0; i < n - gap; i++) {
                if (array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;

                    isSwapped = true;
                }
            }
        }
    }
}