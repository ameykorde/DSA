
# Segregate Elements in an Array

## Problem Statement

Given an array of integers, the task is to rearrange the array so that all positive numbers appear before all negative numbers. However, the relative order of positive and negative numbers should remain the same as in the original array.

### Examples

#### Example 1:
**Input**: 
```
arr[] = [1, -1, 3, 2, -7, -5, 11, 6]
```

**Output**: 
```
[1, 3, 2, 11, 6, -1, -7, -5]
```

**Explanation**: 
The positive numbers are shifted to the front, maintaining their order, followed by the negative numbers in their original order.

#### Example 2:
**Input**: 
```
arr[] = [-5, 7, -3, -4, 9, 10, -1, 11]
```

**Output**: 
```
[7, 9, 10, 11, -5, -3, -4, -1]
```

**Explanation**: 
Similar to the previous case, positive numbers are shifted to the front, followed by the negative numbers.

## Approach

1. **Create a Temporary Storage**:
   - Create a list to store the results in the required order.
   
2. **First Pass - Collect Positive Numbers**:
   - Iterate through the input array and collect all positive numbers.

3. **Second Pass - Collect Negative Numbers**:
   - After collecting positive numbers, iterate again through the input array and collect all negative numbers.

4. **Modify the Original Array**:
   - Update the original array `arr[]` with the rearranged elements by iterating through the temporary result list.

## Code Implementation

```java
import java.util.ArrayList;

class Solution {
    public void segregateElements(int[] arr) {
        // Your code goes here
        ArrayList<Integer> result = new ArrayList<>();
        
        // First, add all positive numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                result.add(arr[i]);
            }
        }
        
        // Then, add all negative numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                result.add(arr[i]);
            }
        }
        
        // Modify the original array in place
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
    }
}
```

## Time Complexity

- **O(n)**: The array is traversed twice, once for collecting positive numbers and once for negative numbers.

## Auxiliary Space

- **O(n)**: We use an additional list to temporarily store the rearranged elements before modifying the original array.

## Conclusion

This approach ensures that the positive numbers are placed before the negative numbers while maintaining the relative order of all the elements. The time complexity is linear, and the space complexity is linear due to the temporary list.
