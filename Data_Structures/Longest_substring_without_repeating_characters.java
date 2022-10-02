/*  Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. */

import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
 
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
 
        return res;
    }
 
    private boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];
 
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        // Your code goes here
        Main ob = new Main();
        String s = "Hello";
        System.out.println(ob.lengthOfLongestSubstring(s));
    }
}