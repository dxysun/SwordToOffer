package algorithms;

/*
岛问题
一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
矩阵中有多少个岛？
举例：
0 0 1 0 1 0
1 1 1 0 1 0
1 0 0 1 0 0
0 0 0 0 0 0
这个矩阵中有三个岛。
 */
public class Islands {
    public static int countIslands(int[][] m) {
        if (m == null)
            return 0;
        int row = m.length;
        int col = m[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, row, col);
                }

            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int row, int col) {
        if (i < 0 || i == row || j < 0 || j == col || m[i][j] != 1)
            return;
        m[i][j] = 2;
        infect(m, i + 1, j, row, col);
        infect(m, i - 1, j, row, col);
        infect(m, i, j + 1, row, col);
        infect(m, i, j - 1, row, col);
    }

    public static void main(String[] args) {
        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m1));

        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m2));

    }


}
