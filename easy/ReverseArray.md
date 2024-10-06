
# Reverse an Array

**Difficulty:** Easy

## Problem Statement

You are given an array of integers, and your task is to reverse the array in place. The goal is to modify the original array such that the elements are in reverse order.

### Example:

#### Example 1:
Input:
```
arr = [1, 2, 3, 4, 5]
```

Output:
```
arr = [5, 4, 3, 2, 1]
```

Explanation:
The original array `[1, 2, 3, 4, 5]` is reversed to `[5, 4, 3, 2, 1]`.

#### Example 2:
Input:
```
arr = [10, 20, 30, 40]
```

Output:
```
arr = [40, 30, 20, 10]
```

Explanation:
The original array `[10, 20, 30, 40]` is reversed to `[40, 30, 20, 10]`.

### Constraints:
- 1 <= arr.length <= 10^5
- -10^9 <= arr[i] <= 10^9

## Approach

The approach to reversing an array is straightforward:
1. Use two pointers: one starting from the beginning (`low`) and one from the end (`high`) of the array.
2. Swap the elements at these two pointers.
3. Increment `low` and decrement `high` until `low` is no longer less than `high`.

### Steps:
1. Initialize two pointers: `low` to 0 and `high` to `arr.length - 1`.
2. Use a `while` loop to swap elements at the `low` and `high` indices.
3. Continue swapping until the `low` pointer crosses the `high` pointer.

### Code:

```java
class Solution {
    public void reverseArray(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        
        // Reverse the array by swapping elements at low and high
        while (low < high) {
            // Swap elements
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            
            // Move pointers towards the center
            low++;
            high--;
        }
    }
}
```

### Explanation:

1. **Two-Pointer Technique**: We use two pointers: `low` starts from the beginning and `high` starts from the end.
2. **Swapping**: We swap the elements at `low` and `high` to reverse the array.
3. **Pointer Update**: After each swap, we increment `low` and decrement `high` to move towards the center of the array.

### Time Complexity:
- The time complexity is **O(n)**, where `n` is the length of the array. We perform a single pass through half of the array (each element is swapped once).

### Space Complexity:
- The space complexity is **O(1)** since we are modifying the array in place without using any extra space.
