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

#include <algorithm>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool checkRepetition(string& s, int start, int end) {
    vector<int> chars(128);

    for (int i = start; i <= end; i++) {
        char c = s[i];
        chars[c]++;
        if (chars[c] > 1) {
            return false;
        }
    }

    return true;
}

int lengthOfLongestSubstring(string s) {
    int n = s.length();

    int res = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (checkRepetition(s, i, j)) {
                res = max(res, j - i + 1);
            }
        }
    }

    return res;
}


int main() {
    // Your code goes here;
    string s = "Hello";
    cout << lengthOfLongestSubstring(s) << endl;
    return 0;
}