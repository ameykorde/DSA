
# Finding the Majority Element in an Array

## Initial Approach

### Problem Description
Given an array `arr`, find the majority element in the array. If no majority element exists, return `-1`. A majority element is an element that appears strictly more than `arr.length / 2` times.

### Initial Approach
```java
class Solution {
    static int countOfElement(int n, int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                count++;
                arr[i] = -1232; // Mark element to avoid re-counting
            }
        }
        return count;
    }

    static int majorityElement(int arr[]) {
        int l = arr.length;
        int majorityElement = -1;
        for (int i = 0; i < l && arr[i] != -1232; i++) {
            int count = countOfElement(arr[i], arr);
            if (count > l / 2 && majorityElement < count) {
                majorityElement = arr[i];
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 1, 1, 2, 2, 1, 1};
        System.out.println("Majority Element: " + majorityElement(arr)); // Output should be 1
    }
}
```

### Issues with Initial Approach
1. **Mutation of Array**: Modifying the array elements to mark them (`arr[i] = -1232`) affects the original data and can lead to incorrect results.
2. **Inefficient Checking**: The comparison `majorityElement < count` led to unnecessary checks even after finding the maximum element, which caused inefficiency and failure in some test cases.

## Improved Approach

### Problem Description
The improved approach efficiently finds the majority element without modifying the array.

### Improved Approach
Given the input array `[3, 3, 1, 1, 2, 2, 1, 1]`, let's determine if there's a majority element using the Boyer-Moore Voting Algorithm.

### Example Walkthrough

1. **Finding the Candidate**:
   - Initialize `count = 0` and `candidate = -1`.

   **Iteration 1**:
   - `num = 3`
   - `count = 0`, so `candidate = 3`.
   - Update `count = 1`.

   **Iteration 2**:
   - `num = 3`
   - `num == candidate`, so `count = 2`.

   **Iteration 3**:
   - `num = 1`
   - `num != candidate`, so `count = 1`.

   **Iteration 4**:
   - `num = 1`
   - `num != candidate`, so `count = 0`.

   **Iteration 5**:
   - `num = 2`
   - `count = 0`, so `candidate = 2`.
   - Update `count = 1`.

   **Iteration 6**:
   - `num = 2`
   - `num == candidate`, so `count = 2`.

   **Iteration 7**:
   - `num = 1`
   - `num != candidate`, so `count = 1`.

   **Iteration 8**:
   - `num = 1`
   - `num != candidate`, so `count = 0`.

   After processing the array, the final `candidate` is `2`, with a `count` of `0`.

2. **Verifying the Candidate**:
   - The candidate found was `2`.

   - Count occurrences of `2` in the array:
     - `2` appears `2` times.

   - Length of the array `n = 8`.
   - To be a majority element, the count must be greater than `n / 2`, which is `8 / 2 = 4`.

   - Since `2` appears only `2` times, which is not greater than `4`, it is not a majority element.

### Summary

For the input `[3, 3, 1, 1, 2, 2, 1, 1]`:
- The Boyer-Moore Voting Algorithm finds `2` as the candidate.
- Verification shows that `2` does not meet the majority requirement (appears less than `4` times).

So, the output is `-1`, indicating that there is no majority element in the array.

### Revised Code Example with Verification

Here’s a complete implementation that includes the verification step:

```java
class Solution {
    // Function to find the majority element in the array
    static int majorityElement(int[] arr) {
        int n = arr.length;
        if (n == 0) return -1;

        // Step 1: Find the candidate for majority element
        int candidate = findCandidate(arr);

        // Step 2: Verify the candidate
        if (isMajority(arr, candidate)) {
            return candidate;
        }
        return -1;
    }

    // Function to find the candidate for majority element
    private static int findCandidate(int[] arr) {
        int count = 0;
        int candidate = -1;
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // Function to check if the candidate is the majority element
    private static boolean isMajority(int[] arr, int candidate) {
        int count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }
        return count > arr.length / 2;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 1, 1, 2, 2, 1, 1};
        System.out.println("Majority Element: " + majorityElement(arr)); // Output: -1
    }
}
```

This code will correctly identify that there is no majority element in the given array.