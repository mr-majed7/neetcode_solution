//https://leetcode.com/problems/search-a-2d-matrix/description/

public class Search2dMatrix {
    /**
     * We will do binary search twice in this problem
     * First binary search is to find in which row the target value is
     * If in a row the first element is greater or equal to the target value
     * Also the last element is less or equal to the target value that means the target is in that row
     * After identifying the row we will do binary search on that row
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int t = 0;
        int b = r - 1;

        while (t < b) {
            int row = (t + b) / 2;

            if (target > matrix[row][c - 1]) {
                t = row + 1;
            } else if (target < matrix[row][0]) {
                b = row - 1;
            } else {
                break;
            }
        }

        if (!(t <= b)) {
            return false;
        }

        int row = (t + b) / 2;
        int l = 0;
        r = c - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
