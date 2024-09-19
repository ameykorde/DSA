
# Floor and Ceil of a Number in a Sorted Array

## Problem Statement

Given a number `x` and a sorted array `arr[]` of integers, find the **floor** and **ceil** of `x` from the array. 
- **Floor** is defined as the largest element in the array that is smaller than or equal to `x`.
- **Ceil** is defined as the smallest element in the array that is greater than or equal to `x`.

Return both floor and ceil as an array `[floor, ceil]`. If no valid floor or ceil exists, return `-1` for the missing value.

### Example 1

```java
Input: x = 5, arr[] = {1, 2, 8, 10, 10, 12, 19}
Output: [2, 8]
Explanation: Floor of 5 is 2 and Ceil of 5 is 8.
```

### Example 2

```java
Input: x = 20, arr[] = {1, 2, 8, 10, 10, 12, 19}
Output: [19, -1]
Explanation: Floor of 20 is 19 and there is no Ceil for 20 in the array.
```

## Expected Complexity

- **Time Complexity**: `O(n)` where `n` is the size of the array.
- **Space Complexity**: `O(1)` as no extra space is used apart from storing the floor and ceil values.

## Approach

To find the **floor** and **ceil** in a sorted array, iterate through the array while checking:
1. If the current element is less than or equal to `x` and greater than the current `floor`, update the floor.
2. If the current element is greater than or equal to `x` and less than the current `ceil`, update the ceil.

### Steps:

1. Initialize `floor` and `ceil` to `-1` indicating that no valid floor or ceil has been found.
2. Iterate through the array:
   - If `arr[i] <= x`, update the floor.
   - If `arr[i] >= x`, update the ceil.
3. Return the result as an array `[floor, ceil]`.

## Code Implementation

```java
class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // Initialize floor and ceil
        int floor = -1, ceil = -1;

        for (int i = 0; i < arr.length; i++) {
            // Check for floor (largest value <= x)
            if (arr[i] <= x && (floor == -1 || arr[i] > floor)) {
                floor = arr[i];
            }
            // Check for ceil (smallest value >= x)
            if (arr[i] >= x && (ceil == -1 || arr[i] < ceil)) {
                ceil = arr[i];
            }
        }
        
        return new int[]{floor, ceil};
    }
}
```

## Example Walkthrough

### Example 1

```java
Input: x = 5, arr[] = {1, 2, 8, 10, 10, 12, 19}
```
1. Iterate through the array:
   - For `arr[0] = 1`, it is less than `x`, so update `floor = 1`.
   - For `arr[1] = 2`, it is less than `x`, so update `floor = 2`.
   - For `arr[2] = 8`, it is greater than `x`, so update `ceil = 8`.
   - The remaining elements are larger, so no further updates.
2. Output: `[2, 8]`.

### Example 2

```java
Input: x = 20, arr[] = {1, 2, 8, 10, 10, 12, 19}
```
1. Iterate through the array:
   - For `arr[5] = 19`, it is less than `x`, so update `floor = 19`.
   - No element in the array is greater than or equal to `x`, so `ceil = -1`.
2. Output: `[19, -1]`.

## Edge Cases

1. **x smaller than all elements**: 
   - If `x` is smaller than all elements in the array, `floor` will be `-1` and `ceil` will be the smallest element.
   
2. **x greater than all elements**: 
   - If `x` is greater than all elements, `floor` will be the largest element and `ceil` will be `-1`.

3. **x matches an element in the array**: 
   - If `x` matches an element in the array, both `floor` and `ceil` will be equal to `x`.

## Conclusion

This approach efficiently finds the floor and ceil in a sorted array using a single pass through the array. The solution has a time complexity of `O(n)` and a space complexity of `O(1)`.
