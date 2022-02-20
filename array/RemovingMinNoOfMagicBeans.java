package array;

import java.util.Arrays;

/*
2171. Removing Minimum Number of Magic Beans
Medium
You are given an array of positive integers beans, where each integer represents the number of magic beans found in a
particular magic bag.
Remove any number of beans (possibly none) from each bag such that the number of beans in each remaining non-empty bag
(still containing at least one bean) is equal. Once a bean has been removed from a bag, you are not allowed to return
it to any of the bags.
Return the minimum number of magic beans that you have to remove.

Input: beans = [4,1,6,5]
Output: 4
Explanation:
- We remove 1 bean from the bag with only 1 bean.
  This results in the remaining bags: [4,0,6,5]
- Then we remove 2 beans from the bag with 6 beans.
  This results in the remaining bags: [4,0,4,5]
- Then we remove 1 bean from the bag with 5 beans.
  This results in the remaining bags: [4,0,4,4]
We removed a total of 1 + 2 + 1 = 4 beans to make the remaining non-empty bags have an equal number of beans.
There are no other solutions that remove 4 beans or fewer.
 */
public class RemovingMinNoOfMagicBeans {
    public static void main(String[] args) {
        int[] arr = {4,1,6,5};
        System.out.println(minimumRemoval(arr));
    }
    public static long minimumRemoval(int[] beans) {
        long min = Long.MAX_VALUE;
        Arrays.sort(beans);
        long n = beans.length;
        long sum = 0;
        for(long i : beans){
            sum += i;
        }

        for(int i=0; i<n; i++){
            long change = sum - (n - i) * beans[i] * 1L;
            min = Math.min(min, change);
        }
        return min;
    }
}
/*
Sort the original array A.

If we select A[i] as the number of beans in a non-empty bag, the number of removals needed is sum(A) - (N - i) * A[i].
A = [1,4,5,6], sum(A) = 16

If we pick A[0] = 1, the result array is [1,1,1,1], # of removals is 16 - (4 - 0) * 1 = 12.
If we pick A[1] = 4, the result array is [0,4,4,4], # of removals is 16 - (4 - 1) * 4 = 4.
If we pick A[2] = 5, the result array is [0,0,5,5], # of removals is 16 - (4 - 2) * 5 = 6.
If we pick A[3] = 6, the result array is [0,0,0,6], # of removals is 16 - (4 - 3) * 6 = 10.
 */