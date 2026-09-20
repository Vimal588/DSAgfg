class Solution {
    public int largestSubsquare(char mat[][]) {

        int n = mat.length;

        int[][] right = new int[n][n];
        int[][] down = new int[n][n];

        // Build right and down arrays
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (mat[i][j] == 'X') {

                    // Count X towards right
                    right[i][j] = 1;
                    if (j + 1 < n) {
                        right[i][j] += right[i][j + 1];
                    }

                    // Count X towards down
                    down[i][j] = 1;
                    if (i + 1 < n) {
                        down[i][j] += down[i + 1][j];
                    }
                }
            }
        }

        int maxSize = 0;

        // Try every cell as top-left corner
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Try larger squares first
                int maxPossible = Math.min(right[i][j], down[i][j]);

                for (int size = maxPossible; size > maxSize; size--) {

                    int bottom = i + size - 1;
                    int rightCol = j + size - 1;

                    // Check whether square fits
                    if (bottom >= n || rightCol >= n) {
                        continue;
                    }

                    // Check bottom and right boundaries
                    if (right[bottom][j] >= size &&
                        down[i][rightCol] >= size) {

                        maxSize = size;
                        break;
                    }
                }
            }
        }

        return maxSize;
    }
}