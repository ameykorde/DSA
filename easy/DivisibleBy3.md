
# Form a Number Divisible by 3 Using Array Digits

**Difficulty:** Easy  
**Points:** 2

## Question
You are given an array `arr` of integers of length `N`. The task is to find whether it’s possible to construct an integer using all the digits of the numbers in the array such that the resulting number is divisible by 3. If it is possible, return `1`, otherwise return `0`.

### Example:

#### Example 1:
Input: 
```
N = 3
arr = {40, 50, 90}
```
Output: 
```
1
```
Explanation: One possible number is `405090`, which is divisible by 3.

#### Example 2:
Input: 
```
N = 2
arr = {1, 4}
```
Output: 
```
0
```
Explanation: The numbers formed are `14` and `41`, neither of which are divisible by 3.

## Approach
The problem simplifies to checking whether the sum of the digits of the numbers is divisible by 3. Instead of calculating the sum of individual digits, we can sum the numbers directly and check if the sum is divisible by 3.

### Key Insight:
A number is divisible by 3 if the sum of its digits is divisible by 3. This means that we don't need to form the actual number. Instead, summing the array's numbers and checking whether the sum is divisible by 3 is sufficient.

### Steps:
1. Sum up all the numbers in the array.
2. Check if the total sum is divisible by 3.
3. If it is divisible by 3, return `1`; otherwise, return `0`.

### Code

```java
class Solution {
    static int isPossible(int N, int arr[]) {
        long sum = 0;
        
        // Sum all the numbers in the array
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        
        // Check if the sum is divisible by 3
        if (sum % 3 == 0) {
            return 1;
        }
        return 0;
    }
}
```

### Explanation:
1. **Sum the numbers:** We initialize a variable `sum` to store the total sum of the array's elements. A loop runs through each element of the array and adds it to `sum`.
2. **Check divisibility by 3:** After summing the numbers, we check if the sum is divisible by 3. If `sum % 3 == 0`, we return `1` (indicating it's possible to form a number divisible by 3), otherwise, return `0`.

### Example Walkthrough:
For the input `arr[] = {40, 50, 90}`:
- Step 1: Calculate the sum: `40 + 50 + 90 = 180`.
- Step 2: Check if `180 % 3 == 0`. Since it is divisible by 3, return `1`.

For the input `arr[] = {1, 4}`:
- Step 1: Calculate the sum: `1 + 4 = 5`.
- Step 2: Check if `5 % 3 == 0`. Since it is not divisible by 3, return `0`.

### Time Complexity:
- **Time Complexity:** `O(N)` where `N` is the number of elements in the array. We traverse the array once to calculate the sum.
  
### Space Complexity:
- **Auxiliary Space:** `O(1)` as no additional space is used apart from the sum variable.

## Edge Cases:
- If all numbers are `0`, the result is `1` since `0` is divisible by 3.
- If `N = 1` and the single number is not divisible by 3, the result should be `0`.
