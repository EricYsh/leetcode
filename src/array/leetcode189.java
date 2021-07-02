package array;

// TODO 旋转数组 https://leetcode-cn.com/problems/rotate-array/
public class leetcode189 {

    //TODO solution3
//    nums = "----->-->"; k =3
//    result = "-->----->";
//
//    reverse "----->-->" we can get "<--<-----"
//    reverse "<--" we can get "--><-----"
//    reverse "<-----" we can get "-->----->"
//    this visualization help me figure it out :)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
