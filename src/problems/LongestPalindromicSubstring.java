package problems;

import api.Problem;

import javax.swing.text.Style;

public class LongestPalindromicSubstring  extends Problem {
    @Override
    public void start() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));

    }
    public boolean isPalindrome(String s) {
        int right = s.length()-1;
        for (int i = 0; i < s.length() / 2; i++) {

            if (s.charAt(i)!=s.charAt(right)) {
                return false;
            }
            right--;
        }
        return true;
    }


    public String longestPalindrome (String s){

        return "";

    }
}