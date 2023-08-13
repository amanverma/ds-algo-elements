package backtracking;

import java.util.*;

public class PowerSet {

    public static void backTrackPowerSet(int[] nums, int start, ArrayList<Integer> current, List<List<Integer>> powerSet){
        powerSet.add(new ArrayList<>(current));
        for(int i = start; i < nums.length; i ++){
            current.add(nums[i]);
            backTrackPowerSet(nums, i+1, current,powerSet);
            current.remove(current.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> powerSet = new ArrayList<>();
        backTrackPowerSet(nums, 0, new ArrayList<Integer>(), powerSet);
        System.out.println(powerSet);
    }
}
