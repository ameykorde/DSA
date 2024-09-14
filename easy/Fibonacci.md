
# Fibonacci Number Modulo 1000000007

## Problem Statement
Given a positive integer `n`, find the nth Fibonacci number. Since the answer can be very large, return the answer modulo \(10^9 + 7\).

The Fibonacci sequence is defined as:
- \( F(1) = 1 \)
- \( F(2) = 1 \)
- \( F(n) = F(n-1) + F(n-2) \) for \( n > 2 \)


## Examples

### Example 1:
**Input**:  
```text
n = 10
```
**Output**:  
```text
55
```
**Explanation**:  
The first 10 Fibonacci numbers are:  
1, 1, 2, 3, 5, 8, 13, 21, 34, **55**.  

Since 55 is small, the result is simply 55 modulo \(10^9 + 7 = 55\).

---

### Example 2:
**Input**:  
```text
n = 50
```
**Output**:  
```text
12586269025
```
**Explanation**:  
The Fibonacci number for `n = 50` is 12586269025.  
Since this value is large, the result is:  
\[ 12586269025 \% 1000000007 = 365010934 \].

---

## Expected Time Complexity:
- **O(n)** (linear time)

## Expected Auxiliary Space:
- **O(1)** (constant space)

---

## Solution Approach:

1. **Iterative Fibonacci Calculation**:
   - Instead of using recursion (which would be too slow for large `n`), we use an iterative approach.
   - We only need to store the last two Fibonacci numbers at any given time, which makes the solution space-efficient.

2. **Modulo Operation**:
   - Since Fibonacci numbers grow very large for higher values of `n`, we take the result modulo \(10^9 + 7\) at each step to prevent overflow and to ensure the result fits within the limits of an integer.

---

## Solution Code:

```java
class Solution {
    static int nthFibonacci(int n){
        int MOD = 1000000007;  // Modulo value

        // Base cases for n = 1 and n = 2
        if(n == 1 || n == 2)
            return 1;

        int prev1 = 1, prev2 = 1;  // Variables to store the previous two Fibonacci numbers
        int currentFib = 0;

        // Calculate the nth Fibonacci number iteratively
        for (int i = 3; i <= n; i++) {
            currentFib = (prev1 + prev2) % MOD;  // Apply modulo to keep the number manageable
            prev1 = prev2;  // Update prev1 to be the old prev2
            prev2 = currentFib;  // Update prev2 to the newly calculated Fibonacci number
        }

        return currentFib;
    }

    public static void main(String[] args) {
        System.out.println(nthFibonacci(10));  // Output: 55
        System.out.println(nthFibonacci(50));  // Output: 365010934
    }
}
```

---

## Explanation of the Modulo (%) Concept:

The modulo operator `%` is used to find the remainder when one number is divided by another. For example:

- \( 10 \% 3 = 1 \) (because \( 10 \div 3 = 3 \) remainder 1).
- \( 15 \% 4 = 3 \) (because \( 15 \div 4 = 3 \) remainder 3).

### Why Use Modulo \(10^9 + 7\)?
In programming problems, especially involving large numbers like Fibonacci numbers, calculations can result in very large values. These large numbers might exceed the range of the data types used to store them (like `int` or `long`), which can lead to overflow.

By using the modulo operation with a large prime number like \(10^9 + 7\), we ensure that all intermediate and final results stay within the limits of the integer range.

For example:
- Without modulo: The 50th Fibonacci number is `12586269025`.
- With modulo \(10^9 + 7\): The result is `12586269025 % 1000000007 = 365010934`.

This allows us to safely work with large numbers without encountering overflow issues.

---

## Modulo Properties:
1. \( (a + b) \% c = ((a \% c) + (b \% c)) \% c \)
2. \( (a - b) \% c = ((a \% c) - (b \% c) + c) \% c \)
3. \( (a \times b) \% c = ((a \% c) \times (b \% c)) \% c \)

These properties help ensure that we can break down large operations and still keep the result within a manageable range.

---

