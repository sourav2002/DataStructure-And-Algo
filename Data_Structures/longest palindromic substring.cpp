//problem==5.longest palindromic substring

class Solution {
public:
    string longestPalindrome(string s) {
        if (s.length() <= 1) return s; 
        
        for (int i = 0; i < s.length(); i++) {
            checkPalindrome(i-1, i+1, s);
            checkPalindrome(i-1, i, s);
        }
        return string(&s[mA], &s[mB+1]);
    }
    
    void checkPalindrome(int a, int b, string s) {
        while (b < s.length() && a >= 0 && s[b] == s[a]) {
            if (mB - mA + 1 < b-a+1) { 
                mA = a; mB = b; 
            }
            a--; b++;
        }
    }
    
private:
    int mA;
    int mB;
};
