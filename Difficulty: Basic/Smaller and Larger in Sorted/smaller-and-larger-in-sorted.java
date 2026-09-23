class Solution {
    int[] getMoreAndLess(int[] arr, int target) {

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= target) {
                count1++;
            }

            if (arr[i] >= target) {
                count2++;
            }
        }

        return new int[]{count1, count2};
    }
}