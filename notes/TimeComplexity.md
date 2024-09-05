# Time Complexity
```java
for(int i=0; i<n; i++){
    for(int j=0; j<=i; j++){
        // code
    }
}
```

The outer loop runs n times.
The inner loop runs up to i times for each iteration of the outer loop.
- For i=1, j runs for 1 time.
- For i=2, j runs for 2 times.
- For i=3, j runs for 3 times.
...
- For i=n, j runs for n times.

Therefore, the total number of times j runs is the sum of the first n natural numbers: 1+2+3+...+n.
This sum is equal to n*(n+1)/2, which simplifies to `O(n^2 / 2)`.
Thus, the time complexity of this code is O(n^2).