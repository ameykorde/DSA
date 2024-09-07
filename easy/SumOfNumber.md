# Problem: Integer Overflow in Series Sum Calculation in Java

## Question:
Write a Java function to compute the sum of the first `n` natural numbers.

### Code:
```java
class Solution {
    public static long seriesSum(int n) {
        // Cast n to long to prevent overflow
        long sum = (long) n * (n + 1) / 2;
        return sum;
    }
}
```

