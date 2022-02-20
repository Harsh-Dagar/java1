package Trees.TreesPracticeQuestion;

import Trees.TreeNode;
import Queue.*;

public class SumOfNodes {
    public static int sumOfAllNode(TreeNode<Integer> root) {
        int sum = 0;
        QueueUsingLinkedList<TreeNode<Integer>> pendingNode = new QueueUsingLinkedList<>();
        pendingNode.enqueue(root);
        while (!pendingNode.isEmpty()) {
            TreeNode<Integer> frontNode;
            try {
                frontNode = pendingNode.dequeue();
                sum += frontNode.data;
                for (int i = 0; i < frontNode.children.size(); i++) {
                    pendingNode.enqueue(frontNode.children.get(i));
                }
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }

        }
        return sum;
    }
}
