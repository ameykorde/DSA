
# Reverse Words in a String

## Problem Statement

You are given a string containing words separated by dots (`.`). The task is to reverse the order of words in the string, while keeping the words themselves in their original form.

For example:
- **Input:** `"i.like.this.program.very.much"`
- **Output:** `"much.very.program.this.like.i"`

The words are reversed, but not the characters within the words.

---

## Examples:

### Example 1:

**Input:** 
```
str = "i.like.this.program.very.much"
```

**Output:** 
```
"much.very.program.this.like.i"
```

---

### Example 2:

**Input:** 
```
str = "hello.world"
```

**Output:** 
```
"world.hello"
```

---

## Approach

To reverse the words in the string while keeping the characters of the words intact:

1. **Iterate over the string from the end to the beginning**:  
   We will start from the last character of the string and traverse it backward.
   
2. **Construct each word**:  
   For each character that is not a dot (`.`), we keep adding it to a temporary string `s`. This string represents the current word we are building.

3. **When we encounter a dot**:
   - Append the word in `s` followed by a dot (`.`) to a result string `revStr`.
   - Reset `s` to build the next word.

4. **After the loop ends**:  
   Add the last word (if any) to the result string, because the last word will not be followed by a dot.

5. **Return the result**:  
   Return the reversed string as the final output.

---

## Solution (Java):

```java
public class Solution {
    public String reverseWords(String str) {
        String s = "";      // Temporary string to store each word
        String revStr = "";  // Final reversed string
        int l = str.length() - 1;

        while (l >= 0) {
            // If the current character is not a dot, add it to the current word
            if (str.charAt(l) != '.') {
                s = str.charAt(l) + s;  // Build the current word from the end
                l--;
            } else {
                // Append the current word and a dot to revStr
                revStr = revStr + s + '.';  
                l--;
                s = "";  // Reset the temporary word after adding to revStr
            }
        }

        // Add the last word (as it won't have a trailing dot)
        revStr = revStr + s;

        return revStr;
    }
}
```

---

### Explanation of the Code:

1. We initialize two strings: 
   - `s` to temporarily store the current word being built.
   - `revStr` to store the final reversed string.

2. We iterate over the string from the last character to the first character using a while loop. If the character is not a dot (`.`), we append it to `s`. When a dot is encountered, we append `s` (the current word) followed by a dot to `revStr`.

3. After processing the entire string, we append the last word (without a dot) to `revStr`.

4. The final result, `revStr`, contains the words in reverse order, separated by dots.

---

### Time Complexity:
- **O(n)**, where `n` is the length of the input string. We traverse the string once.

### Space Complexity:
- **O(n)**, as we are using additional space for the result string and temporary word storage.

---

### Example Walkthrough:

#### Input:
```
str = "i.like.this.program"
```

1. Start from the last character:
   - Build the word `program`.
   - Append `program.` to `revStr`.
   - Reset `s` to an empty string.

2. Continue with the next word:
   - Build the word `this`.
   - Append `this.` to `revStr`.
   - Reset `s`.

3. Repeat for `like` and `i`.

Final output: `program.this.like.i`

---

### Example 2 Walkthrough:

#### Input:
```
str = "hello.world"
```

1. Build the word `world`.
   - Append `world.` to `revStr`.
   - Reset `s`.

2. Build the word `hello`.
   - Append `hello` (without a trailing dot as it's the last word).

Final output: `world.hello`

---

