package problems;

import java.util.Scanner;

public class MaxNestingDepthOfParentheses {
    public static void main(String[] args) {
        new MaxNestingDepthOfParentheses().start();
    }

    public MaxNestingDepthOfParentheses() {
    }

    public void start() {
        Scanner scanner= new Scanner(System.in);

        String s = scanner.nextLine();
        System.out.println(maxDepth(s));

    }

    public int maxDepth(String s) {
        if (s.isEmpty()) return 0;
        if (!s.contains("(")||!s.contains(")"))return 0; //O(n)
        //DIVIDE AND CONQURD

        int res = 0;


        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c=='('){
                balance++;
                res=Math.max(balance, res);
            }
            if (c==')'){
                balance--;
                res=Math.max(balance, res);
            }
        }

//
//        Map<String, Integer> sets =new HashMap<>();
//
//
//        Stack<Character> characters=new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (c=='('||c==')'){
//                characters.push(c);
//            }
//        }
//        while (!characters.isEmpty()){
//            Character pop = characters.pop();
//
//        }
//        for (Character character : characters) {
//            System.out.print(character);
//        }
        return res;
    }
}