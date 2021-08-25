package binarySearch;

// 153. 寻找旋转排序数组中的最小值 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
public class leetcode153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        //当 while (left < right) 时，对应的更新式是 left = middle + 1 ， right = middle
        //当 while (left <= right) 时，对应的更新式是 left = middle + 1，right = middle - 1
        while (low < high) {
            int pivot = low + (high - low) / 2; //
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

}
