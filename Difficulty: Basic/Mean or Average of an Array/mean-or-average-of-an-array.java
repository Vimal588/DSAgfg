class Solution {
    public static int findMean(int[] arr) {
        // code here
        
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        return (int)(sum / arr.length);
    }
};