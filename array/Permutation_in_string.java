package array;
/*
567. Permutation in String  [Medium]
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
 */
public class Permutation_in_string {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            if (i - len1 >= 0) count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private static boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}

/*
So we will be using SLIDING WINDOW APPROACH to find such a window in s2 in which the freq of characters is same as s1.
Algorithm:
1. The first step is to find the freq of all characters of s1. So create an array of size 26 to store freq of            characters using for loop

2. Now run one more for loop but this time in s2 from 0 to n. Decrease the freq of char while i < k(s1.length).
   if (i - k >=0) then increase the freq of at index (i - k)

3. Now check if count has all zeros or not if yes then return true else return false.

Dry run -
s1 = ab
s2 = cieabdc

step 1 - count[1,1,0,0....0] --> s1 contains a and b having indexes 0 and 1
step 2 - (while i - k ) where k = s1.length(), which is 2. So decrease  freq of ci in count array and check step 3
         count[1, 1, -1, 0, 0, 0, 0, 0, -1, 0...0]
         .     a  b   c                  i   (position of c and i)

         now when i == 2, charAt(2) = 'e', so decrement freq of e. if(i - k >= 0) is true, charAt(i-k) -->     .            charAt(2-2) --> 'c'  increase the freq of c and check step 3
         count[1, 1, (0), 0, (-1), 0, 0, 0, -1, 0...0]
         .     a  b   c        e             i

         i == 3, charAt(3) = 'a' so decrement freq of a. if(i-k>=0) --> charAt(3-2) --> 1--> 'i' incr freq of i
         and check step 3
          count[(0), 1, 0, 0, -1, 0, 0, 0, (0), 0...0]
         .      a  b  c      e            i

         ...........continue

*/
