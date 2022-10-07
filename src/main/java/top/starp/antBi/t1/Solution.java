package top.starp.antBi.t1;

//评测题目:
//Given a 2D matrix M X N, support two operations:

//Query(row1, col1, row2, col2) such that I get the sum of all numbers in the
//rectangle ((row1, col1), (row1, col2), (row2, col1), (row2, col2))

//update(newValue, row, col) to a new number

//package top.starp.ant.t3;

public class Solution {


    int lowbit(int x) {
        return x & (-x);
    }

    long[] a;

    void update(int pos, int addNum) {
        while (pos <= n) {
            a[pos] += addNum;
            pos += lowbit(pos);
        }
    }

    //    void updateMat(int pos, int addNum,int col) {
    void updateMat(int pos, long addNum,int col) {
        while (pos <= n) {
            matrix[pos][col] += addNum;
            pos += lowbit(pos);
        }
    }


    int getSum(int i) {
        int res = 0;
        while (i > 0) {
            res += a[i];
            i -= lowbit(i);
        }
        return res;
    }

    long getSumMat(int i,int j) {
        long  res = 0;
        while (i > 0) {
            res += matrix[i][j];
            i -= lowbit(i);
        }
        return res;
    }



    long
    Query(int row1, int col1, int row2, int col2) {

        long sum = 0;

        // for (int i = row1; i < row2; i++) {
        //     for (int j = col1; j < col2; j++) {
        //         sum += matrix[i][j];
        //     }
        // }
        return    getSumMat(row2,col2)- getSumMat(row1,col1);
        // return sum;
    }

    void update(long newValue, int row, int col) {
        // matrix[row][col] = newValue;
        // updateMat(
        // for(int
        updateMat(row,newValue,col);
    }

    int m = 5;
    int n = 5;
    long[][] matrix = new long[m][n];

    public static void main(String[] args) {
        Solution solution = new Solution();
        long query = solution.Query(0, 0, 0, 0);
        System.out.println("query");
        System.out.println(query);
//        solution.update();
        solution.update(1,0,0);
//        long query2 = solution.Query(0, 1, 0, 1);
        long query2 = solution.Query(0, 0, 1, 1);


        System.out.println("query2");
        System.out.println(query2);
//        query
//        0
//        query2
//        1

    }
}
