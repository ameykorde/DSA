
# Problem: Finding the Largest Palindromic Substring in Java

## Question:
Write a Java function to find the longest palindromic substring in a given string. A palindrome is a word, phrase, or sequence that reads the same forwards and backwards.

### Problem Explanation:
Given a string `str`, the goal is to find the longest substring within `str` that is a palindrome.

### Example 1:
**Input**: 
```
babad
```
**Output**: 
```
bab
```
**Explanation**: "bab" is the longest palindromic substring in "babad". "aba" is also a valid answer.

### Example 2:
**Input**: 
```
cbbd
```
**Output**: 
```
bb
```

## Solution Approaches

### 1. Brute Force Approach (O(n³) time)
This approach generates all possible substrings and checks if each one is a palindrome.

#### Code Implementation:
```java
import java.util.*;

class Palindrome {
    public static void main(String args[]) {
        int maxLength = 0;
        String maxString = "";
        System.out.print("Enter the String : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    String substring = str.substring(i, j + 1);
                    if (isPalindrome(substring)) {
                        if (substring.length() > maxLength) {
                            maxLength = substring.length();
                            maxString = substring;
                        }
                    }
                }
            }
        }
        System.out.print("Longest Palindromic Substring: " + maxString);
    }

    public static boolean isPalindrome(String str) {
        int j = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
```

### Time Complexity of Current Approach:
- **Generating substrings**: O(n²)
- **Palindrome Check**: O(n)
- Overall: **O(n³)**

### 2. Expand Around Center (O(n²) time, O(1) space)
This method expands around each character and each pair of characters to check for the longest palindrome.

#### Code Implementation:
```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // Even-length palindromes
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
```

### Time Complexity:
- **Time**: O(n²)
- **Space**: O(1)

### 3. Dynamic Programming (O(n²) time, O(n²) space)
This method uses a 2D table to store whether a substring is a palindrome. It is also O(n²) in time but uses additional space and may be more intuitive for some.

#### Code Implementation:
```java
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true; // Every single character is a palindrome
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (length == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (length > maxLength) {
                            start = i;
                            maxLength = length;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}
```

### Time Complexity:
- **Time**: O(n²)
- **Space**: O(n²)

## Why These Approaches Are Better:
- **Expand Around Center** is more efficient in practice with O(n²) time complexity and requires constant extra space (O(1)).
- **Dynamic Programming** is also O(n²) in time but requires O(n²) space, making it less space-efficient but easier to understand for some.

### Conclusion:
The **Expand Around Center** approach is the most efficient in terms of space, while **Dynamic Programming** provides a more intuitive solution for some problems at the cost of additional space.
```

This `.md` file now includes the **Dynamic Programming** approach along with your initial approach and the **Expand Around Center** approach, offering a comprehensive explanation of each method and why they might be chosen.