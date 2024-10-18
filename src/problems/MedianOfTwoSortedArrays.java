package problems;

import api.Problem;
import api.datastructures.MaxHeap;

import java.util.*;

public class MedianOfTwoSortedArrays extends Problem {
    @Override
    public void start() {

        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        ArrayList<Integer> values= new ArrayList<>();

        for (int i : nums1) {
            values.add(i);
        }
        for (int i : nums2) {
            values.add(i);
        }
        Collections.sort(values);

//        System.out.println(values);
        if (values.size()==1){
            return values.get(0);
        }
        if (values.size()%2==1){
           int middleIndex = values.size()/2;
           return values.get(middleIndex);
        }
        double middle1 = values.get((int) (((double)values.size()/2.0)));
        double middle2 = values.get((int) (((double)values.size()/2.0))-1);


        return (middle1+middle2)/2.0;
    }
}
