package Tree;

import stack.MyStack;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {
    private TreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
//        bt.createBinaryTree();
        bt.root = new TreeNode<>(1);
        bt.root.left = new TreeNode<>(2);
        bt.root.right = new TreeNode<>(3);
        bt.root.left.left = new TreeNode<>(4);
        bt.root.left.right = new TreeNode<>(5);
        bt.root.right.left = new TreeNode<>(6);


        System.out.println("preOrder Tree : ");
        bt.preOrderBinaryTree(bt.root);
        System.out.println();
        bt.preOrderIterateUsingStack(bt.root);
        System.out.println();

        System.out.println("InOrder Tree : ");
        bt.inOrderTree(bt.root);
        System.out.println();
        bt.inOrderIterateUsingStack(bt.root);
        System.out.println();

        System.out.println("Post Order Tree : ");
        bt.postOrderTree(bt.root);
        System.out.println();
        bt.postOrderIterateUsingStack(bt.root);
        System.out.println();


        System.out.println("Level order tree traversal : ");
        bt.levelOrder(bt.root);
        System.out.println();

        System.out.println("Max value is : "+ bt.findMax(bt.root));

        System.out.println("max depth is : "+bt.maxDepth(bt.root));
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        BinaryTree tree = new BinaryTree<>();

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = five;
        third.left = sixth;

    }

    public int findMax(TreeNode<Integer> root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right= findMax(root.right);
        if (left  > result ){
            result = left;
        }
        if (right > result){
            result = right;
        }
        return result;
    }
    int maxDepth(TreeNode node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    //preOrder Binary Tree Traversal -->
    // 1) root
    // 2) left
    // 3) right
    public void preOrderBinaryTree(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderBinaryTree(root.left);
        preOrderBinaryTree(root.right);
    }

    // inOrder -->
    // 1) left
    // 2) root
    // 3) right
    public void inOrderTree(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        inOrderTree(root.left);
        System.out.print(root.data + " ");
        inOrderTree(root.right);
    }

    // PostOrder Tree -->
    // 1) left
    // 2) right
    // 3) root
    public void postOrderTree(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        postOrderTree(root.left);
        postOrderTree(root.right);
        System.out.print(root.data + " ");
    }

    // level order -->  print  left node to right node and from top to bottom
    public void levelOrder(TreeNode<E> root) {
        if (root == null) {
            return;
        } else {
            Queue<TreeNode<E>> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode<E> temp = queue.remove();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    public void preOrderIterateUsingStack(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        MyStack<TreeNode<E>> stack = new MyStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<E> temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public void inOrderIterateUsingStack(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        MyStack<TreeNode<E>> stack = new MyStack<>();
        TreeNode<E> temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public void postOrderIterateUsingStack(TreeNode<E> root) {
        MyStack<TreeNode<E>> stack = new MyStack<>();
        TreeNode<E> current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode<E> temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    // node class
    static class TreeNode<E> {
        private  E data;
        private TreeNode<E> left;
        private TreeNode<E> right;

        public TreeNode(E data) {
            this.data = data;
            left = right = null;
        }
    }
}
