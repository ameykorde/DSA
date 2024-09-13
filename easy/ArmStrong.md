
# Armstrong Numbers

## Problem Statement
You are given a 3-digit number `n`. Find whether it is an Armstrong number or not.

An **Armstrong number** of three digits is a number such that the sum of the cubes of its digits is equal to the number itself. For example, **371** is an Armstrong number since \( 3^3 + 7^3 + 1^3 = 371 \).

### Note:
Return `"true"` if the number is an Armstrong number, otherwise return `"false"`.

## Examples

### Example 1:
**Input**:  
```text
n = 153
```
**Output**:  
```text
true
```
**Explanation**:  
153 is an Armstrong number since \( 1^3 + 5^3 + 3^3 = 153 \).

---

### Example 2:
**Input**:  
```text
n = 372
```
**Output**:  
```text
false
```
**Explanation**:  
372 is not an Armstrong number since \( 3^3 + 7^3 + 2^3 = 378 \), which is not equal to 372.

---

## Expected Time Complexity:
- **O(1)** (constant time)

## Expected Auxiliary Space:
- **O(1)** (constant space)

## Constraints:
- \( 100 \leq n < 1000 \)

---

## Solution Approach:

1. **Extract the digits** of the number `n`. The number has three digits: `hundreds`, `tens`, and `ones`.
   
2. **Compute the cube** of each digit.

3. **Sum the cubes** of the digits.

4. **Compare** the sum of cubes with the original number `n`. If they are equal, return `"true"`; otherwise, return `"false"`.
```
class Solution {
    public static boolean isArmstrong(int n) {
        int originalNumber = n;
        int sum = 0;

        // Extract digits and compute the sum of cubes
        while (n > 0) {
            int digit = n % 10;       // Get the last digit
            sum += Math.pow(digit, 3); // Add the cube of the digit to sum
            n /= 10;                  // Remove the last digit
        }

        // Return true if the sum of cubes is equal to the original number
        return sum == originalNumber;
    }

    public static void main(String[] args) {
        int n = 153;  // Example input
        System.out.println(isArmstrong(n));  // Output: true

        n = 372;  // Another example
        System.out.println(isArmstrong(n));  // Output: false
    }
}
