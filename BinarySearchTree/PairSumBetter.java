package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

import BinaryTree.BinaryTreeNode;

public class PairSumBetter {
    private static ArrayList<Integer> BSTToArray(BinaryTreeNode<Integer> root) {
        if (root == null) {
            ArrayList<Integer> output = new ArrayList<>(0);
            return output;
        }
        ArrayList<Integer> smallAnsLeft = BSTToArray(root.left);
        ArrayList<Integer> smallAnsRight = BSTToArray(root.right);
        ArrayList<Integer> output = new ArrayList<>();
        output.addAll(smallAnsLeft);
        output.add(root.data);
        output.addAll(smallAnsRight);
        return output;
    }

    public static void pairSum(BinaryTreeNode<Integer> root, int sum) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> arr = BSTToArray(root);
        Collections.sort(arr);
        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            if ((arr.get(i) + arr.get(j)) == sum) {
                System.out.println(arr.get(i) + " " + arr.get(j));
                i++;
                j--;
            } else if ((arr.get(i) + arr.get(j)) < sum) {
                i++;

            } else if ((arr.get(i) + arr.get(j)) > sum) {
                j--;
            }
        }

    }

}
