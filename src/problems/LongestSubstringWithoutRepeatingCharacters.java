package problems;

import api.Problem;

import java.util.HashMap;
import java.util.HashSet;
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
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("hello"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("aab"));

    }

    /*
    Generate all possible substrings &
     check for each substring if it's valid and keep updating maxLen accordingly.

     */
    public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int max = 0;

        HashSet<Character> charSet = new HashSet<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            while (charSet.contains(chars[i])) {
                charSet.remove(chars[i]);
                l++;
            }
            charSet.add(chars[i]);
            max=Math.max(max, i-l+1);
        }

        return max;
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