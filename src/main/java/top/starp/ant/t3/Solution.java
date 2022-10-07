package top.starp.ant.t3;

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

    int getSum(int i) {
        int res = 0;
        while (i > 0) {
            res += a[i];
            i -= lowbit(i);
        }
        return res;
    }


    long
    Query(int row1, int col1, int row2, int col2) {

        long sum = 0;
        for (int i = row1; i < row2; i++) {
            for (int j = col1; j < col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    void update(long newValue, int row, int col) {
        matrix[row][col] = newValue;
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
