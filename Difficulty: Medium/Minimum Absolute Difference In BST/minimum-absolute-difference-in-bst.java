class Solution {

    int minDiff = Integer.MAX_VALUE;
    Node prev = null;

    public int absDiff(Node root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }

        // Left
        inorder(root.left);

        // Current
        if (prev != null) {
            minDiff = Math.min(minDiff, root.data - prev.data);
        }

        prev = root;

        // Right
        inorder(root.right);
    }
}