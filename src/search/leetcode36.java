package search;

// 36. 有效的数独 https://leetcode-cn.com/problems/valid-sudoku/
public class leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        // 首先就是要知道每个box的索引的求法为：boxIdx = (i / 3) * 3 + j / 3；
            // 把一个3*3的块当成一个，其实我们就是3*3的分块矩阵。从左到右的话，box标号为0,1,2. 这个没问题，j//3就可以.
            // 然后标号应该为3,4,5，其实就是3+j//3，再然后的标号是6+j//3， 其实这时候就是用i来得到0,3,6. i//3得到的是0,1,2. 所以乘个3就好了。
        // 然后用三个boolean的二维数组来分别表示每一行（列、盒子）中对应的数字（1-9）是否已经出现；
        // 如果遍历过程中发现有一个已经为true（已经出现），则为不合法
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1', boxIdx = (i / 3) * 3 + j / 3;
                    if (row[i][num] || col[j][num] || box[boxIdx][num]) return false;
                    else {
                        row[i][num] = true;
                        col[j][num] = true;
                        box[boxIdx][num] = true;
                    }
                }
            }
        }

        return true;
    }
}
