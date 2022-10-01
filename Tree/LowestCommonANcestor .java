//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

/*
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between 
two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
*/
import java.util.Scanner;
public class LowestCommonANcestor  {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree();
        //printLevelWise(root);
        System.out.println(ancestor(root, sc.nextInt(), sc.nextInt()).data);
    }

    private static BinaryTreeNode<Integer> ancestor(BinaryTreeNode<Integer> root, int x, int y) {
        if (root == null)
            return null;
        if (root.data == x || root.data == y) {
            return root;
        }
         
        // BinaryTreeNode<Integer> lca = root;
        BinaryTreeNode<Integer> left = ancestor(root.left, x, y);
        BinaryTreeNode<Integer> right = ancestor(root.right, x, y);
        if(left != null && right != null)
            return root;
        if (left != null && right == null) {
            return left;
        } else {
            return right;
        }
        // return null;
    }

    public static BinaryTreeNode<Integer> makeTree() {
        System.out.print("Enter elements level wise - ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        Queue<BinaryTreeNode<Integer>> pendingElements = new LinkedList<>();
        pendingElements.add(root);
        while (!pendingElements.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingElements.poll();
            // System.out.print("Enter left of " + front.data + " - ");
            int left = sc.nextInt();
            if (left != -1) {
                front.left = new BinaryTreeNode<>(left);
                pendingElements.add(front.left);
            }
            // System.out.print("Enter right of " + front.data + " - ");
            int right = sc.nextInt();
            if (right != -1) {
                front.right = new BinaryTreeNode<>(right);
                pendingElements.add(front.right);
            }
        }
        return root;
    }
}

 class BinaryTreeNode<T> {
    
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode() {
    }
}