package algorithms;

//回字形打印矩阵
public class PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix) {
        if (matrix == null)
            return;

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            printEdge(matrix, startRow++, startCol++, endRow--, endCol--);
        }

    }

    public static void printEdge(int[][] m, int startRow, int startCol, int endRow, int endCol) {
        if (startRow == endRow) {
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(m[i] + " ");
            }
        } else if (startCol == endCol) {
            for (int i = startRow; i <= endRow; i++) {
                System.out.print(m[i] + " ");
            }
        } else {
            /*int len = (endRow - startRow - 1) * 2 + (endCol - startCol - 1) * 2 + 4;
            int state = 0;
            int x = startCol;
            int y = startRow;
            for(int i = 0;i < len;i++){
                if(state == 0){
                    System.out.print(m[x][y ++] + " ");
                    if(y == endCol)
                        state = 1;
                }
                if(state == 1){
                    System.out.print(m[x ++][y]+ " ");
                    if(x == endRow)
                        state = 2;
                }
                if(state == 2){
                    System.out.print(m[x][y --]+ " ");
                    if(y == startCol)
                        state = 3;
                }
                if(state == 3){
                    System.out.print(m[x --][y] + " ");
                    if(x == startRow)
                        break;

                }
            }*/

            int curC = startCol;
            int curR = startRow;
            while (curC != endCol) {
                System.out.print(m[startRow][curC] + " ");
                curC++;
            }
            while (curR != endRow) {
                System.out.print(m[curR][endCol] + " ");
                curR++;
            }
            while (curC != startCol) {
                System.out.print(m[endRow][curC] + " ");
                curC--;
            }
            while (curR != startRow) {
                System.out.print(m[curR][startCol] + " ");
                curR--;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        spiralOrderPrint(matrix);

    }
}
