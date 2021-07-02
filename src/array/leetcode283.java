package array;

import java.util.Arrays;

public class leetcode283 {
    public static void moveZeroes(int[] nums) {
        int j = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }
}
