class Solution {
    public String printNumber(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'c') {
                sb.append('2');
            }
            else if (ch >= 'd' && ch <= 'f') {
                sb.append('3');
            }
            else if (ch >= 'g' && ch <= 'i') {
                sb.append('4');
            }
            else if (ch >= 'j' && ch <= 'l') {
                sb.append('5');
            }
            else if (ch >= 'm' && ch <= 'o') {
                sb.append('6');
            }
            else if (ch >= 'p' && ch <= 's') {
                sb.append('7');
            }
            else if (ch >= 't' && ch <= 'v') {
                sb.append('8');
            }
            else if (ch >= 'w' && ch <= 'z') {
                sb.append('9');
            }
        }

        return sb.toString();
    }
}