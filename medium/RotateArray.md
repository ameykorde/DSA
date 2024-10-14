
# Rotate Array by d Elements

## Problem Statement

Given an array, rotate it by `d` elements in a counter-clockwise direction.

### Example

**Input:**
```plaintext
arr[] = {7, 3, 9, 1}, d = 9
```

**Output:**
```plaintext
3 9 1 7
```

### Explanation
When we rotate the array 9 times, the resultant array will be `[3, 9, 1, 7]`.

---

## Original Code

```java
import java.util.ArrayList;

class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // Edge case: if d is 0, no need to rotate
        if (d == 0) {
            return;
        }
        
        // Adjusting the number of rotations in case d > arr.length
        d = d % arr.length;
        
        // Create a temporary array to store the first d elements
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            a.add(arr[i]);
        }
        
        // Shift the remaining elements in the array to the left
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }

        // Move the elements from the temporary array 'a' to the end of the array
        int j = arr.length - d;
        for (int i = 0; i < a.size(); i++) {
            arr[j++] = a.get(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 1};
        int d = 9;
        rotateArr(arr, d);

        // Print rotated array
        for (int i : arr) {
            System.out.print(i + " ");
        }
        // Expected output: 3 9 1 7
    }
}
```

---

## Optimized Code

Here’s an optimized version of the code that avoids using an additional data structure and reduces the time complexity:

```java
class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        int n = arr.length;

        // Adjusting the number of rotations in case d > arr.length
        d = d % n;

        // Edge case: if d is 0, no need to rotate
        if (d == 0) {
            return;
        }

        // Reverse the first d elements
        reverse(arr, 0, d - 1);
        // Reverse the remaining elements
        reverse(arr, d, n - 1);
        // Reverse the whole array
        reverse(arr, 0, n - 1);
    }

    // Helper function to reverse a portion of the array
    static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 1};
        int d = 9;
        rotateArr(arr, d);

        // Print rotated array
        for (int i : arr) {
            System.out.print(i + " ");
        }
        // Expected output: 3 9 1 7
    }
}
```

### Explanation of Optimized Approach

1. **Reverse the first `d` elements.**
2. **Reverse the remaining elements.**
3. **Reverse the entire array.**

This approach has a time complexity of \( O(n) \) and avoids using extra space for an additional array, making it more efficient.