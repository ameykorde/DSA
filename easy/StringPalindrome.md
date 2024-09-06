# Palindrome Checker

## Problem Statement

Given a string `S`, check if it is a palindrome or not. A palindrome is a string that reads the same backward as forward.

### Example 1:
- **Input:** `S = "abba"`
- **Output:** `1`
- **Explanation:** The string "abba" is a palindrome as it reads the same backward.

### Example 2:
- **Input:** `S = "abc"`
- **Output:** `0`
- **Explanation:** The string "abc" is not a palindrome because it reads "cba" backward.

## Task

You need to implement the function `isPalindrome(String S)` that takes the string `S` as input and returns an integer value `1` if it is a palindrome, otherwise `0`.

---

## Optimized Approach

We can optimize the solution by comparing characters from both ends of the string and moving towards the center. This avoids the need to create a reversed string, saving memory and time.

### Algorithm

1. **Initialize Pointers:**
   - `left` pointer starting at the beginning of the string (`0`).
   - `right` pointer starting at the end of the string (`S.length() - 1`).

2. **Compare Characters:**
   - While `left < right`:
     - Compare `S.charAt(left)` with `S.charAt(right)`.
     - If they are not equal, return `0` (not a palindrome).
     - Increment `left` and decrement `right` to move towards the center.

3. **Return Result:**
   - If all corresponding characters match, return `1` (palindrome).

---

## Solution Code

```java
public class PalindromeChecker {

    /**
     * Checks if the given string S is a palindrome.
     *
     * @param S The input string to check.
     * @return 1 if S is a palindrome, otherwise 0.
     */
    public static int isPalindrome(String S) {
        int left = 0;
        int right = S.length() - 1;
        
        // Compare characters from both ends
        while (left < right) {
            if (S.charAt(left) != S.charAt(right)) {
                return 0;  // Not a palindrome
            }
            left++;
            right--;
        }
        
        return 1;  // Palindrome
    }

    public static void main(String[] args) {
        // Test Cases
        String test1 = "abba";
        String test2 = "abc";
        String test3 = "a";
        String test4 = "racecar";
        String test5 = "";
        String test6 = "Madam"; // Case-sensitive
        String test7 = "A man, a plan, a canal: Panama"; // Includes spaces and punctuation
        String test8 = "あいいあ"; // Unicode characters
        String test9 = "12321";
        String test10 = "@#@";

        System.out.println(isPalindrome(test1));  // Output: 1
        System.out.println(isPalindrome(test2));  // Output: 0
        System.out.println(isPalindrome(test3));  // Output: 1
        System.out.println(isPalindrome(test4));  // Output: 1
        System.out.println(isPalindrome(test5));  // Output: 1
        System.out.println(isPalindrome(test6));  // Output: 0
        System.out.println(isPalindrome(test7));  // Output: 0
        System.out.println(isPalindrome(test8));  // Output: 1
        System.out.println(isPalindrome(test9));  // Output: 1
        System.out.println(isPalindrome(test10)); // Output: 1
    }
}
