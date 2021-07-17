package array;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

// TODO 两数之和 https://leetcode-cn.com/problems/two-sum/
public class leetcode1 {
    // TODO 暴力 O（n^2）
    // TODO hashtable O（n）target = a + b, for each a, if (target - a) exists in array
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
