This is a common problem called **Dutch National Flag problem**. You are asked to sort an array of `0s`, `1s`, and `2s` in ascending order. The most efficient way to do this is by using the **three-pointer approach** which has a time complexity of `O(n)` and space complexity of `O(1)`.

### Approach:
1. Use three pointers: 
   - `low`: points to the next position for a `0`.
   - `mid`: used to traverse the array.
   - `high`: points to the next position for a `2`.
   
2. Traverse the array from the beginning using the `mid` pointer.
   - If `arr[mid] == 0`, swap `arr[low]` and `arr[mid]`, increment both `low` and `mid`.
   - If `arr[mid] == 1`, just move `mid` ahead.
   - If `arr[mid] == 2`, swap `arr[mid]` and `arr[high]`, and decrement `high`.

### Solution Code:

```java
import java.util.Arrays;

class Solution {
    public static void sortArray(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high]
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 2, 1, 2, 0};
        int[] arr2 = {0, 1, 0};
        
        sortArray(arr1);
        System.out.println("Sorted array 1: " + Arrays.toString(arr1));  // Output: [0, 0, 1, 2, 2]
        
        sortArray(arr2);
        System.out.println("Sorted array 2: " + Arrays.toString(arr2));  // Output: [0, 0, 1]
    }
}
```

### Explanation:
- The array is traversed once using the `mid` pointer, and based on the value at `arr[mid]`, either a swap is made or the pointer is moved.
- If `arr[mid]` is `0`, it is swapped with the element at the `low` index, and both `low` and `mid` are incremented.
- If `arr[mid]` is `1`, it is in the correct position, so only `mid` is incremented.
- If `arr[mid]` is `2`, it is swapped with the element at the `high` index, and `high` is decremented.

### Time Complexity:
- The time complexity is `O(n)` because we are traversing the array once.

### Space Complexity:
- The space complexity is `O(1)` because we are using only constant extra space.

This approach is optimal for sorting arrays that only contain `0s`, `1s`, and `2s`.