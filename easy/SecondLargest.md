# Problem: Find the Second Largest Distinct Element in an Array

## Question

Given an array `arr`, return the second largest distinct element from the array. If the second largest element doesn't exist, then return `-1`.

### Examples:

- **Input**: `arr = [12, 35, 1, 10, 34, 1]`
  - **Output**: `34`
  - **Explanation**: The largest element of the array is `35` and the second largest element is `34`.

- **Input**: `arr = [10, 10]`
  - **Output**: `-1`
  - **Explanation**: The largest element of the array is `10` and the second largest element does not exist, so the answer is `-1`.

### Expected Time Complexity:
- O(n)

### Expected Auxiliary Space:
- O(1)

---

## Approach

To find the second largest distinct element in the array, we can follow a simple linear scan approach using two variables:

1. **Initialize Variables**:
   - `first`: This variable will hold the largest distinct element found so far. Initialize it to a very small value (`Integer.MIN_VALUE`).
   - `second`: This variable will hold the second largest distinct element found so far. Initialize it to a very small value (`Integer.MIN_VALUE`).

2. **Iterate through the Array**:
   - For each element in the array, perform the following checks:
     - If the current element is greater than `first`, then update `second` to be the current value of `first`, and update `first` to be the current element.
     - If the current element is not greater than `first` but is greater than `second` and not equal to `first`, then update `second` to the current element.

3. **Check the Result**:
   - After iterating through the array, if `second` remains unchanged from its initial value, it means there was no second largest distinct element, so return `-1`. Otherwise, return `second`.

---

## Solution in Java

```java
public class Solution {
    public static int secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        
        return (second == Integer.MIN_VALUE) ? -1 : second;
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 35, 1, 10, 34, 1};
        System.out.println(secondLargest(arr1));  // Output: 34

        int[] arr2 = {10, 10};
        System.out.println(secondLargest(arr2));  // Output: -1
    }
}
