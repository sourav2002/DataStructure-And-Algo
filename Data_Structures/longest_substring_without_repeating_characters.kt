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


class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val mm = HashMap<Char, Int>()
        var ans = 0
        var last = -1
        for (i in s.indices) {
            last = Math.max(last, mm.getOrElse(s[i], {-1}))
            ans = Math.max(ans, i - last)
            mm[s[i]] = i
        }
        return ans
    }
}