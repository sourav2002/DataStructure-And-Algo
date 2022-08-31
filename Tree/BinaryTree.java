package Tree;

import stack.MyStack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// node class
class TreeNode<E> {
    public E data;
    public TreeNode<E> left;
    public TreeNode<E> right;

    public TreeNode(E data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree<E> {

    private TreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.createBinaryTree();
//        bt.root = new TreeNode<>(1);
//        bt.root.left = new TreeNode<>(2);
//        bt.root.right = new TreeNode<>(3);
//        bt.root.left.left = new TreeNode<>(4);
//        bt.root.left.right = new TreeNode<>(5);
//        bt.root.right.left = new TreeNode<>(6);


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

        System.out.println("Morris Traversal : ");
        bt.MorrisTraversal(bt.root);
        System.out.println();

        System.out.println("Level order tree traversal : ");
        bt.levelOrder(bt.root);
        System.out.println();

        System.out.println("Max value is : " + bt.findMax(bt.root));

        System.out.println("max depth is : " + bt.maxDepth(bt.root));

        System.out.println("max width is " + bt.widthOfBinaryTree(bt.root));

        System.out.println("check if tree is balanced  - " + bt.isBalanced(bt.root));

        System.out.println("Diameter of binary tree  - "+ bt.diameterOfBinaryTree(bt.root));

        System.out.println("max path sum is - "+ bt.maxPathSum(bt.root));
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

    public int findMax(TreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if (left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }
        return result;
    }

    int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        /* compute the depth of each subtree */
        int lDepth = maxDepth(node.left);
        int rDepth = maxDepth(node.right);

        /* use the larger one */
        if (lDepth > rDepth)
            return (lDepth + 1);
        else
            return (rDepth + 1);
    }

    // if left height and right height difference is greater than 1, then it is not balanced
    boolean isBalanced(TreeNode node){
        return checkBalanced(node) != -1;
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> m = new HashMap<TreeNode, Integer>();
        q.offer(root);
        m.put(root, 1);
        int curW = 0;
        int maxW = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0;
            int end = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(i == 0) start = m.get(node);
                if(i == size - 1) end = m.get(node);
                if(node.left != null){
                    m.put(node.left, m.get(node) * 2);
                    q.offer(node.left);
                }
                if(node.right != null){
                    m.put(node.right, m.get(node) * 2 + 1);
                    q.offer(node.right);
                }
            }
            curW = end - start + 1;
            maxW = Math.max(curW, maxW);
        }
        return maxW;
    }

    int checkBalanced(TreeNode node){
        if(node == null) return 0;

        int leftH = checkBalanced(node.left);
        if(leftH == -1) return -1;
        int rightH = checkBalanced(node.right);
        if (rightH == -1) return -1;

        if(Math.abs(leftH - rightH ) > 1) return -1;
        return Math.max(leftH, rightH) + 1;
    }

    // here we are passing diameter as an array, because in java we can't
    // pass var by reference in methods
    int diameterOfBinaryTree(TreeNode node){
        int []diameter = new int[1];
        height(root, diameter);
        return diameter[0];

    }
    private int height(TreeNode node, int[] diameter){
        if (node == null) return 0;
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh+rh);
        return 1 + Math.max(lh, rh);
    }


    public int maxPathSum(TreeNode root) {

        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    private int maxPathDown(TreeNode root, int[] maxValue){
        if(root == null) return 0;

        int maxsumleft = maxPathDown(root.left, maxValue);
        if(maxsumleft < 0) maxsumleft = 0;
        int maxsumright = maxPathDown(root.right, maxValue);
        if(maxsumright < 0) maxsumright = 0;

        maxValue[0] = Math.max(maxValue[0], (maxsumleft+ maxsumright+(int) root.data));
        return Math.max(maxsumleft, maxsumright) + (int)root.data;
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

    // level order -->  print from left node to right node and from top to bottom
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

    // root --> left --> right
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

    // left --> root --> right
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
                    // stack isEmpty condition is checked because we just pop out an element from stack
                    // so, it is possible that our stack get empty
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

    public void MorrisTraversal(TreeNode<E> root) {
        TreeNode cur = root;

        while(cur != null){

            if(cur.left == null){
                System.out.print(cur.data+" ");
                cur = cur.right;
            }
            else{
                TreeNode prev = cur.left;
                while(prev.right != cur && prev.right != null ){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur; // creating threat between last node and root node
                    System.out.print(cur.data+" ");
                    cur = cur.left;
                }

                // for inorder traversal, put sout cur.data line from if
                //condition to else condition
                else {
                    // time to break the thread
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }
}

