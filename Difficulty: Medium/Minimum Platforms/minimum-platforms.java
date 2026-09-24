import java.util.*;

class Solution {
    public int minPlatform(int arr[], int dep[]) {

        int n = arr.length;

        // Sort arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0; // arrival pointer
        int j = 0; // departure pointer

        int platforms = 0;
        int maxPlatforms = 0;

        while (i < n && j < n) {

            // Arrival happens before or at departure
            if (arr[i] <= dep[j]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            }
            // Departure happens before next arrival
            else {
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }
}