package disjointSet;

// 130. 被围绕的区域 https://leetcode-cn.com/problems/surrounded-regions/
public class leetcode130 {
    //我们的思路是把所有边界上的 O 看做一个连通区域。遇到 O 就执行并查集合并操作，这样所有的 OO 就会被分成两类
    //和边界上的 O 在一个连通区域内的。这些 O 我们保留。
    //不和边界上的 O 在一个连通区域内的。这些 O 就是被包围的，替换。
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        DisjointSets disjointSets = new DisjointSets(board);
        int rows = board.length, cols = board[0].length;
        int dummyBorder = rows * cols;

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (board[x][y] == 'O') {
                    int borderO = x * cols + y;
                    if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1) {
                        disjointSets.union(dummyBorder, borderO);
                        continue;
                    }
                    for (int[] dir : directions) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && board[nx][ny] == 'O') {
                            int neighbor = nx * cols + ny;
                            disjointSets.union(borderO, neighbor);
                        }
                    }
                }
            }
        }

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (board[x][y] == 'O' && disjointSets.find(x * cols + y) != disjointSets.find(dummyBorder)) {
                    board[x][y] = 'X';
                }
            }
        }

    }

    class DisjointSets {

        int[] parent;

        public DisjointSets(char[][] board) {

            int rows = board.length, cols = board[0].length;
            parent = new int[rows * cols + 1];

            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (board[x][y] == 'O') {
                        int id = x * cols + y;
                        parent[id] = id;
                    }
                }
            }
            parent[rows * cols] = rows * cols;
        }

        public int find(int x) {

            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
}

