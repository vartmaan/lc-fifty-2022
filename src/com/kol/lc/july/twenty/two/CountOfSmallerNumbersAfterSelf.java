package com.kol.lc.july.twenty.two;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        Node[] array = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = new Node(nums[i], i, 0);
        }
        array = mergeSort(array, 0, nums.length - 1);
        int[] answer = new int[nums.length];
        for (int i = 0; i < answer.length; i++) {
            answer[array[i].position] = array[i].count;
        }
        for (int num : answer) {
            list.add(num);
        }
        return list;
    }

    private Node[] mergeSort(Node[] array, int left, int right) {
        if (left == right) {
            return new Node[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        Node[] leftArray = mergeSort(array, left, mid);
        Node[] rightArray = mergeSort(array, mid + 1, right);
        return merge(leftArray, rightArray);
    }

    private Node[] merge(Node[] left, Node[] right) {
        int length = left.length + right.length;
        Node[] array = new Node[length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].value <= right[j].value) {
                array[k] = left[i];
                array[k].count += j;
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            array[k] = left[i];
            array[k].count += j;
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
        return array;
    }

    class Node {
        int value;
        int position;
        int count;
        public Node (int value, int position, int count) {
            this.value = value;
            this.position = position;
            this.count = count;
        }
    }
}
