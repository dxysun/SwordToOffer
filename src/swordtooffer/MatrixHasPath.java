package swordtooffer;

import java.util.Arrays;

public class MatrixHasPath {



    /*
    题目描述
    请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
    路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向
    下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该
    格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
    但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行
    第二个格子之后，路径不能再次进入该格子。
     */
    private static int pathLen = 0;
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix == null || rows < 1 || cols < 1 || str == null)
            return false;
        boolean[] isVisit = new boolean[rows * cols];

        pathLen = 0;
        for(int i = 0;i < rows;i ++)
        {
            for(int j = 0;j < cols;j ++)
            {
                if(hasPathCore(matrix,rows,cols,str,isVisit,i,j))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str,boolean[] isVisit,int row,int col)
    {
        if(pathLen == str.length)
        {
            return true;
        }
        boolean haspath = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols && str[pathLen] == matrix[row * cols + col] && !isVisit[row * cols + col])
        {
            isVisit[row * cols + col] = true;
            pathLen ++;
            haspath = hasPathCore(matrix,rows,cols,str,isVisit,row,col + 1) ||
                    hasPathCore(matrix,rows,cols,str,isVisit,row,col - 1) ||
                    hasPathCore(matrix,rows,cols,str,isVisit,row + 1,col) ||
                    hasPathCore(matrix,rows,cols,str,isVisit,row - 1,col);
            if(!haspath)
            {
                isVisit[row * cols + col] = false;
                pathLen --;
            }

        }


        return haspath;
    }

    public static void main(String[] args)
    {
        char[] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        char[] str = {'A','B','C','B'};
        System.out.println("result:" + hasPath(matrix,3,4,str));
    }
}
