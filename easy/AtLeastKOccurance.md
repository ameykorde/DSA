
# Problem: First Element Occurring At Least K Times

## Question:
Given an array of `n` integers, return the first element that occurs at least `k` number of times.

- If no such element exists, return `-1`.

## Examples:

### Example 1:
**Input**:
```
n = 7
k = 2
arr = [1, 7, 4, 3, 4, 8, 7]
```
**Output**:
```
4
```
**Explanation**:
Both `4` and `7` occur twice, but `4` is the first element that occurs at least `k` times.

### Example 2:
**Input**:
```
n = 10
k = 3
arr = [3, 1, 3, 4, 5, 1, 3, 3, 5, 4]
```
**Output**:
```
3
```
**Explanation**:
`3` is the only number that appears at least 3 times in the array.

### Example 3:
**Input**:
```
n = 3
k = 10
arr = [10, 8, 2]
```
**Output**:
```
-1
```
**Explanation**:
No element occurs at least 10 times, so the output is `-1`.

## Constraints:
- `1 <= n <= 10^4`
- `1 <= k <= 100`
- `0 <= arr[i] <= 200`

## Expected Time Complexity:
- **O(n)**: We iterate through the array once.

## Expected Auxiliary Space:
- **O(n)**: We use a `HashMap` to store the frequency of elements.

## Approach:
1. **Use a `HashMap` to Count Occurrences**:
   - Traverse the array and for each element, update its frequency count in the `HashMap`.
2. **Check for the First Element with Frequency >= k**:
   - As soon as an element's frequency reaches `k`, return that element.
3. **Return `-1` if No Such Element Exists**:
   - If no element occurs at least `k` times, return `-1`.

## Solution:

### Code:
```java
import java.util.HashMap;

class Solution {
    public int firstElementKTime(int n, int k, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Traverse the array and count occurrences of each element
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            
            // Check if the current element has appeared at least k times
            if (map.get(arr[i]) == k) {
                return arr[i];
            }
        }
        
        // If no element appears k times, return -1
        return -1;
    }
}
```

## Time Complexity:
- **O(n)**: The array is traversed once, and each insertion in the `HashMap` takes constant time.

## Space Complexity:
- **O(n)**: We use a `HashMap` to store the frequency of each element in the array.

```

This `.md` file includes the problem description, example cases, approach, and the complete solution code with time and space complexity explanations. Let me know if you need any changes!