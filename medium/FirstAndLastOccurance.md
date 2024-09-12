
# Find First and Last Occurrence of an Element

## Problem Description
You are given an array `arr[]` of size `n` and a number `x`. You need to find the **first** and **last** occurrence of `x` in the array. If `x` is not present, return `[-1, -1]`.

### Input:
- An integer array `arr[]` of size `n`.
- An integer `x` which needs to be searched in the array.

### Output:
- Return an ArrayList containing two integers: the first and last occurrence of `x` in the array. If `x` is not found, return `[-1, -1]`.

### Examples:

#### Example 1:
```
Input: arr[] = [1, 2, 2, 2, 3, 4], n = 6, x = 2
Output: [1, 3]
Explanation: The first occurrence of 2 is at index 1 and the last occurrence is at index 3.
```

#### Example 2:
```
Input: arr[] = [5, 7, 7, 8, 8, 10], n = 6, x = 6
Output: [-1, -1]
Explanation: 6 is not present in the array, so return [-1, -1].
```

## Expected Time Complexity:
- **O(n)**: The solution involves scanning the array twice, so the overall time complexity is linear.

## Expected Space Complexity:
- **O(1)**: Only a few extra variables are used, so space complexity is constant.

## Approach:
1. **First Occurrence**: 
   - Iterate over the array from the start to find the first occurrence of `x`.
   - If found, store the index in the `first` variable.
   - If `x` is not found by the end of the loop, return `[-1, -1]`.

2. **Last Occurrence**:
   - If the first occurrence is found, iterate from the end of the array to find the last occurrence of `x`.
   - Store this index in the `last` variable.

3. **Return the Output**:
   - If `x` is found, return the indices of the first and last occurrence.
   - Otherwise, return `[-1, -1]`.

## Solution Code in Java:
```java
import java.util.ArrayList;

class GFG {
    ArrayList<Integer> find(int arr[], int n, int x) {
        ArrayList<Integer> output = new ArrayList<>();
        int first = -1, last = -1;

        // Finding first occurrence of x
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                first = i;
                break;
            }
        }

        // If the element is not found, return [-1, -1]
        if (first == -1) {
            output.add(-1);
            output.add(-1);
            return output;
        }

        // Finding last occurrence of x
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == x) {
                last = i;
                break;
            }
        }

        output.add(first);
        output.add(last);
        return output;
    }
}
```

## Edge Cases:
- If `x` is not present in the array, return `[-1, -1]`.
- If `x` occurs only once in the array, both the first and last occurrence will be the same index.
