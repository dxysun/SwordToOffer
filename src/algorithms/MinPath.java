package algorithms;

/*
给你一个二维数组，二维数组中的每个数都是正数，要求从左上
角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
加起来。返回最小的路径和。
 */
public class MinPath {

    public static int minPath1(int[][] matrix) {

        if (matrix == null)
            return 0;
        return process1(matrix, matrix.length - 1, matrix[0].length - 1);
    }

    public static int process1(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0)
            return res;
        if (i == 0 && j != 0)
            return res + process1(matrix, i, j - 1);
        if (i != 0 && j == 0)
            return res + process1(matrix, i - 1, j);
        return res + Math.min(process1(matrix, i - 1, j), process1(matrix, i, j - 1));
    }

    public static int minPath2(int[][] matrix) {
        if (matrix == null)
            return 0;
        return process2(matrix, 0, 0);
    }

    private static int process2(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return res;
        }
        if (i == matrix.length - 1 && j != matrix[0].length - 1) {
            return res + process2(matrix, i, j + 1);
        }
        if (i != matrix.length - 1 && j == matrix[0].length - 1) {
            return res + process2(matrix,i + 1,j);
        }

        return res + Math.min(process2(matrix,i + 1,j),process2(matrix,i,j + 1));
    }


    public static int minPath3(int[][] matrix){
        if(matrix == null)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        for(int i = 0;i < row;i ++){
            for(int j = 0;j < col;j ++){
                if(i == 0 && j == 0)
                    res[i][j] = matrix[i][j];
                if(i == 0 && j != 0)
                    res[i][j] = res[i][j - 1] + matrix[i][j];
                if(i != 0 && j == 0)
                    res[i][j] = res[i - 1][j] + matrix[i][j];
                if(i != 0 && j != 0){
                    res[i][j] = matrix[i][j] + Math.min(res[i - 1][j],res[i][j - 1]);
                }
            }
        }
        return res[row - 1][col - 1];
    }

    public static int minPath4(int[][] matrix){

        if(matrix == null)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];

        res[row - 1][col - 1] = matrix[row - 1][col - 1];

        for(int i = row - 2;i >= 0;i --){
            res[i][col - 1] = matrix[i][col - 1] + res[i + 1][col - 1];
        }

        for(int i = col - 2;i >= 0;i --){
            res[row - 1][i] = matrix[row - 1][i] + res[row - 1][i + 1];
        }

        for(int i = row - 2;i >= 0;i --){
            for (int j = col - 2;j >= 0;j --){

                res[i][j] = matrix[i][j] + Math.min(res[i + 1][j],res[i][j + 1]);

            }
        }

        return res[0][0];
    }
    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
        System.out.println(minPath3(m));
        System.out.println(minPath4(m));

        System.out.println();
        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
        System.out.println(minPath3(m));
        System.out.println(minPath4(m));


    }


}
