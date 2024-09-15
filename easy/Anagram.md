
# Anagram Check

## Problem Statement

Given two strings `a` and `b`, determine whether they are anagrams of each other. Two strings are considered anagrams if they contain the same characters in the same frequencies, but possibly in a different order.

### Constraints:
- The strings `a` and `b` consist only of lowercase English letters.
- \( 1 \leq \text{length of } a, \text{ length of } b \leq 10^5 \).

---

## Examples

### Example 1:
**Input**:  
```text
a = "listen"
b = "silent"
```
**Output**:  
```text
true
```
**Explanation**:  
The strings `listen` and `silent` contain the same characters with the same frequencies.

---

### Example 2:
**Input**:  
```text
a = "hello"
b = "world"
```
**Output**:  
```text
false
```
**Explanation**:  
The strings `hello` and `world` do not contain the same characters, so they are not anagrams.

---

## Approach 1: Sorting the Strings

### Idea:
If two strings are anagrams, then their sorted forms will be identical. By converting both strings to character arrays, sorting them, and then comparing, we can determine if they are anagrams.

### Steps:
1. Convert both strings into character arrays.
2. Sort both arrays.
3. Compare the sorted arrays.

### Code:
```java
import java.util.Arrays;

class Solution {
    public static boolean isAnagram(String a, String b) {
        // If the lengths are different, they can't be anagrams
        if (a.length() != b.length()) {
            return false;
        }

        // Convert both strings to character arrays
        char[] stra = a.toCharArray();
        char[] strb = b.toCharArray();

        // Sort both arrays
        Arrays.sort(stra);
        Arrays.sort(strb);

        // Compare the sorted arrays
        return Arrays.equals(stra, strb);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent")); // Output: true
        System.out.println(isAnagram("hello", "world"));   // Output: false
    }
}
```

### Time Complexity:
- Sorting both strings takes \( O(n \log n) \), where `n` is the length of the strings.

### Space Complexity:
- \( O(n) \), where `n` is the space required to store the character arrays.

---

## Approach 2: Using Character Frequency Count (Hash Map)

### Idea:
Two strings are anagrams if they have the same character counts for each letter. We can use an array (or hash map) to count the frequency of each character in both strings and then compare the counts.

### Steps:
1. Initialize an array of size 26 (for each lowercase letter) to count the frequency of characters.
2. Traverse both strings and update the frequency array:
   - Increment the count for each character in the first string.
   - Decrement the count for each character in the second string.
3. If the frequency array contains all zeros at the end, the strings are anagrams.

### Code:
```java
class Solution {
    public static boolean isAnagram(String a, String b) {
        // If the lengths are different, they can't be anagrams
        if (a.length() != b.length()) {
            return false;
        }

        // Frequency array for counting letters (26 lowercase English letters)
        int[] charCount = new int[26];

        // Increment for string `a`, decrement for string `b`
        for (int i = 0; i < a.length(); i++) {
            charCount[a.charAt(i) - 'a']++;
            charCount[b.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent")); // Output: true
        System.out.println(isAnagram("hello", "world"));   // Output: false
    }
}
```

### Time Complexity:
- \( O(n) \), where `n` is the length of the strings.

### Space Complexity:
- \( O(1) \), since the frequency array always has a fixed size of 26.

