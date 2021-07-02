package array;

// TODO 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
public class leetcode88 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while (i < m) {
            temp[k++] = nums1[i++];
        }
        while (j < n) {
            temp[k++] = nums2[j++];
        }
        for (int l = 0; l < k; l++) {
            nums1[l] = temp[l];
        }
    }
}
