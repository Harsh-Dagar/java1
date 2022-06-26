package BinaryTree;

class Node {
    int data, height;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

public class AVL {

    public int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            Node n = new Node(data);
            return n;
        }
        if (data > root.data) {
            root.right = insert(root.right, data);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        // left left case
        if (balance > 1 && data < root.left.data) {
            return rightRotate(root);
        }
        // right right case
        if (balance < -1 && data > root.right.data) {
            return leftRotate(root);
        }
        // left right case
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // right left case
        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;

    }

    public Node rightRotate(Node root) {
        Node newRoot = root.left;
        Node t = newRoot.right;

        newRoot.right = root;
        root.left = t;

        root.height = height(root);
        newRoot.height = height(newRoot);
        return newRoot;

    }

    public Node leftRotate(Node root) {

        Node newRoot = root.right;
        Node t = newRoot.left;

        newRoot.left = root;
        root.right = t;

        root.height = height(root);
        newRoot.height = height(newRoot);
        return newRoot;

    }

    public void printTree(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+":: ");
        if(root.left!=null){
            System.out.print(" L:"+root.left.data);
        }
        if(root.right!=null){
            System.out.print(" R:"+root.right.data);
        }
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }


    public static void main(String[]args){
        AVL a=new AVL();
        Node root=null;
        for(int i=1;i<10;i++){
            root=a.insert(root, i);
        }
        a.printTree(root);
    }

}
