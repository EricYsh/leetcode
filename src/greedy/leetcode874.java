package greedy;

import java.util.HashSet;

//TODO 874. 模拟行走机器人 https://leetcode-cn.com/problems/walking-robot-simulation/description/
public class leetcode874 {
    //1：构造dir_x、dir_y，表示向当前方向前进一步时，x,y坐标的变化情况；</br>
    //2：用status记录当前状态，初始值为0，表示向正北方前进，当指令command=-1时，status+1；
    //      当command=-2时，status+3(保证不会出现负数的情况);通过取余操作（%4）获取当前状态；
    //3：用set记录所有障碍点，如果向前前进一步遇到障碍点时，则进行下一次指令，否则更新坐标。
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dir_x = {0, 1, 0, -1};
        int[] dir_y = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        //0,1,2,3分别代表北、东、南、西方向，初始为正北方；
        int status = 0;
        int max_distance = 0;
        //判断障碍物：将障碍物的x和y坐标组合成一个字符串用set保存障碍物，查找的时候只要判断当前坐标组成的串是否在set里即可。
        HashSet<String> blockSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            blockSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1){
                status += 1;
            }
            if (commands[i] == -2){
                status += 3;
            }
            if (commands[i] > 0){
                for (int j = 0; j < commands[i]; j++) {
                    int next_x = x + dir_x[status % 4];
                    int next_y = y + dir_y[status % 4];
                    if (blockSet.contains(next_x + "," + next_y)){
                        break;
                    }else {
                        x = next_x;
                        y = next_y;
                        max_distance = Math.max(max_distance, x*x+y*y);
                    }
                }
            }
        }
        return max_distance;
    }
}
