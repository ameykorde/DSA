
# Problem: Remove Duplicates from String

## Question:
Given a string, you need to remove all duplicate characters and return the string with the order of first appearance preserved.

## Approach:

### 1. Using `LinkedHashSet` to Remove Duplicates:
- Use a `LinkedHashSet` to store characters while maintaining the order of their first appearance.
- Iterate over the string and add each character to the `LinkedHashSet`. Since `LinkedHashSet` does not allow duplicates, this will automatically remove them.
- To construct the result string, iterate over the `LinkedHashSet` and append each character.

### 2. Improving String Concatenation with `StringBuilder`:
- Instead of concatenating strings using `+=`, which is inefficient for larger strings due to the immutability of `String`, we use `StringBuilder`.
- `StringBuilder` is mutable and allows efficient string construction, especially when dealing with multiple concatenations.

## Solution:

### Code: Original Approach
```java
import java.util.LinkedHashSet;

class Solution {
    String removeDups(String input) {
        LinkedHashSet<Character> uniqueChars = new LinkedHashSet<>();
        
        // Add each character to the LinkedHashSet
        for (int i = 0; i < input.length(); i++) {
            uniqueChars.add(input.charAt(i));
        }
        
        // Build the resulting string without duplicates
        String result = "";
        for (char ch : uniqueChars) {
            result += ch;
        }
        
        return result;
    }
}
```

### Code: Improved Approach with `StringBuilder`
```java
import java.util.LinkedHashSet;

class Solution {
    String removeDups(String input) {
        // Create a LinkedHashSet to store unique characters in order of appearance
        LinkedHashSet<Character> uniqueChars = new LinkedHashSet<>();
        
        // Add each character to the LinkedHashSet
        for (int i = 0; i < input.length(); i++) {
            uniqueChars.add(input.charAt(i));
        }
        
        // Use StringBuilder for more efficient string concatenation
        StringBuilder result = new StringBuilder();
        for (char ch : uniqueChars) {
            result.append(ch);
        }
        
        return result.toString();
    }
}
```

### Improved Variable Names:
- In both approaches, `s` is renamed to `input` to represent the input string more clearly.
- `str` is renamed to `uniqueChars` to indicate that it stores unique characters.
- In the original approach, `result` is defined as an empty string, and in the improved approach, `result` is defined as a `StringBuilder` to enhance efficiency.

## Time Complexity:
- **O(n)**: Where `n` is the length of the input string.
  - Adding characters to the `LinkedHashSet` takes O(1) on average, making it O(n) for the entire string.
  - Constructing the result string from the `LinkedHashSet` also takes O(n).

## Space Complexity:
- **O(n)**: The `LinkedHashSet` and the `StringBuilder` (or result string) both take space proportional to the number of unique characters in the input string.
