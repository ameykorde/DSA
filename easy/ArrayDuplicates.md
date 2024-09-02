# Problem Statement

**Given an array `arr` of size `n` which contains elements in the range from `0` to `n-1`, you need to find all the elements occurring more than once in the given array. Return the answer in ascending order. If no such element is found, return a list containing `[-1]`.**

## Examples:

### Example 1:
- **Input**: `n = 4`, `arr[] = [0,3,1,2]`
- **Output**: `-1`
- **Explanation**: There is no repeating element in the array. Therefore, the output is `-1`.

### Example 2:
- **Input**: `n = 5`, `arr[] = [2,3,1,2,3]`
- **Output**: `2 3`
- **Explanation**: `2` and `3` occur more than once in the given array.

## Expected Complexity:
- **Time Complexity**: `O(n)`
- **Auxiliary Space**: `O(n)`

## Constraints:
- `1 <= n <= 10^5`
- `0 <= arr[i] <= 10^5`, for each valid `i`

# Solution

```java
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static ArrayList<Integer> duplicates(int[] arr) {
        ArrayList<Integer> duplicateElements = new ArrayList<>();
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                // Check if this duplicate has already been added
                if (duplicateElements.isEmpty() || duplicateElements.get(duplicateElements.size() - 1) != arr[i]) {
                    duplicateElements.add(arr[i]);
                }
            }
        }
        
        if (duplicateElements.isEmpty()) {
            duplicateElements.add(-1); // If no duplicates were found, return -1
        }
        
        return duplicateElements;
    }
}
```

## My Explanation
To solve these problem in O(n) time-complexity, first sorting will be done.
Then we will iterate through the array and check if the current element is equal to the next one.If they are equal, we will add the current element to the list of duplicates.

### Problem
The problem arises when duplicate element is already been added in ArrayList.
```java
 // Check if this duplicate has already been added
if (duplicateElements.isEmpty() || duplicateElements.get(duplicateElements.size() - 1) != arr[i])
```
This condition is used to check if the duplicate element is already been added in ArrayList.
- **Why we check first *duplicateElements.isEmpty()*?** : 
If the ArrayList is empty, then getting the element will give error *Exception in thread "main" java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0*. To prevent these first we have to check if Array isEmpty or not.
