package problems;

import api.Problem;
/*
3. Longest Substring Without Repeating Characters
Medium
Topics
Companies
Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */

public class LongestSubstringWithoutRepeatingCharacters  extends Problem {
    @Override
    public void start() {
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }

    public int lengthOfLongestSubstring(String s) {
        char lastChar;
        int res = 0;

        boolean first = true;

        int cur = 0;


        for (char c : s.toCharArray()) {
            if (!first){
                if (c==lastChar){ //NO MORE MATCH
                    res = Math.max(res, cur);
                    System.err.println(c+" " + res);
                    cur = 0;
                    continue;
                }
            }
            cur++;
            first=false;
            lastChar=c;

        }
        return res;

    }

}
/*
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */