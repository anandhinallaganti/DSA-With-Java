class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: get total sum of tree
        totalSum(root);

        // Step 2: try every possible split
        subtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    // DFS to compute total sum
    private void totalSum(TreeNode node) {
        if (node == null) return;
        totalSum += node.val;
        totalSum(node.left);
        totalSum(node.right);
    }

    // DFS to compute subtree sums & max product
    private long subtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = subtreeSum(node.left);
        long right = subtreeSum(node.right);

        long sum = left + right + node.val;

        long product = sum * (totalSum - sum);
        maxProduct = Math.max(maxProduct, product);

        return sum;
    }
}
