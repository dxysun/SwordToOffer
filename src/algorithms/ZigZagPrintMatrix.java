package algorithms;

/*
“之”字形打印矩阵
【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这
个矩阵，例如：
1 2 3 4
5 6 7 8
9 10 11 12
“之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，
8，12
【要求】 额外空间复杂度为O(1)。
 */
public class ZigZagPrintMatrix {


    public static void printMatrixZigZag(int[][] matrix) {
        if (matrix == null)
            return;
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        int endR = 0;
        int endC = 0;
        boolean isUp = true;
        while (endR != endRow + 1) {
            printLevel(matrix, startRow, startCol, endR, endC, isUp);

            startCol = startRow == endRow ? startCol + 1 : startCol;
            startRow = startRow == endRow ? endRow : startRow + 1;

            endR = endC == endCol ? endR + 1 : endR;
            endC = endC == endCol ? endC : endC + 1;
            isUp = !isUp;

        }

    }

    public static void printLevel(int[][] m, int startRow, int startCol, int endRow, int endCol, boolean isUp) {

        if (isUp) {
            while ( startCol <= endCol) {
                System.out.print(m[startRow --][startCol++] + " ");
            }
        } else {
            while (endCol >= startCol){
                System.out.print(m[endRow++][endCol--] + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        printMatrixZigZag(matrix);

    }
}
