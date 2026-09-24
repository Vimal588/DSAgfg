import java.util.*;

class Solution {

    public int maxStackHeight(int[] r, int[] h) {

        int n = r.length;

        // Store {radius, height}
        int[][] discs = new int[n][2];

        for (int i = 0; i < n; i++) {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
        }

        /*
         * Sort:
         * 1. Radius increasing
         * 2. For same radius, height decreasing
         *
         * Why decreasing height for same radius?
         * Because radius must be strictly smaller.
         * This prevents discs having the same radius
         * from being considered as a valid chain.
         */
        Arrays.sort(discs, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        // h[i] <= 1000, so BIT size 1001 is enough
        int maxHeightValue = 1000;
        int[] bit = new int[maxHeightValue + 1];

        int answer = 0;

        for (int[] disc : discs) {

            int radius = disc[0];
            int height = disc[1];

            /*
             * Find maximum stack height having
             * height strictly smaller than current height.
             */
            int best = query(bit, height - 1);

            int current = best + height;

            // Update BIT at current height
            update(bit, height, current);

            answer = Math.max(answer, current);
        }

        return answer;
    }

    // Returns maximum value from 1 to index
    private int query(int[] bit, int index) {

        int max = 0;

        while (index > 0) {
            max = Math.max(max, bit[index]);
            index -= index & -index;
        }

        return max;
    }

    // Updates Fenwick Tree
    private void update(int[] bit, int index, int value) {

        while (index < bit.length) {
            bit[index] = Math.max(bit[index], value);
            index += index & -index;
        }
    }
}