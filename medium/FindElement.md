
# Find Two Elements (Repeating and Missing)

### Problem:
Given an array `arr[]` of size `n` that contains numbers from 1 to `n`, where one number is missing, and one number is repeating. The task is to find both the missing and the repeating numbers.

### Examples:
**Example 1:**
- Input: `arr[] = [1, 3, 3, 4, 5]`
- Output: `[3, 2]`  
  Explanation: `3` is the repeating element and `2` is the missing element.

**Example 2:**
- Input: `arr[] = [2, 2]`
- Output: `[2, 1]`  
  Explanation: `2` is the repeating element and `1` is the missing element.

### Approach:
The solution follows an approach that:
1. **Sorts the array**: Sorting will place all the elements in order, allowing us to easily detect the missing and repeating numbers.
2. **Detects repeating element**: Once sorted, if any element is repeated, it will be adjacent to the same number (i.e., `arr[i] == arr[i - 1]`).
3. **Detects missing element**: As we iterate over the sorted array, we expect numbers from `1` to `n`. If the actual element doesn't match the expected number, we find the missing number.

### Steps:
1. **Sorting**: First, we sort the input array in ascending order.
2. **Check for repeating and missing**: 
   - For repeating elements: If an element appears twice in the sorted array, it's the repeating one.
   - For missing elements: If the current element doesn't match the expected sequence (i.e., `1, 2, 3,...`), then the expected number is the missing one.
3. **Edge Case**: After the loop, check if the last number `n` is missing by comparing it with the last element in the sorted array.

### Time and Space Complexity:
- **Time Complexity**: 
  - Sorting takes **O(n log n)**.
  - Traversing through the array to find the elements takes **O(n)**.
  - Overall time complexity is **O(n log n)**.
  
- **Space Complexity**: **O(1)** as only a fixed amount of space is used (an output array of size 2).

### Code Implementation:

```java
import java.util.Arrays;

class Solve {
    int[] findTwoElement(int arr[]) {
        // Array to store the result
        int[] a = new int[2];  // a[0] for repeating, a[1] for missing

        // Sort the array
        Arrays.sort(arr);

        int j = 1;  // Expected number to compare against
        for (int i = 0; i < arr.length; i++, j++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                // Found the repeating element
                a[0] = arr[i];
                j--;  // Don't increment the expected value for this case
            } else if (arr[i] != j) {
                // Found the missing element
                a[1] = j;
                j--;  // To keep matching with the current element
            }
        }

        // If the last element is missing
        if (arr[arr.length - 1] != arr.length) {
            a[1] = arr.length;
        }

        return a;
    }
}
```

### Explanation of the Code:
- **Sorting**: We use the `Arrays.sort(arr)` function to sort the array, which takes **O(n log n)** time.
- **Looping**: A single loop iterates through the sorted array and checks for the repeating and missing numbers.
- **Final Check**: We check if the last number is missing after the loop.

### Conclusion:
This solution finds the repeating and missing numbers efficiently using sorting and has a time complexity of **O(n log n)**.