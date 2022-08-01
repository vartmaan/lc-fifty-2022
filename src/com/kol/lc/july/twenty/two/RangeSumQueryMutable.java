package com.kol.lc.july.twenty.two;

public class RangeSumQueryMutable {

    class NumArray {
        SegmentTree s;

        NumArray(int[] nums) {
            s = new SegmentTree(nums);
            s.buildTree(0, nums, 0, nums.length - 1);
        }

        public void update(int index, int value) {
            s.updateValue(0, 0, s.size - 1, index, value);
        }

        public int sumRange(int left, int right) {
            return s.sumRange(0, 0, s.size - 1, left, right);
        }

    }

    class SegmentTree {

        int size;
        int[] tree;

        public SegmentTree(int[] nums) {
            this.size = nums.length;
            this.tree = new int[nums.length * 4];
        }

        public void buildTree(int root, int[] nums, int tl, int tr) {

            if (tl == tr) {
                tree[root] = nums[tl];
                return;
            }

            int mid = (tl + tr) / 2;

            buildTree(2 * root + 1, nums, tl, mid);
            buildTree(2 * root + 2, nums, mid + 1, tr);

            tree[root] = tree[2 * root + 1] + tree[2 * root + 2];

        }

        int sumRange2(int node, int ss, int se, int left,int right) {
            int leftSum, rightSum;
            int middle;

            if (right < ss || left > se) return 0;
            if (left <= ss && se <= right) return tree[node];

            middle = (ss + se) / 2;
            leftSum = sumRange(2 * node + 1,ss,middle,left,right);
            rightSum = sumRange( 2 * node + 2,middle+1,se,left,right);

            return leftSum + rightSum;
        }
        public int sumRange(int root, int tl, int tr, int l, int r){



            if(l == tl && r == tr){
                return tree[root];
            }

            if(l > r){
                return 0;
            }

            int mid = (tl + tr) / 2;
            int leftSubtree = sumRange(2 * root + 1, tl, mid, l, Math.min(mid, r));
            int rightSubtree = sumRange(2 * root + 2, mid + 1, tr, Math.max(mid + 1, l), r);

            return leftSubtree + rightSubtree;
        }

        public void updateValue(int root, int tl, int tr, int index, int value) {
            if (tl == tr) {
                tree[root] = value;
                return;
            }

            int mid = (tl + tr) / 2;
            if (index <= mid) {
                updateValue(2 * root + 1, tl, mid, index, value);
            } else {
                updateValue(2 * root + 2, mid + 1, tr, index, value);
            }

            tree[root] = tree[2 * root + 1] + tree[2 * root + 2];
        }
    }

}