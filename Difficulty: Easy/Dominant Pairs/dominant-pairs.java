import java.util.Arrays;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int half = n / 2;

        int[] left = new int[half];
        int[] right = new int[half];

        // Split array into two halves
        for (int i = 0; i < half; i++) {
            left[i] = arr[i];
            right[i] = arr[half + i];
        }

        // Sort both halves
        Arrays.sort(left);
        Arrays.sort(right);

        int j = 0;
        int count = 0;

        // For every element in left half
        for (int i = 0; i < half; i++) {

            // Find elements in right satisfying:
            // left[i] >= 5 * right[j]
            while (j < half && (long) left[i] >= 5L * right[j]) {
                j++;
            }

            // All elements before j are valid
            count += j;
        }

        return count;
    }
}