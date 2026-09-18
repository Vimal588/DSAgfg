class Solution {
    static String conRevstr(String s1, String s2) {
        // code here
        
        String str = s1 + s2;

        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString();
    }
}