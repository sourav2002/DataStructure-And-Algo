package Matrix;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/*
Merge Overlapping Sub-intervals
Problem Statement: Given an array of intervals, merge all the overlapping intervals and
return an array of non-overlapping intervals.
Example 1:
Input: intervals=[[1,3],[2,6],[8,10],[15,18]]

Output: [[1,6],[8,10],[15,18]]

Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
 intervals.
 */
public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        int [][] intervals = {{1,3},{2,6}, {8,10}, {8,9}, {9,11},{15,18},{2,4},{16,17}};
        int[][] result = merge(intervals);
        System.out.println(Arrays.deepToString(result)); // Arrays.deepToString method is used to print 2D array
    }

    public static int[][] merge(int[][] intervals){
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0 || intervals == null){
            return result.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a,b) ->a[0] - b[0]); // lambda expression
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] i : intervals){
            if (i[0] <= end){
                end = Math.max(end, i[1]);
            }else {
                result.add(new int[]{start,end});
                start = i[0];
                end = i[1];
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[0][]);

    }
}
/*
we are given an interval. we declare a list of array and after that we will check weather if we are given an empty array
interval or null interval, in that case we simply return an empty interval. After that we sorted the interval
then what we do is we take a start and end, then we lineally iterate in the intervals, now we know how to check if
it lies in the interval or not. if 2,4 lies in 1,3 means this 2 has been less than 3, now whenever they are merging we
simply do a merge. we take the right maximum of both the interval that we are trying to merge and just in case they
are not merging what we do here is add it to our data structure now once we are merged all the overlapping sub-intervals
we convert it into a array and return it.
 */
