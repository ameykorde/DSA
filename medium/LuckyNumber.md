# Lucky Number

## Question:
Write a Java function to determine if a number `N` is a "lucky" number. A number is considered lucky if it survives a deletion process where, in each step, numbers are deleted based on their position.

### Problem Explanation:
Given the set of integers:
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, ...

1. In the first step, every second number is deleted.
2. In the second step, every third number (from the remaining set) is deleted.
3. This process continues indefinitely.

If a number `N` is never deleted in this process, it is considered "lucky."

### Example 1:
**Input**: 
N = 5


**Output**:
0 (False)


**Explanation**: 5 is deleted in the second iteration.

### Example 2:
**Input**: 
N = 19

**Output**:
1 (True)


**Explanation**: 19 survives all rounds and is lucky.

## Solution Approach:
We simulate the deletion process using loops. Starting with deleting every second number, we continue to check if `N` would get deleted in each round. If `N` survives all deletion rounds, it is considered a lucky number.

### Code Implementation (Using Loops):
```java
class Solution {
    public static boolean isLucky(int n) {
        int k = 2; // Start with the second number deletion
        while (k <= n) {
            // If N is divisible by k, it gets deleted in this round
            if (n % k == 0) {
                return false;
            }
            // Update N to reflect its new position after deletions
            n = n - (n / k);
            k++;
        }
        return true; // If we exit the loop, N is lucky
    }
}
```