
# Problem: Count Occurrences of a Number in a Sorted Array

### Problem Statement
Given a sorted array `arr[]` of size `n` and an integer `x`, find the number of occurrences of `x` in the array. If `x` is not present, return 0. The solution should be efficient and have a time complexity of `O(log n)`.

### Example 1
Input:
```
arr[] = {1, 2, 2, 2, 3, 4, 5}
x = 2
```
Output:
```
3
```

### Example 2
Input:
```
arr[] = {1, 1, 2, 3, 4, 5}
x = 6
```
Output:
```
0
```

---

### Approach

1. **Binary Search for the First Occurrence**:
   - Perform a binary search to find the first occurrence of `x` in the array.
   - If `arr[mid] == x` and either `mid == 0` or `arr[mid-1] != x`, then this is the first occurrence of `x`.
   - If `arr[mid] > x`, search in the left half. Otherwise, search in the right half.

2. **Binary Search for the Last Occurrence**:
   - Similarly, perform a binary search to find the last occurrence of `x`.
   - If `arr[mid] == x` and either `mid == n-1` or `arr[mid+1] != x`, then this is the last occurrence of `x`.
   - If `arr[mid] > x`, search in the left half. Otherwise, search in the right half.

3. **Calculate the Count**:
   - If `x` is found, return the count as `last - first + 1`. 
   - If `x` is not found, return `0`.

---

### Code Implementation

```java
class Solution {
    int count(int[] arr, int n, int x) {
        // Variables to store the first and last occurrence
        int first = -1, last = -1;
        
        // First binary search to find the first occurrence of x
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr[mid] == x) {
                // Check if it's the first occurrence or if mid is at the start
                if (mid == 0 || arr[mid - 1] != x) {
                    first = mid;
                    break;
                } else {
                    high = mid - 1;  // Continue searching in the left half
                }
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        // If no occurrence of x is found, return 0
        if (first == -1) return 0;
        
        // Second binary search to find the last occurrence of x
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr[mid] == x) {
                // Check if it's the last occurrence or if mid is at the end
                if (mid == n - 1 || arr[mid + 1] != x) {
                    last = mid;
                    break;
                } else {
                    low = mid + 1;  // Continue searching in the right half
                }
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        // Return the count of occurrences
        return (last - first + 1);
    }
}
```

---

### Time Complexity
- **Binary Search for First Occurrence**: `O(log n)`
- **Binary Search for Last Occurrence**: `O(log n)`
- Overall time complexity is `O(log n)`.

---

### Edge Cases
1. If `x` is not present in the array, return `0`.
2. If the array contains all elements equal to `x`, the function should return the total length of the array.
3. If the array contains only one element, handle it correctly.
