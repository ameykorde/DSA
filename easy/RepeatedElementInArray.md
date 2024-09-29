
# Finding the First Repeated Element in an Array

## Problem Statement
Given an array of integers, the task is to find the first repeated element in the array and return its position (1-based index). If no element repeats, return -1.

### Example
- Input: `arr[] = [1, 5, 3, 4, 3, 5, 6]`
  - Output: `3` (1-based index)
  
- Input: `arr[] = [1, 2, 3, 4]`
  - Output: `-1` (no repeats)

## Your Approach
1. Create an `ArrayList` from the original array to maintain the elements.
2. Sort the `ArrayList`.
3. Traverse the sorted list to find repeated elements and store them in another list.
4. Check if the original array contains any elements from the list of repeated elements.
5. Return the 1-based index of the first repeated element found.

### Code
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstRepeatedElement {
    public static int firstRepeated(int[] arr) {
        // Copy original array to ArrayList
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            a.add(arr[i]);
        }
        
        // Sort the ArrayList
        Collections.sort(a);
        
        // List to store repeated elements
        List<Integer> b = new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i++) {
            if(a.get(i).equals(a.get(i + 1))) {
                b.add(a.get(i));
            }
        }
        
        // Find the first repeated element in the original array
        for(int i = 0; i < arr.length; i++) {
            if(b.contains(arr[i])) {
                return i + 1; // Return 1-based index
            }
        }
        return -1; // No repeated element found
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 4, 3, 5, 6}; // Example input
        System.out.println(firstRepeated(arr1)); // Output: 3

        int[] arr2 = {1, 2, 3, 4}; // Example input
        System.out.println(firstRepeated(arr2)); // Output: -1
    }
}
```

### Time Complexity
- **Time Complexity**: O(N log N) due to sorting the `ArrayList`, where N is the number of elements in the array.
  
### Space Complexity
- **Space Complexity**: O(N) for storing elements in the `ArrayList`.

## Optimized Approach Using HashSet
### Explanation
Using a `HashSet` allows us to keep track of seen elements in a more efficient way without needing to sort the array.

1. Traverse the array and use a `HashSet` to track elements.
2. For each element, check if it has already been seen:
   - If yes, return its index (1-based).
   - If no, add it to the `HashSet`.
3. If no repeated element is found, return -1.

### Optimized Code
```java
import java.util.HashSet;

public class FirstRepeatedElement {
    public static int firstRepeated(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (seen.contains(arr[i])) {
                return i + 1; // Return 1-based index
            }
            seen.add(arr[i]);
        }
        
        return -1; // No repeated element found
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 4, 3, 5, 6}; // Example input
        System.out.println(firstRepeated(arr1)); // Output: 3

        int[] arr2 = {1, 2, 3, 4}; // Example input
        System.out.println(firstRepeated(arr2)); // Output: -1
    }
}
```

### Time Complexity
- **Time Complexity**: O(N) for a single pass through the array, where N is the number of elements.
  
### Space Complexity
- **Space Complexity**: O(N) for storing elements in the `HashSet`.

