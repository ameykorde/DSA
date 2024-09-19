
# Find the Floor of a Number in a Sorted Array

## Problem Statement

Given a sorted array `arr[]` of size `n` without duplicates, find the floor of a given number `x`. The floor of a number `x` is the largest element in the array smaller than or equal to `x`. Return the index of the floor, or `-1` if it does not exist.

### Example

```java
Input:
arr[] = {1, 2, 4, 6, 10, 12, 14}
x = 7
Output: 3
Explanation: Floor of 7 is 6, and its index is 3.
```

## Approach

We can use a **binary search** approach to efficiently find the floor of a number in a sorted array.

### Steps:
1. **Edge case**: If `x` is smaller than the smallest element in the array, return `-1` as no floor exists.
2. Initialize `low` and `high` pointers to the start and end of the array.
3. Use a binary search to narrow down the search for the floor:
   - If the middle element `arr[mid]` is less than or equal to `x`, update the floor index and move to the right half to find a larger floor.
   - If `arr[mid]` is greater than `x`, move to the left half to find a smaller value.
4. Return the index of the floor element.

## Code Implementation

```java
static int findFloor(long arr[], int n, long x) {
    // Edge case: If x is smaller than the smallest element
    if (arr[0] > x) {
        return -1;  // No floor exists if x is smaller than the smallest element
    }
    
    int low = 0;
    int high = n - 1;
    int index = -1;  // Initialize to -1 to handle the case where no valid floor is found
    
    while (low <= high) {
        int mid = (low + high) / 2;
        
        if (arr[mid] <= x) {
            index = mid;  // Update index since arr[mid] could be the floor
            low = mid + 1;  // Try to find a larger floor by moving right
        } else {
            high = mid - 1;  // Move left to find a smaller value
        }
    }
    
    return index;
}
```

### Time Complexity
- **Time complexity**: `O(log n)` because we are using binary search.
- **Space complexity**: `O(1)` as we are only using a few extra variables.

## Explanation

1. **Edge case handling**: If the given `x` is smaller than the smallest element in the array, there can't be any floor value, so the function returns `-1`.
2. **Binary Search**: The binary search is used to efficiently search the array in `O(log n)` time. The middle element is compared to `x` to decide whether to move left or right in the array.
3. **Floor Update**: Every time a valid floor (i.e., an element smaller than or equal to `x`) is found, the `index` is updated. The search continues to check for a larger floor.

## Example Walkthrough

For the input:
```java
arr[] = {1, 2, 4, 6, 10, 12, 14}
x = 7
```

- Initially, `low = 0`, `high = 6`.
- The mid element is `arr[3] = 6`, which is less than `x`, so update `index = 3` and move `low = mid + 1 = 4`.
- The new mid is `arr[5] = 12`, which is greater than `x`, so move `high = mid - 1 = 4`.
- The new mid is `arr[4] = 10`, which is greater than `x`, so move `high = mid - 1 = 3`.

At this point, `low` becomes greater than `high`, so the loop terminates and the floor index `3` (corresponding to `6`) is returned.

```
Floor of 7 is 6 at index 3.
```

## Edge Cases

- If `x` is smaller than the smallest element in the array, the function returns `-1`.
- If `x` is larger than the largest element, the function will return the index of the largest element.
