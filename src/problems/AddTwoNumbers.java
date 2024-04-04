package problems;

import api.Problem;

import java.math.BigInteger;
import java.util.*;

public class AddTwoNumbers  extends Problem {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + ((next != null) ? "-" + next : "");
        }
    }

    @Override
    public void start() {

        ListNode node = addTwoNumbers( build(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1), build(5,6,4));

        System.out.println(node);
    }

    private ListNode build(int... ints) {

        ListNode output = null;

        for (int i = ints.length-1; i >=0; i--) {
            ListNode current = new ListNode(ints[i]);
            current.next = output;
            output = current;
        }
        return output;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ArrayDeque<Integer> numOne = new ArrayDeque<>();
        ArrayDeque<Integer> numTwo = new ArrayDeque<>();

        boolean l1None = l1.next == null && l1.val == 0;
        boolean l2None = l2.next == null && l2.val == 0;
        if (l1None && l2None) return new ListNode(0);
        if (l2None && !l1None) {
            return l1;
        }

        if (l1None && !l2None) {
            return l2;
        }

//        if (l1.next==null&&l2.next==null)return new ListNode(0);

        while (l1 != null) {
            numOne.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            numTwo.addFirst(l2.val);
            l2 = l2.next;
        }


        String numOneString = "";
        String numTwoString ="";
        for (int i : numOne) {
            numOneString+=i;
        }

        for (int i : numTwo) {
            numTwoString+=i;
        }
        BigInteger n1 = new java.math.BigInteger (numOneString);
        BigInteger n2 =  new java.math.BigInteger(numTwoString);



        BigInteger add = n1.add(n2);

        String parse = String.valueOf(add);

        char[] charArray = parse.toCharArray();

        ListNode output = null;


        for (int i = 0; i < charArray.length; i++) {
            ListNode current = new ListNode(charArray[i] - '0');
            current.next = output;
            output = current;
        }

        return output;
    }
}
