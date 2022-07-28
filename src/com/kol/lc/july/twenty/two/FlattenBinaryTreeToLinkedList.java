package com.kol.lc.july.twenty.two;

import com.kol.lc.common.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        while( root != null) {

            TreeNode temp = root.left;

            if(temp != null) {
                while(temp.right != null) {
                    temp = temp.right;
                }


                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }

    }
}
