package array;

// TODO 删除有序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
public class leetcode25 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // corner case, nums.length == 0

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            // if nums[i] == nums[j], j++ move forward, skip duplicate
            // otherwise, i++, and we let nums[i+1] = nums[j]
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
