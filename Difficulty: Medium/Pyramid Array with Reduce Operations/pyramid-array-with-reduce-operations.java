class Solution {
    public long formPyramid(int[] arr) {
        int n = arr.length;

        long total = 0;

        for (int i = 0; i < n; i++) {
            total += arr[i];
        }

        // left[i] = maximum possible height at i
        // considering the left side
        int[] left = new int[n];

        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }

        // right[i] = maximum possible height at i
        // considering the right side
        int[] right = new int[n];

        right[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        // Find maximum possible pyramid sum
        long maxPyramidSum = 0;

        for (int i = 0; i < n; i++) {
            long peak = Math.min(left[i], right[i]);

            // Sum of a pyramid with peak height 'peak' = peak^2
            long pyramidSum = peak * peak;

            maxPyramidSum = Math.max(maxPyramidSum, pyramidSum);
        }

        return total - maxPyramidSum;
    }
}