package top.starp.antBi.t1;

class NumMatrix {
    private int[][] preSum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        preSum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // starting from index [1, 1]
                // all 0 indexes remains 0
                preSum[i][j] = preSum[i][j-1] + preSum[i-1][j] + matrix[i-1][j-1] - preSum[i-1][j-1];
				// - preSum[i-1][j-1] because it is added twice
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
		// + preSum[row1][col1] becuase it is deleted twice.
    }
}
