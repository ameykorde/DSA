# Check Equal Arrays

## Problem Statement

Given two arrays `arr1` and `arr2` of equal size, the task is to find whether the given arrays are equal. Two arrays are said to be equal if both contain the same set of elements, regardless of the order. If there are repetitions, the counts of repeated elements must also be the same for both arrays.

### Example 1

```java
Input: arr1[] = {1, 2, 5, 4, 0}, arr2[] = {2, 4, 5, 0, 1}
Output: true
Explanation: Both arrays can be rearranged to [0, 1, 2, 4, 5].
```
Example 2
```java
Input: arr1[] = {1, 2, 5}, arr2[] = {2, 4, 15}
Output: false
Explanation: `arr1` and `arr2` have only one common value.
```

Sorting:
Sort both arrays. Since two arrays are equal if they have the same elements (regardless of order), sorting helps to align elements for easy comparison.
Comparison:
After sorting, compare each element from both arrays. If any element is different, return false.
Edge Case:
If the arrays have different sizes, they cannot be equal, so return false immediately.

```java
import java.util.Arrays;

class Solution {
    public boolean checkEqualArrays(int[] arr1, int[] arr2) {
        // If the arrays have different lengths, they can't be equal
        if (arr1.length != arr2.length) {
            return false;
        }
        
        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        // Compare elements of both arrays
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        
        // Arrays are equal
        return true;
    }
}
```
Example Walkthrough
Example 1
```java
Input: arr1[] = {1, 2, 5, 4, 0}, arr2[] = {2, 4, 5, 0, 1}
Step 1: Sort both arrays:
arr1 = {0, 1, 2, 4, 5}
arr2 = {0, 1, 2, 4, 5}
Step 2: Compare each element of both arrays:
They are equal, so return true.
Output: true.
```
Example 2
```java
Input: arr1[] = {1, 2, 5}, arr2[] = {2, 4, 15}
Step 1: Sort both arrays:
arr1 = {1, 2, 5}
arr2 = {2, 4, 15}
Step 2: Compare each element:
The arrays differ at index 1 (2 != 4), so return false.
Output: false.
```
Conclusion
This approach provides an efficient solution to check whether two arrays are equal by sorting them and comparing their elements. Sorting simplifies the problem of comparing unordered arrays, and the time complexity is O(n log n) due to the sorting step.