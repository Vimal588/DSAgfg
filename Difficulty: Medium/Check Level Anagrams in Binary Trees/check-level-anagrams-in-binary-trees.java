import java.util.*;

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            int size1 = q1.size();
            int size2 = q2.size();

            // Corresponding levels must have same number of nodes
            if (size1 != size2) {
                return false;
            }

            HashMap<Integer, Integer> map1 = new HashMap<>();
            HashMap<Integer, Integer> map2 = new HashMap<>();

            // Process level of tree 1
            for (int i = 0; i < size1; i++) {

                Node node = q1.poll();

                map1.put(node.data, map1.getOrDefault(node.data, 0) + 1);

                if (node.left != null) {
                    q1.add(node.left);
                }

                if (node.right != null) {
                    q1.add(node.right);
                }
            }

            // Process level of tree 2
            for (int i = 0; i < size2; i++) {

                Node node = q2.poll();

                map2.put(node.data, map2.getOrDefault(node.data, 0) + 1);

                if (node.left != null) {
                    q2.add(node.left);
                }

                if (node.right != null) {
                    q2.add(node.right);
                }
            }

            // Compare frequency of values
            if (!map1.equals(map2)) {
                return false;
            }
        }

        // If one tree has remaining levels
        return q1.isEmpty() && q2.isEmpty();
    }
}