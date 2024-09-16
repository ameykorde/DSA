
# Sum of First `n` Natural Numbers

## Problem Statement
You are given a positive integer `n`. Calculate the sum of the first `n` natural numbers and return the result modulo `1000000007`.

### Formula
The sum of the first `n` natural numbers is given by:
\[
S = \frac{n \times (n + 1)}{2}
\]

### Constraints
- \(1 \leq n \leq 10^9\)

### Expected Time Complexity
- **O(1)**

### Expected Auxiliary Space
- **O(1)**

## Example

### Example 1:
**Input**:  
```text
n = 5
```
**Output**:  
```text
15
```
**Explanation**:  
The sum of the first 5 natural numbers is \(1 + 2 + 3 + 4 + 5 = 15\).

**Output**:  
**Explanation**:  
The sum of the first 1000000000 natural numbers is very large. To handle this, return the result modulo `1000000007`.

## Solution

```java
class Solution {
    static int sumOfNaturals(int n) {
        // code here
        int mod = 1000000007; // using the correct modulo value
        return (int)((long)n * (n + 1) / 2 % mod);
    }
};
```

## Explanation
1. **Modulo Value**: The result is computed modulo `1000000007` to prevent overflow and keep the result within standard integer bounds.
2. **Overflow Prevention**: Use `(long)n * (n + 1)` to handle large values during multiplication.
3. **Final Modulo**: The modulo operation is applied after the division to ensure the result fits within the expected range.

---