
# Wave Array

## Problem Statement

Given a sorted array `arr[]` of distinct integers, sort the array into a wave-like array **in-place**. In other words, arrange the elements into a sequence such that:

```
arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5]...
```

If there are multiple solutions, return the lexicographically smallest one.

**Note**: The given array is sorted in ascending order, and the function does not need to return anything as the array is modified in-place.

### Examples:

#### Example 1:
**Input:**  
```
n = 5  
arr[] = {1, 2, 3, 4, 5}
```

**Output:**  
```
2 1 4 3 5
```

**Explanation:**  
The array elements after converting into a wave-like array are `2 1 4 3 5`.

#### Example 2:
**Input:**  
```
n = 6  
arr[] = {2, 4, 7, 8, 9, 10}
```

**Output:**  
```
4 2 8 7 10 9
```

**Explanation:**  
The array elements after converting into a wave-like array are `4 2 8 7 10 9`.

---

## Expected Time Complexity:
- **O(n)**

## Expected Space Complexity:
- **O(1)** (In-place sorting)

---

## Solution Approach

The problem can be solved by iterating over the array and swapping adjacent elements in a way that results in a wave-like pattern. Given the array is sorted in ascending order, we can follow these steps to get the desired result:

1. Iterate over the array with a step of 2 (i.e., for every even index).
2. For each even index `i`, swap `arr[i]` with `arr[i+1]` (ensuring `arr[i] >= arr[i+1]`).
3. Since the array is sorted, the swap will guarantee that the wave pattern is formed lexicographically smallest.

### Solution Code (Java):

```java
class Solution {
    public static void convertToWave(int n, int[] arr) {
        // Iterate over the array with a step of 2
        for(int i = 0; i < n - 1; i += 2) {
            // Swap adjacent elements
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }
}
```

### Explanation:
- The array is traversed with a step of `2`, and for every even index, we swap the adjacent element (i.e., `arr[i]` with `arr[i+1]`).
- This ensures that every pair satisfies the wave condition:
  - `arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5]...`

---

### Example Walkthrough:

#### Example 1:
```
Input: {1, 2, 3, 4, 5}
```

- Initial array: `{1, 2, 3, 4, 5}`
- After swapping `arr[0]` and `arr[1]`: `{2, 1, 3, 4, 5}`
- After swapping `arr[2]` and `arr[3]`: `{2, 1, 4, 3, 5}`

Final output: `2 1 4 3 5`

#### Example 2:
```
Input: {2, 4, 7, 8, 9, 10}
```

- Initial array: `{2, 4, 7, 8, 9, 10}`
- After swapping `arr[0]` and `arr[1]`: `{4, 2, 7, 8, 9, 10}`
- After swapping `arr[2]` and `arr[3]`: `{4, 2, 8, 7, 9, 10}`
- After swapping `arr[4]` and `arr[5]`: `{4, 2, 8, 7, 10, 9}`

Final output: `4 2 8 7 10 9`

---

### Time Complexity:
- **O(n)**: The array is traversed only once.

### Space Complexity:
- **O(1)**: The sorting is done in-place, requiring no additional space.

---

