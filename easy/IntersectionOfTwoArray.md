
# Intersection of Two Arrays

**Difficulty:** Easy

## Problem Statement

Given two arrays `arr1` and `arr2`, the task is to find the intersection of these two arrays. The intersection is defined as the common elements that appear in both arrays. The result should not contain duplicates and should be returned as a list.

### Example:

#### Example 1:
Input:
```
arr1 = [1, 2, 2, 1]
arr2 = [2, 2]
```

Output:
```
[2]
```

#### Example 2:
Input:
```
arr1 = [4, 9, 5]
arr2 = [9, 4, 9, 8, 4]
```

Output:
```
[4, 9]
```

### Constraints:
- The lengths of the arrays can be at most `10^5`.
- The elements in the arrays can range from `-10^9` to `10^9`.

## Approach

To find the intersection of two sorted arrays, we can use a two-pointer technique:
1. Initialize two pointers, `i` for `arr1` and `j` for `arr2`, both starting at 0.
2. Traverse both arrays using these pointers:
   - If the elements at both pointers are equal, add the element to the result list if it is not already present.
   - If the element in `arr1` is smaller, move the pointer `i` forward.
   - If the element in `arr2` is smaller, move the pointer `j` forward.
3. Continue this process until we have traversed one of the arrays completely.

### Steps:
1. Create an empty `ArrayList` to store the result.
2. Use a loop to compare elements at both pointers until one of them reaches the end of the corresponding array.
3. Add the element to the result if it is found in both arrays and ensure no duplicates are added.

### Code:

```java
import java.util.ArrayList;

class Solution {
    // Function to return a list containing the intersection of two arrays.
    static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        // Initialize two pointers for both arrays
        for (int i = 0, j = 0; i < arr1.length && j < arr2.length; ) {
            if (arr1[i] == arr2[j]) {
                // Check for duplicates
                if (arr.isEmpty() || arr1[i] != arr.get(arr.size() - 1)) {
                    arr.add(arr1[i]);
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return arr;
    }
}
```

### Explanation:

1. **Two-Pointer Technique**: This solution uses two pointers to traverse both arrays, ensuring that we efficiently find the intersection.
2. **Handling Duplicates**: Before adding an element to the result, we check if it is already present to avoid duplicates.
3. **Incrementing Pointers**: Depending on the comparison of the elements, we increment the appropriate pointer to continue the traversal.

### Time Complexity:
- The time complexity is **O(n + m)**, where `n` is the length of `arr1` and `m` is the length of `arr2`. We traverse each array once.

### Space Complexity:
- The space complexity is **O(k)**, where `k` is the number of unique elements in the intersection.

## Summary:
- This solution efficiently finds the intersection of two sorted arrays using the two-pointer technique while ensuring that no duplicate elements are included in the result.
