# Solution Class for Minimum Value Calculation

## Overview
The Solution class contains a method to calculate the minimum value of the dot product of two lists of integers. The method sorts both lists and computes the dot product by multiplying the smallest elements of one list with the largest elements of the other.

## Method: minValue

### Signature
public long minValue(List<Integer> arr1, List<Integer> arr2)

### Parameters
- arr1: A List<Integer> representing the first array of integers.
- arr2: A List<Integer> representing the second array of integers.

### Returns
- Returns a long value representing the minimum dot product of the two arrays.

### Description
The method performs the following steps:
1. Sorts both arr1 and arr2 in ascending order.
2. Initializes a variable result to accumulate the dot product.
3. Iterates through the elements of arr1 and arr2:
   - Multiplies the smallest element of arr1 with the largest element of arr2, progressively moving towards the center of the sorted lists.
4. Returns the accumulated result.

### Example
List<Integer> arr1 = Arrays.asList(1, 2, 3);
List<Integer> arr2 = Arrays.asList(4, 5, 6);
Solution solution = new Solution();
long minValue = solution.minValue(arr1, arr2); // Output: 32

### Code
import java.util.Collections;
import java.util.List;

class Solution {
    public long minValue(List<Integer> arr1, List<Integer> arr2) {
        // Sort both lists
        Collections.sort(arr1);
        Collections.sort(arr2);
        
        long result = 0;
        int j = arr1.size() - 1;
        
        // Calculate the dot product
        for(int i = 0; i < arr1.size(); i++, j--) {
            result += arr1.get(i) * arr2.get(j);
        }
        
        return result;
    }
}

## Complexity Analysis
- Time Complexity: O(n log n) due to the sorting of the lists.
- Space Complexity: O(1) if we disregard the space used by the input lists.

## Conclusion
This method efficiently calculates the minimum dot product by leveraging sorting and strategic pairing of elements from both lists.
