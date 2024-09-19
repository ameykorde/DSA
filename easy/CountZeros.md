
# Count the Zeros in a Sorted Binary Array

## Problem Statement

You are given a sorted binary array `arr[]` consisting of only `0`s and `1`s. The array is sorted such that all the `1`s are placed first, followed by all the `0`s. Your task is to find the **count of all the 0's** in the array.

### Example 1

```java
Input: arr[] = [1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0]
Output: 3
Explanation: There are 3 zeros in the given array.
```

### Example 2

```java
Input: arr[] = [0, 0, 0, 0, 0]
Output: 5
Explanation: There are 5 zeros in the array.
```

## Expected Complexity

- **Time Complexity**: `O(log n)` (binary search approach).
- **Space Complexity**: `O(1)` (constant space).

## Approach

We can solve this problem efficiently using **binary search**. Since the array is sorted, the first occurrence of `0` can be found in `O(log n)` time, and the count of `0`s can be derived from the position of the first `0`.

### Steps:
1. **Edge case**: If the first element is `0`, then all elements are `0`, so return the length of the array.
2. Use **binary search** to find the first occurrence of `0`:
   - If `arr[mid] == 1`, search in the right half of the array.
   - If `arr[mid] == 0`, check if it's the first occurrence, and if so, return the count of zeros as `n - mid` (where `n` is the size of the array).
   - Continue narrowing down the search by adjusting `low` and `high`.
3. If no `0` is found, return `0`.

## Code Implementation

```java
static int countZeros(int arr[], int n) {
    int low = 0;
    int high = n - 1;

    // If the first element is 0, all elements are 0.
    if (arr[0] == 0) {
        return n;
    }

    while (low <= high) {
        int mid = (low + high) / 2;

        // If mid is 0, and it's the first occurrence of 0
        if (arr[mid] == 0 && (mid == 0 || arr[mid - 1] == 1)) {
            return n - mid;  // Count of zeros is total elements - first index of 0
        } else if (arr[mid] == 1) {
            low = mid + 1;  // Search in the right half
        } else {
            high = mid - 1;  // Search in the left half
        }
    }

    // No 0's found
    return 0;
}
```

## Explanation

1. **Binary Search**: The binary search is used to efficiently find the first occurrence of `0` in the array, in `O(log n)` time.
2. **Handling edge cases**: 
   - If the first element in the array is `0`, all elements are `0`, so the total count is returned immediately.
   - If there are no `0`s in the array, the function returns `0`.
3. **Count Calculation**: Once the first `0` is found, the count of `0`s is the difference between the array's length (`n`) and the index of the first `0` (`mid`).

## Example Walkthrough

### Example 1:
```java
arr[] = [1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0]
n = 12
```
- Initial low = 0, high = 11.
- Mid element is `arr[5] = 1`. Since it's `1`, move `low = mid + 1 = 6`.
- Mid element is `arr[8] = 1`. Move `low = mid + 1 = 9`.
- Mid element is `arr[10] = 0`. Check if it's the first `0` (it is, since `arr[9] = 1`), so return `n - mid = 12 - 9 = 3`.

```
Output: 3
```

### Example 2:
```java
arr[] = [0, 0, 0, 0, 0]
n = 5
```
- Since the first element `arr[0] = 0`, return `n = 5`.

```
Output: 5
```

## Edge Cases

1. **All 1's**: If the array contains only `1`s, return `0`.
   ```java
   arr[] = [1, 1, 1, 1]
   Output: 0
   ```
2. **All 0's**: If the array contains only `0`s, return the length of the array.
   ```java
   arr[] = [0, 0, 0, 0]
   Output: 4
   ```

## Conclusion

This approach leverages the sorted nature of the array and uses binary search to find the first occurrence of `0`, ensuring that the time complexity is `O(log n)` and space complexity is `O(1)`. It is a more efficient solution than a linear search.
