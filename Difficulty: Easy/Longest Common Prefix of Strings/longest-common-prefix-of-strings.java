class Solution {
    public String longestCommonPrefix(String[] arr) {

        String first = arr[0];

        for (int i = 0; i < first.length(); i++) {

            char ch = first.charAt(i);

            for (int j = 1; j < arr.length; j++) {

                if (i >= arr[j].length() || arr[j].charAt(i) != ch) {
                    return first.substring(0, i);
                }
            }
        }

        return first;
    }
}