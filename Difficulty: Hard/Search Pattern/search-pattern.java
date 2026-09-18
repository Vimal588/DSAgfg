class Solution {
    ArrayList<Integer> search(String pat, String txt) {

        ArrayList<Integer> result = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        // Step 1: Create LPS array for pattern
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {

            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Step 2: Search pattern in text
        i = 0;
        int j = 0;

        while (i < n) {

            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                // Pattern found
                result.add(i - j);

                // Continue searching for overlapping occurrences
                j = lps[j - 1];
            }
            else if (i < n && txt.charAt(i) != pat.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }

        return result;
    }
}