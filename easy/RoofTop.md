
## Roof Top Problem

**Difficulty:** Easy  
**Accuracy:** 40.48%  
**Points:** 2

### Problem Statement
You are given the heights of consecutive buildings. You can move from the roof of a building to the roof of the next adjacent building. You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with each step.

### Examples

#### Example 1:
Input:
```
arr[] = [1, 2, 2, 3, 2]
```
Output:
```
1
```
Explanation: The consecutive buildings with increasing heights are:
- 1 -> 2
- 2 -> 3  
Thus, the maximum number of consecutive steps with an increase in altitude is `1` in both cases.

#### Example 2:
Input:
```
arr[] = [1, 2, 3, 4]
```
Output:
```
3
```
Explanation: The consecutive buildings with increasing heights are:
- 1 -> 2 -> 3 -> 4  
Thus, the maximum number of consecutive steps with increasing altitude is `3`.

### Expected Time Complexity:
- O(n)

### Expected Auxiliary Space:
- O(1)

---

## Approach

### Logic:

1. **Initialize Counters:**
   - `count`: To track the current streak of consecutive steps with increasing altitude.
   - `maxCount`: To store the maximum streak of consecutive steps found.

2. **Traverse the Array:**
   - Iterate through the array comparing the current building with the next one.
   - If the next building has a greater height, increment the `count`.
   - If it does not, check if the current streak (`count`) is the longest, update `maxCount`, and reset `count`.

3. **Final Check:**
   - After the loop, ensure to update `maxCount` one last time in case the streak ends at the end of the array.

### Code:

```java
class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    static int maxStep(int arr[]) {
        // Initialize counters
        int count = 0;
        int maxCount = 0;
        
        // Traverse the array
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] >= arr[i+1]) {
                // Update maxCount and reset count when altitude does not increase
                if(count > maxCount)
                    maxCount = count;
                count = 0;
            } else {
                // Increment count for consecutive steps
                count++;
            }
        }
        
        // Final check for the last streak
        if(count > maxCount)
            maxCount = count;
        
        return maxCount;
    }
}

### Dry Run:

#### Example 1:
Input: `arr[] = [1, 2, 2, 3, 2]`
- At index `0`, `1 < 2`, increment `count = 1`
- At index `1`, `2 == 2`, update `maxCount = 1`, reset `count = 0`
- At index `2`, `2 < 3`, increment `count = 1`
- At index `3`, `3 > 2`, update `maxCount = 1`, reset `count = 0`
- Result: `maxCount = 1`

#### Example 2:
Input: `arr[] = [1, 2, 3, 4]`
- At index `0`, `1 < 2`, increment `count = 1`
- At index `1`, `2 < 3`, increment `count = 2`
- At index `2`, `3 < 4`, increment `count = 3`
- Final `maxCount = 3`
- Result: `maxCount = 3`



