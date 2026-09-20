import java.util.Arrays;

class Solution {

    public int mean(int[] arr) {

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        return (int)(sum / arr.length);
    }

    public int median(int[] arr) {

        Arrays.sort(arr);

        int n = arr.length;

        // Odd length
        if (n % 2 != 0) {
            return arr[n / 2];
        }

        // Even length
        return (arr[n / 2 - 1] + arr[n / 2]) / 2;
    }
}