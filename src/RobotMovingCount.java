public class RobotMovingCount {


    /*
    题目描述
    地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
    每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐
    标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够
    进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
    因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

     */
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] isVisit = new boolean[rows][cols];
        int count = countMoves(threshold,rows,cols,0,0,isVisit);
        return count;


    }
    public int countMoves(int threshold,int rows, int cols, int row,int col,boolean[][] isVisit)
    {
        int count = 0;
        if(check(threshold,rows,cols,row,col) && !isVisit[row][col])
        {
            isVisit[row][col] = true;
            count = 1 + countMoves(threshold,rows,cols,row + 1,col,isVisit) +
                    countMoves(threshold,rows,cols,row - 1,col,isVisit)+
                    countMoves(threshold,rows,cols,row,col + 1,isVisit)+
                    countMoves(threshold,rows,cols,row,col - 1,isVisit);
        }
        return count;
    }
    public boolean check(int threshold, int rows, int cols,int row,int col)
    {
        if(row >= 0 && row < rows && col >= 0 && col < cols && getNum(row,col) <= threshold)
            return true;
        return false;
    }
    public int getNum(int row,int col)
    {
        int sum = 0;
        while (row > 0)
        {
            sum += row%10;
            row /= 10;
        }

        while (col > 0)
        {
            sum += col%10;
            col /= 10;
        }
        return sum;
    }

    /*

     private int count = 0;

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] isVisit = new boolean[rows][cols];
        countMoves(threshold, rows, cols, 0, 0, isVisit);
        return count;
    }

    public void countMoves(int threshold, int rows, int cols, int row, int col, boolean[][] isVisit) {

        if (check(threshold, rows, cols, row, col) && !isVisit[row][col]) {
            isVisit[row][col] = true;
            count ++;
            countMoves(threshold, rows, cols, row + 1, col, isVisit);
            countMoves(threshold, rows, cols, row - 1, col, isVisit);
            countMoves(threshold, rows, cols, row, col + 1, isVisit);
            countMoves(threshold, rows, cols, row, col - 1, isVisit);
        }
    }

    public boolean check(int threshold, int rows, int cols, int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && getNum(row, col) <= threshold)
            return true;
        return false;
    }

    public int getNum(int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }

        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum;
    }
     */
}
