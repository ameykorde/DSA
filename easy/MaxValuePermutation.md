
# Maximum Sum of ∑arr[i] * i with Rearrangement

**Difficulty:** Medium

## Question

Given an array `arr` of `n` integers, the task is to find the maximum value of the sum:

```
∑ arr[i] * i
```

where `i = 0, 1, 2, ..., n-1`. You are allowed to rearrange the elements of the array to maximize this sum. Since the output could be large, return the answer modulo `10^9 + 7`.

### Example 1:

**Input:**
```
arr[] = [5, 3, 2, 4, 1]
```

**Output:**
```
40
```

**Explanation:**
- If we sort the array in ascending order: `[1, 2, 3, 4, 5]`, then the sum is:
  ```
  0*1 + 1*2 + 2*3 + 3*4 + 4*5 = 0 + 2 + 6 + 12 + 20 = 40
  ```
  Hence, the maximum value is 40.

### Example 2:

**Input:**
```
arr[] = [1, 2, 3]
```

**Output:**
```
8
```

**Explanation:**
- After sorting the array, we get `[1, 2, 3]`, and the sum is:
  ```
  0*1 + 1*2 + 2*3 = 0 + 2 + 6 = 8
  ```

## Approach

To maximize the sum of `∑arr[i] * i`, you need to rearrange the array in such a way that the highest numbers in the array are multiplied by the highest indices.

### Strategy:
- **Sort the array in ascending order**. 
  - By doing this, the smallest element will be multiplied by `0`, the next smallest by `1`, and so on. This ensures that the larger numbers are multiplied by the larger indices.
  
### Steps:
1. Sort the array.
2. Iterate through the array, calculating the sum of `arr[i] * i`.
3. Return the result modulo `10^9 + 7` to handle large numbers.

## Solution

### Code:

```java
import java.util.Arrays;

class Solution {
    public int Maximize(int arr[], int n) {
        int MOD = 1000000007;
        Arrays.sort(arr);  // Sort the array to maximize the product sum
        
        long sum = 0;
        
        // Iterate through the array and calculate the sum
        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * i) % MOD;
        }
        
        return (int) sum;  // Return the sum modulo 10^9 + 7
    }
}
```

### Explanation:
1. **Sorting**: First, the array is sorted in ascending order so that the smallest numbers are assigned the lowest indices and the largest numbers are assigned the highest indices.
2. **Summation**: The sum is calculated using the formula `sum += arr[i] * i`, where `i` is the index of the array.
3. **Modulo Operation**: Since the output could be large, we take the result modulo `10^9 + 7` to avoid overflow.

### Example Walkthrough:

For the input `arr[] = [5, 3, 2, 4, 1]`:
- After sorting, `arr[] = [1, 2, 3, 4, 5]`.
- The sum is calculated as:
  ```
  1*0 + 2*1 + 3*2 + 4*3 + 5*4 = 0 + 2 + 6 + 12 + 20 = 40
  ```

For the input `arr[] = [1, 2, 3]`:
- After sorting, `arr[] = [1, 2, 3]`.
- The sum is calculated as:
  ```
  1*0 + 2*1 + 3*2 = 0 + 2 + 6 = 8
  ```

### Time Complexity:
- Sorting the array takes `O(n log n)`.
- Iterating through the array takes `O(n)`.

Thus, the overall time complexity is **O(n log n)**.

### Space Complexity:
- The space complexity is **O(1)** since we are using constant extra space (excluding the space used by the input array).

## Constraints:
- `1 ≤ n ≤ 10^5`
- `1 ≤ arr[i] ≤ 10^9`