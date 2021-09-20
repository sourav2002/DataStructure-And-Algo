package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public treeNode root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
        bst.insert(6);

        System.out.println("inorder traversal : ");
        bst.inOrder();
        System.out.println();
        System.out.println("level order traversal :");
        bst.levelOrder();
        System.out.println();

        if (bst.search(1) != null) {
            System.out.println("key found");
        } else {
            System.out.println("key not found");
        }
        bst.delete(1);
        bst.delete(7);
        bst.levelOrder();

    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public treeNode insert(treeNode root, int value) {
        if (root == null) {
            root = new treeNode(value);
            return root;
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(treeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void levelOrder() {
        levelOrder(root);
    }

    public void levelOrder(treeNode root) {
        if (root == null) {
            return;
        } else {
            Queue<treeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                treeNode temp = queue.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
    }

    public treeNode search(int key) {
        return search(root, key);
    }

    public treeNode search(treeNode root, int key) {
        if (root == null || root.data == key) { // base case
            return root;
        }
        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public void delete(int key) {
        root = deleteKey(root, key);
    }

    private treeNode deleteKey(treeNode root, int key) {
        if (root.data == key || root == null) {
            if (root.left == null) {
                root = null;
            } else if (root.left != null) {
                if (root.right != null) {
                    if (root.left.data < root.right.data) {
                        root = root.right;
                        root.right = null;
                    } else {
                        root = root.left;
                        root.left = null;
                    }
                }
            }
            return root;
        }
        if (key < root.data) {
            root.left = deleteKey(root.left, key);
        } else {
            root.right = deleteKey(root.right, key);
        }
        return root;
    }

    public class treeNode {
        public treeNode left;
        public treeNode right;
        public int data;

        public treeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
