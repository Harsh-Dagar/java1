package Trees;

import Queue.QueueEmptyException;
import Queue.QueueUsingLinkedList;

import java.util.Scanner;

public class TreeUse {

    public static TreeNode<Integer> takeInputRecursive(Scanner sc) {
        int n;
        System.out.println("Enter nextNode data:");
        n = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter number of child for: " + n);

        int childCount = sc.nextInt();
        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInputRecursive(sc);
            root.children.add(child);
        }
        return root;
    }

    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data:");
        int rootData = sc.nextInt();
        QueueUsingLinkedList<TreeNode<Integer>> pendingNodes = new QueueUsingLinkedList<>();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.println("Enter number of children of " + frontNode.data);
                int noOfChildren = sc.nextInt();
                for (int i = 0; i < noOfChildren; i++) {
                    if (i == 0) {
                        System.out.print("Enter " + (i + 1) + "st child of " + frontNode.data + ": ");
                    } else if (i == 1) {
                        System.out.print("Enter " + (i + 1) + "nd child of " + frontNode.data + ": ");
                    } else if (i == 2) {
                        System.out.print("Enter " + (i + 1) + "rd child of " + frontNode.data + ": ");
                    } else {
                        System.out.print("Enter " + (i + 1) + "th child of " + frontNode.data + ": ");
                    }
                    int child = sc.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<>(child);
                    frontNode.children.add(childNode);
                    pendingNodes.enqueue(childNode);
                }

            } catch (QueueEmptyException e) {
                // Shouldn't come here
                return null;
            }
        }
        return root;
    }

    public static void print(TreeNode<Integer> root) {
        String s = root.data + ": ";
        for (int i = 0; i < root.children.size(); i++) {
            s = s + root.children.get(i).data + ", ";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }

    }

    public static int numNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            count += numNodes(root.children.get(i));
        }
        return count;

    }

    // preorder Traversing
    public static void preOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            preOrder(root.children.get(i));
        }
    }

    // post order traversing
    public static void postOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            postOrder(root.children.get(i));
        }
        System.out.print(root.data + " ");

    }

    public static void main(String[] args) {
    }
}
