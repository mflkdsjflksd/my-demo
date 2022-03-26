package leetcode.剑指;

import leetcode.TreeNode;

import java.util.Arrays;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/25 19:18
 */
public class 重建二叉树 {
    public static void main(String[] args) {
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        TreeNode treeNode = new Solution().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }


    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);

            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == root.val) {
                    root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, i, inorder.length));
                    root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, preorder.length));
                }
            }

            return root;
        }
    }
}
