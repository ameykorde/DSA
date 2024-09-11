
# Reverse String in Java

This document provides details on how to reverse a string in Java using a `char[]` array and a simple swapping algorithm.

## Problem Statement

We want to reverse a given string. The function should take a string as input and return the reversed version of it.

## Solution

The approach is to convert the input string into a character array (`char[]`), then reverse the array by swapping the characters from both ends of the array. Finally, we convert the reversed character array back to a string and return it.

### Code Implementation

```java
class Reverse
{
    // Function to reverse a given string
    // Input: String str
    // Output: Reversed string
    public static String reverseWord(String str)
    {
        char[] charArray = str.toCharArray(); // Convert string to char array
        int left = 0;
        int right = charArray.length - 1;

        // Swap characters from both ends towards the middle
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        // Convert char array back to string and return
        return new String(charArray);
    }
}
```

### Explanation

1. **Convert to Character Array**:  
   The input string is converted to a `char[]` array using `toCharArray()`.

2. **Initialize Two Pointers**:  
   We set two pointers:  
   - `left`: Points to the first character (`index 0`).  
   - `right`: Points to the last character (`index length - 1`).

3. **Swapping Logic**:  
   Using a `while` loop, we swap the characters at the `left` and `right` pointers, then increment `left` and decrement `right`. This continues until `left` is no longer less than `right`.

4. **Return the Reversed String**:  
   After the loop completes, we convert the `char[]` array back into a string using the `new String()` constructor and return the reversed string.

### Time Complexity

- The time complexity of the function is **O(n)**, where `n` is the length of the input string. This is because we traverse the string only once, swapping characters.
  
### Space Complexity

- The space complexity is **O(n)** due to the creation of the `char[]` array to store the characters of the string.

### Example

#### Input:
```java
String str = "hello";
```

#### Output:
```java
"olleh"
```

### Notes

- The solution handles strings of arbitrary length. If the input string is empty or contains only one character, the function will return it as is.
- This approach uses a two-pointer technique to achieve in-place reversal of the character array, which is efficient in both time and space.