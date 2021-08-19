package greedy;

// TODO 45. 跳跃游戏 II https://leetcode-cn.com/problems/jump-game-ii/
public class leetcode45 {
    public int jump(int[] nums) {
        //我们维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1
        int steps = 0;
        int maxPosition = 0; // 边界
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (end == i) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
