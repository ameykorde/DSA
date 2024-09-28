
# Reverse Words in a String Separated by Dots

## Question

You are given a string `S` where words are separated by dots (`.`). Your task is to reverse each word in the string while keeping the dots in their original position, then return the final result.

### Example

**Input:**

```
hello.world.this.is.java
```

**Output:**

```
olleh.dlrow.siht.si.avaj
```

## Approach

1. Create a method `reverse` that takes a string as input and returns the reversed string.
2. Create a method `reverseWords` that processes the input string `S`, splitting it into words using the dot as a delimiter.
3. Reverse each word using the `reverse` method and construct the final result string.
4. Handle edge cases such as the last word without a trailing dot.

## Solution

### Code:

```java
public class GFG {
    public static String reverse(String s) {
        int i = s.length() - 1; 
        char[] str = new char[s.length()]; 
        int j = 0; 
        while (i >= 0) {
            str[j++] = s.charAt(i--); 
        }
        return new String(str); 
    }

    public String reverseWords(String S) {
        String s = ""; 
        String str = ""; 
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '.') {
                str += reverse(s) + '.'; 
                s = ""; 
            } else {
                s += S.charAt(i); 
            }
        }
        str += reverse(s); 
        return str; 
    }

    public static void main(String[] args) {
        GFG obj = new GFG(); 
        String S = "hello.world.this.is.java"; 
        System.out.println(obj.reverseWords(S)); 
    }
}
```

## Time Complexity

- The time complexity of the `reverse` function is **O(n)**, where `n` is the length of the word being reversed.
- The time complexity of the `reverseWords` function is **O(m)**, where `m` is the length of the input string `S`.

Overall time complexity: **O(m)**.
```

You can save this content as `ReverseWordsInDots.md`. It includes all the requested sections without extra commentary.