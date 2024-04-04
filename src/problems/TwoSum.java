package problems;

import api.Problem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TwoSum  extends Problem {
    @Override
    public void start() {
        int[] nums = new int[] {2,7,11,15};
        int target =9;
        int[] ints = twoSum2(nums, target);
        if (ints!=null){

            System.out.println(nums[ints[0]]+"+"+nums[ints[1]]);
        }

    }
    public int[] twoSum2(int[] nums, int target) {

        ArrayList<Integer> integers = new ArrayList<>();

        for (int num : nums) {
            integers.add(num);
        }

        integers.sort((o1, o2) -> o2 - o1);
        System.out.println(integers);


        for (int i = 0; i < integers.size(); i++) {
            int n = integers.get(i);
            if (target - n == n) continue;
            int index = integers.indexOf(target - n);
            if (integers.contains(index)) {
                return new int[]{index, i+1};
            }
        }

        return null;
    }

    //O(n)
    public int[] twoSum(int[] nums, int target) {


        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                  return new int[] {i, j};
                }

            }
        }
        return null;
    }
}
