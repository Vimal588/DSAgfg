import java.util.*;

class Solution {

    public String findLongestWord(String s, List<String> d) {

        int n = s.length();

        // next[i][c] = next position of character c from position i
        int[][] next = new int[n + 1][26];

        Arrays.fill(next[n], -1);

        for (int i = n - 1; i >= 0; i--) {

            // Copy information from next position
            for (int c = 0; c < 26; c++) {
                next[i][c] = next[i + 1][c];
            }

            // Current character occurs at i
            next[i][s.charAt(i) - 'a'] = i;
        }

        String ans = "";

        for (String word : d) {

            if (isSubsequence(word, next)) {

                if (word.length() > ans.length() ||
                    (word.length() == ans.length() &&
                     word.compareTo(ans) < 0)) {

                    ans = word;
                }
            }
        }

        return ans;
    }

    private boolean isSubsequence(String word, int[][] next) {

        int position = 0;

        for (int i = 0; i < word.length(); i++) {

            int character = word.charAt(i) - 'a';

            if (position >= next.length || next[position][character] == -1) {
                return false;
            }

            position = next[position][character] + 1;
        }

        return true;
    }
}