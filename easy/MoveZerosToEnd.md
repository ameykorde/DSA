
# Push Zeros to End

**Difficulty:** Easy  
**Points:** 2

## Question
You are given an array of integers where some elements are `0`. Your task is to move all zeros to the end of the array while maintaining the order of non-zero elements. You must do this in-place and minimize the number of operations.

### Example:

#### Example 1:
Input: 
```
arr[] = {1, 0, 2, 0, 3, 0, 4}
```
Output: 
```
arr[] = {1, 2, 3, 4, 0, 0, 0}
```

#### Example 2:
Input: 
```
arr[] = {0, 1, 0, 3, 12}
```
Output: 
```
arr[] = {1, 3, 12, 0, 0}
```

## Approach
The idea is to traverse the array once and move all non-zero elements to the front of the array while maintaining their order. After all non-zero elements are moved, we fill the remaining positions with zeros.

We maintain an index to track the position where the next non-zero element should be placed. After processing all non-zero elements, any remaining positions are filled with zeros.

## Solution

### Code
```java
void pushZerosToEnd(int[] arr) {
    int index = 0;  // Index to track position of non-zero elements

    // Traverse the array
    for (int i = 0; i < arr.length; i++) {
        // If the current element is non-zero, move it to the `index` position
        if (arr[i] != 0) {
            arr[index++] = arr[i];
        }
    }

    // After all non-zero elements are moved, fill the remaining positions with zeros
    while (index < arr.length) {
        arr[index++] = 0;
    }
}
```

### Explanation:
1. Start by initializing an `index` variable at `0`, which will keep track of where the next non-zero element should go.
2. Iterate through the array. For each non-zero element, place it at the `index` and increment the `index`.
3. Once all non-zero elements are placed, set all remaining positions in the array to `0` starting from the `index`.

### Example Walkthrough:
For the input `arr[] = {1, 0, 2, 0, 3, 0, 4}`:
- Start with `index = 0`.
- At `i = 0`, `arr[0] = 1` is non-zero, so place it at `index = 0`, increment `index`.
- At `i = 2`, `arr[2] = 2` is non-zero, so place it at `index = 1`, increment `index`.
- At `i = 4`, `arr[4] = 3` is non-zero, so place it at `index = 2`, increment `index`.
- At `i = 6`, `arr[6] = 4` is non-zero, so place it at `index = 3`, increment `index`.
- Now, fill the remaining positions with zeros.

Final array: `{1, 2, 3, 4, 0, 0, 0}`.

## Time Complexity
- **Time Complexity:** `O(n)` where `n` is the size of the array, since we are only traversing the array once.

## Space Complexity
- **Auxiliary Space:** `O(1)` as we are modifying the array in-place and not using any extra space.
```

This `.md` file provides a structured explanation of the problem, approach, solution, and complexity analysis.