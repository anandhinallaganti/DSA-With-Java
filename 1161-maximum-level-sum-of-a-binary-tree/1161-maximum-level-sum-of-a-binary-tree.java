class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        int answerLevel = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                answerLevel = level;
            }

            level++;
        }

        return answerLevel;
    }
}
