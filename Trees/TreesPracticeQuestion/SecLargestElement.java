package Trees.TreesPracticeQuestion;
import Trees.TreeNode;

class Pair {
    TreeNode<Integer> first;
    TreeNode<Integer> second;
}

public class SecLargestElement {

    private static TreeNode<Integer> max(TreeNode<Integer> a, TreeNode<Integer> b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data > b.data) {
            return a;
        }
        return b;
    }

    private static Pair findSecondLargestHelper(TreeNode<Integer> root) {
        if (root == null) {
            Pair output = new Pair();
            return output;
        }
        Pair output = new Pair();
        output.first = root;
        for (int i = 0; i < root.children.size(); i++) {
            Pair curr = findSecondLargestHelper(root.children.get(i));
            if (output.first.data > curr.first.data) {
                output.second = max(output.second, max(curr.second, curr.first));
            } else if (output.first.data < curr.first.data) {
                output.second = max(output.second, max(output.first, curr.second));
                output.first = curr.first;

            }
            else if(output.first.data==curr.first.data){
                output.second=max(output.second,curr.second);
            }
        }
        return output;
    }
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        return findSecondLargestHelper(root).second;
    }
}
