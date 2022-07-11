package com.kol.lc.july.twenty.two;



import java.util.*;

/*

Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {


    public static void main(String[] args) {
        BinaryTreeRightSideView objectUnderTest = new BinaryTreeRightSideView();
        objectUnderTest.testBinaryTreeSideViewTestCase1();

       // BinaryTreeRightSideViewTreeNode treeNode = new BinaryTreeRightSideView. new TreeNode(1);
    }


    public void testBinaryTreeSideViewTestCase1() {

        List<Integer> expectedResult = Arrays.asList(new Integer[]{1,3,4});
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(4);

        List<Integer> res = rightSideView(root);

        if(res.equals(expectedResult)) {
            System.out.println("test Case passed as result is equal to expected");
        }

         System.out.println(" result is "+ res);


    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer val;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {


        List<Integer> res = new ArrayList<Integer>();

        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if( i == size - 1) {
                    res.add(curr.val);
                }

                if(curr.left != null) {
                    q.add(curr.left);
                }



                if(curr.right != null) {
                    q.add(curr.right);
                }
            }

        }

        return res;

    }

}