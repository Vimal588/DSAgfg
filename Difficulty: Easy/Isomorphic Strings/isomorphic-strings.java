class Solution {
    public boolean areIsomorphic(String s1, String s2) {

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        Arrays.fill(map1, -1);
        Arrays.fill(map2, -1);

        for (int i = 0; i < s1.length(); i++) {

            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';

            if (map1[a] != -1 && map1[a] != b) {
                return false;
            }

            if (map2[b] != -1 && map2[b] != a) {
                return false;
            }

            map1[a] = b;
            map2[b] = a;
        }

        return true;
    }
}