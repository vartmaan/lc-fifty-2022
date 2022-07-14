package com.kol.lc.july.twenty.two;


import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal object = new BinaryTreeLevelOrderTraversal();
        object.testBinaryTreeLevelOrder();

    }

    public void testBinaryTreeLevelOrder() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = levelOrder(root);

        System.out.println("RES is "+ res);



    }
   protected class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        while(!q.isEmpty()) {

            int size = q.size();
            List<Integer> levelList = new ArrayList<>();

            for(int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                levelList.add(curr.val);

                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }


            }

            res.add(levelList);
        }


        return res;

    }
}
