class Solution {
    public String maxOdd(String s) {
        // code here


        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (ch == '1' || ch == '3' || ch == '5' ||
                ch == '7' || ch == '9') {

                return s.substring(0, i + 1);
            }
        }

        return "";
    }
}
