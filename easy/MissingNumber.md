
# Missing Number

## Question
Ritu has all numbers from 2 to n in an array `arr` of length `n-1` except one number. You have to return the missing number, Ritu doesn't have from 1 to n.

### Note:
- Sorting is not allowed.

### Examples:

#### Example 1:
Input: 
```
n = 4, arr = [1,  4,  3]
```
Output: 
```
2
```
Explanation: Ritu doesn't have the number 2.

#### Example 2:
Input: 
```
n = 5, arr = [2,  5,  3,  1]
```
Output: 
```
4
```
Explanation: Ritu doesn't have the number 4 in her collection.

## Approach
The sum of numbers from 1 to `n` is known to be `n * (n + 1) / 2`. If we subtract the sum of the array `arr` from this total sum, the result will be the missing number.

## Solution

### Code
```java
public class Solution {
    public static int findMissingNumber(int n, int[] arr) {
        // Calculate the sum from 1 to n
        int totalSum = n * (n + 1) / 2;
        
        // Calculate the sum of the elements in arr
        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }
        
        // The missing number is the difference between totalSum and arrSum
        return totalSum - arrSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 3};
        int n1 = 4;
        System.out.println(findMissingNumber(n1, arr1)); // Output: 2

        int[] arr2 = {2, 5, 3, 1};
        int n2 = 5;
        System.out.println(findMissingNumber(n2, arr2)); // Output: 4
    }
}
```

## Time Complexity
- **Time Complexity:** `O(n)`  
  We iterate through the array once to calculate its sum.

## Space Complexity
- **Auxiliary Space:** `O(1)`  