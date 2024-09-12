
# Prime Number Check

## Problem Description
You are given a number `n`. You need to check if `n` is a prime number. A prime number is a number that is only divisible by 1 and itself.

### Input:
- A single integer `n`.

### Output:
- Return `1` if `n` is prime.
- Return `0` otherwise.

### Examples:

#### Example 1:
```
Input: n = 5
Output: 1
Explanation: 5 has only 2 factors: 1 and 5, so it's a prime number.
```

#### Example 2:
```
Input: n = 25
Output: 0
Explanation: 25 has 3 factors: 1, 5, and 25, so it's not a prime number.
```

## Expected Time Complexity:
- **O(√n)**: We only need to check up to the square root of `n` for divisors.

## Expected Space Complexity:
- **O(1)**: Constant space is used.

## Approach:
- If `n` is less than 2, return 0 (since numbers less than 2 are not prime).
- Check if `n` is divisible by any number from `2` to `√n`.
  - If it is divisible by any of these numbers, return 0 (not prime).
  - If no divisors are found, return 1 (prime).


### `PrimeNumber.java`

```java
public class PrimeNumber {

    // Function to check if the number is prime
    public static int isPrime(int n) {
        // Numbers less than 2 are not prime
        if (n <= 1) {
            return 0;
        }

        // Check divisibility from 2 to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return 0;  // Not a prime number
            }
        }

        return 1;  // Prime number
    }

    // Main method for testing
    public static void main(String[] args) {
        int n = 5;  // Example input
        System.out.println(isPrime(n));  // Expected output: 1

        n = 25;  // Example input
        System.out.println(isPrime(n));  // Expected output: 0
    }
}
```
