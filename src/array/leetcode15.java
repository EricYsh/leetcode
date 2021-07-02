package array;

import java.util.*;

public class leetcode15 {

    // TODO 排序数组的双指针理论
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = nums.length-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
        // TODO 看不太懂
//        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
//        for (int k = 0; k < nums.length - 2; k++) {
//            if (nums[k] > 0) break;  // 排序后的性质
//            if (k > 0 && nums[k] == nums[k - 1]) continue;  //去重
//            int i = k + 1, j = nums.length - 1; // 双指针开始
//            while (i < j) {
//                int sum = nums[k] + nums[i] + nums[j];
//                if (sum < 0) {
//                    while (i < j && nums[i] == nums[++i]) ;
//                } else if (sum > 0) {
//                    while (i < j && nums[j] == nums[--j]) ;
//                } else {
//                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
//                    while (i < j && nums[i] == nums[++i]) ;
//                    while (i < j && nums[j] == nums[--j]) ;
//                }
//            }
//        }
//        return result;
    }

    // TODO 遍历所有的数（暴力方法）会超时
//    public static List<List<Integer>> threeSum(int[] nums) {
//
//        Set<List<Integer>> result = new LinkedHashSet<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
//                        result.add(temp);
//                    }
//                }
//            }
//        }
//
//        return new ArrayList<>(result);
//    }

    public static void main(String[] args) {
        int[] test = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(test));
    }
}
