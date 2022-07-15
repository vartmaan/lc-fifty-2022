package com.kol.lc.july.twenty.two;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreOrderandPostOrderTraversal {

    class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    int currRootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer,Integer> inOrderMap = new HashMap<>();

        for(int i =0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i],i);
        }

        int left = 0;
        int right = preorder.length - 1;
        int preIndex = 0;
        return  helperTreeBuilder(preIndex,preorder,inOrderMap,left,right);

    }


    private TreeNode helperTreeBuilder(int preIndex, int[] preorder, Map<Integer, Integer> inOrderMap, int left, int right) {

        if(left > right) {
            return null;
        }


        Integer rootVal = preorder[currRootIndex++];
        TreeNode root = new TreeNode(rootVal);
        // return root;

        root.left = helperTreeBuilder(preIndex,preorder,inOrderMap,left,inOrderMap.get(rootVal) - 1);
        root.right = helperTreeBuilder(preIndex,preorder,inOrderMap,inOrderMap.get(rootVal) + 1,right);

        return root;




    }
}

