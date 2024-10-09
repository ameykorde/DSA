
# Find Transition Point

**Difficulty:** Easy  
**Accuracy:** 37.9%

## Problem Statement

Given a sorted array `arr[]` containing only 0s and 1s, the task is to find the transition point, i.e., the first index where 1 is observed, and before that, only 0s were present. If the array contains no 1s, return `-1`. If the array contains only 1s, return `0`.

### Example 1:
Input:
```
N = 5
arr = [0, 0, 0, 1, 1]
```

Output:
```
3
```

Explanation:
The transition from 0 to 1 happens at index `3`.

### Example 2:
Input:
```
N = 4
arr = [0, 0, 0, 0]
```

Output:
```
-1
```

Explanation:
The array contains no `1`, so the answer is `-1`.

## Constraints:

- 1 ≤ N ≤ 10^6
- `arr[i]` is either `0` or `1`.

## Approach

### Binary Search Approach (O(log N) Time Complexity):
Since the array is sorted and only contains `0`s followed by `1`s, the problem can be solved efficiently using binary search to find the first occurrence of `1`.

### Steps:
1. Initialize two pointers, `low` and `high`, where `low` is the starting index (`0`) and `high` is the last index (`N-1`).
2. While `low` is less than or equal to `high`:
   - Find the middle index `mid = low + (high - low) / 2`.
   - If `arr[mid] == 1`, check if this is the first occurrence of `1` by ensuring that either `mid == 0` or `arr[mid-1] == 0`. If it's the first `1`, return `mid`.
   - If `arr[mid] == 0`, continue searching in the right half of the array by setting `low = mid + 1`.
   - If `arr[mid] == 1`, continue searching in the left half of the array by setting `high = mid - 1`.
3. If no `1` is found, return `-1`.

### Code:

```java
class Solution {
    int transitionPoint(int arr[], int N) {
        int low = 0, high = N - 1;
        
        // Perform binary search to find the transition point
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if the current mid is the first occurrence of 1
            if (arr[mid] == 1) {
                if (mid == 0 || arr[mid - 1] == 0) {
                    return mid;  // Return the transition point
                } else {
                    high = mid - 1;  // Search in the left half
                }
            } else {
                low = mid + 1;  // Search in the right half
            }
        }
        
        // If no transition point is found, return -1
        return -1;
    }
}
```

### Explanation:

- **Binary Search**: We use binary search to efficiently find the first occurrence of `1` in the sorted array. If `arr[mid] == 1`, we check if it is the first occurrence. If `arr[mid] == 0`, we move to the right half.
- **Edge Cases**:
  - If no `1` exists, return `-1`.
  - If the array contains only `1`s, return `0` because the transition starts from the first element.

### Time Complexity:
- **O(log N)**: Since we are using binary search, the time complexity is logarithmic with respect to the size of the array `N`.

### Space Complexity:
- **O(1)**: We are using a constant amount of space.

## Summary:
- This solution uses binary search to efficiently find the transition point where the first `1` occurs in a sorted array containing only `0`s and `1`s.