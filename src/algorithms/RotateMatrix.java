package algorithms;

/*

旋转正方形矩阵
【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成
顺时针旋转90度的样子。
【要求】 额外空间复杂度为O(1)。
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;

        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow < endRow){
            rotateEdge(matrix,startRow ++,startCol ++,endRow --,endCol --);
        }

    }

    public static void rotateEdge(int[][] m, int startRow, int startCol, int endRow, int endCol) {

        int times = endCol - startCol;
        int temp = 0;
        for(int i = 0;i < times;i ++){

            // 逆时针
           /* temp = m[startRow][startCol + i];
            m[startRow][startCol + i] = m[startRow + i][endCol];
            m[startRow + i][endCol] = m[endRow ][endCol - i];
            m[endRow ][endCol - i] = m[endRow - i][startCol];
            m[endRow - i][startCol] = temp;*/

            // 顺时针
            temp = m[startRow][startCol + i];
            m[startRow][startCol + i] = m[endRow - i][startCol];
            m[endRow - i][startCol] = m[endRow][endCol - i];
            m[endRow][endCol - i] = m[startRow + i][endCol];
            m[startRow + i][endCol] = temp;


        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }

}
