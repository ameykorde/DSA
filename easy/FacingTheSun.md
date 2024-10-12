
# Problem: Count Buildings that can See Sunlight

## Problem Statement:
Given an array `height[]` representing the heights of buildings, determine how many buildings can see the sunlight if the sunlight comes from the left. A building can see sunlight if all buildings before it are shorter in height.

### Example 1:
```
Input: height[] = [7, 4, 8, 2, 9]
Output: 4
Explanation: Buildings with heights 7, 8, and 9 can see sunlight. The second building with height 4 cannot see the sunlight as it is blocked by the first building with height 7.
```

### Example 2:
```
Input: height[] = [1, 2, 3, 4]
Output: 4
Explanation: All buildings can see sunlight since they are all progressively taller.
```

### Constraints:
- 1 ≤ height.length ≤ 10^5
- 1 ≤ height[i] ≤ 10^6

---

## Approach:

1. **Initialization:**
   - Start by considering the first building, which can always see sunlight, so initialize the count to 1.
   - Use a variable `max` to store the index of the current tallest building that can see sunlight.

2. **Iterate through the array:**
   - For each building starting from the second one (index 1), check if its height is greater than the current tallest building (`height[max]`).
   - If it is taller, increment the count and update the `max` index to the current building's index.

3. **Return the count:**
   - Once all buildings are checked, return the count of buildings that can see the sunlight.

### Time Complexity:
- **O(n)**: We only traverse the array once, checking each building.
  
### Space Complexity:
- **O(1)**: No extra space is used except for a few variables.

---

## Solution Code:

```java
class Solution {
    // Returns count of buildings that can see sunlight
    public int countBuildings(int[] height) {
        // code here
        int max = 0; // Index of the tallest building that can see sunlight
        int count = 1; // The first building can always see sunlight
        
        // Traverse through the buildings starting from the second one
        for (int i = 1; i < height.length; i++) {
            // If the current building is taller than the last tallest building
            if (height[i] > height[max]) {
                count++; // Increment the count
                max = i; // Update the index of the tallest building
            }
        }
        return count; // Return the total count
    }
}
```

---

## Example Walkthrough:

### Input:
```
height[] = [7, 4, 8, 2, 9]
```

### Iteration:
- First building (7): Can see sunlight, count = 1.
- Second building (4): Blocked by the first building.
- Third building (8): Taller than the first, can see sunlight, count = 2.
- Fourth building (2): Blocked by the third building.
- Fifth building (9): Taller than the third, can see sunlight, count = 3.

### Output:
```
count = 4
```

---

## Edge Cases:
1. **All buildings of the same height**: Only the first building will see the sunlight.
2. **Strictly increasing heights**: All buildings will see the sunlight.
3. **Array of size 1**: The single building will see sunlight by default.
