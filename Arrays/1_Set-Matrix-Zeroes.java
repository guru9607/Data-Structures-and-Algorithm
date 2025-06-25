class Solution {

    // -------------------------------------------------------------
    // Brute Force (Using a Copy Matrix)
    // -------------------------------------------------------------
    // Approach:
    //   - Copy the entire matrix.
    //   - Whenever you find a 0 in the copy, set its entire row and column
    //     to 0 in the original.
    //
    // TC:  O(m * n * (m + n)) → Scan + (row & col zeroing)
    //  SC: O(m * n) → for the copy
    
    public void setZeroesBruteForce(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] copy = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (copy[i][j] == 0) {
                    for (int k = 0; k < col; k++) matrix[i][k] = 0;  // Zero entire row
                    for (int k = 0; k < row; k++) matrix[k][j] = 0;  // Zero entire col
                }
            }
        }
    }

    // -------------------------------------------------------------
    // Better:  Extra Space (Row & Column Marker Arrays)
    // -------------------------------------------------------------
    //  Idea:
    //   - Use two 1D arrays to mark which rows/cols need to be zeroed.
    //   - In second pass, use markers to set zeroes.
    //
    //  TC:  O(m * n)
    //  SC: O(m + n)
    public void setZeroesExtraSpace(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Marker arrays for rows and columns
        int[] rowToMakeZero = new int[row];
        int[] colToMakeZero = new int[col];
        Arrays.fill(rowToMakeZero, 1);
        Arrays.fill(colToMakeZero, 1);

        //  First pass: identify the zero locations
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowToMakeZero[i] = 0;
                    colToMakeZero[j] = 0;
                }
            }
        }

        // Second pass: zero out marked rows
        for (int i = 0; i < row; i++) {
            if (rowToMakeZero[i] == 0) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        //  Third pass: zero out marked columns
        for (int j = 0; j < col; j++) {
            if (colToMakeZero[j] == 0) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // -------------------------------------------------------------
    // Best: Optimal In-Place (Matrix as Marker)
    // -------------------------------------------------------------
    // Approach :
    //   - Use 1st row and 1st column as marker space.
    //   - Mark rows/cols to be zeroed directly in matrix.
    //   - Use two flags to track if first row/col itself should be zeroed.
    //
    //  TC:  O(m * n)
    //  SC: O(1) → in-place with only two extra flags
    public void setZeroesOptimalInPlace(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean isFirstRow0 = false;
        boolean isFirstCol0 = false;

        //  Step 1: Check if first row needs to be zeroed
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                isFirstRow0 = true;
                break;
            }
        }

        // Step 2: Check if first column needs to be zeroed
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                isFirstCol0 = true;
                break;
            }
        }

        // Step 3: Use 1st row & col to mark rest of matrix
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // Mark row
                    matrix[0][j] = 0;  // Mark column
                }
            }
        }

        // Step 4: Set zeroes based on markers (excluding first row/col)
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Zero out the first row if needed
        if (isFirstRow0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 6: Zero out the first column if needed
        if (isFirstCol0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
