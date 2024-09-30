
# Find Step Key Index in Step Array

**Difficulty:** Easy  
**Accuracy:** 57.91%  
**Submissions:** 49K+  
**Points:** 2

## Question
Given a step array `arr[]`, its step value `k`, and a key `x`, find the index of the first occurrence of `x` in the array `arr[]`. If the key doesn't exist, return `-1`. A step array is an array of integers where the difference between adjacent elements is at most `k`.

### Examples:

#### Example 1:
Input: 
```
arr[] = [4, 5, 6, 7, 6], k = 1, x = 6
```
Output: 
```
2
```
Explanation: The value `6` is first found at index `2`, so the output is `2`.

#### Example 2:
Input: 
```
arr[] = [20, 40, 50], k = 20, x = 70
```
Output: 
```
-1
```
Explanation: The value `70` is not present in the array, so the output is `-1`.

## Approach
The step property of the array allows us to efficiently jump over unnecessary elements during the search. Instead of checking every element, we calculate a jump based on the difference between the current element and the target key `x`. The jump size is `abs(arr[i] - x) / k`, which moves the index forward by a significant amount, making the search more efficient.

## Solution

### Code
```java
public int findStepKeyIndex(int[] arr, int k, int x) {
    int i = 0;
    while (i < arr.length) {
        // If the key is found, return the index
        if (arr[i] == x) {
            return i;
        }
        // Calculate the jump based on the difference between arr[i] and x
        int jump = Math.max(1, Math.abs(arr[i] - x) / k);
        // Move the index forward by the calculated jump
        i += jump;
    }
    // If the key is not found, return -1
    return -1;
}
```

### Explanation:
1. Start at index `i = 0`.
2. If `arr[i] == x`, return `i` (we found the key).
3. Otherwise, calculate the jump as `Math.max(1, abs(arr[i] - x) / k)`.
4. Move `i` forward by the jump value.
5. If the key is not found after checking all relevant indices, return `-1`.

### Example Walkthrough:
For the input `arr[] = [4, 5, 6, 7, 6], k = 1, x = 6`:
- Start at `i = 0`, `arr[0] = 4`.
  - Calculate the jump: `jump = Math.max(1, abs(4 - 6) / 1) = 2`.
  - Move `i = 0 + 2 = 2`.
- Now, `i = 2`, `arr[2] = 6`.
  - `arr[2] == x`, so return `2`.

## Time Complexity
- **Time Complexity:** `O(n)`  
  In the worst case, we need to visit every element in the array at least once.

## Space Complexity
- **Auxiliary Space:** `O(1)`  