import java.util.Scanner;

public class PairSum {
    static Scanner sc  = new Scanner(System.in); 
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = makeTree(); 
        int sum = sc.nextInt();
        BSTIterator iterator1 = new BSTIterator(root, false);
        BSTIterator iterator2 = new BSTIterator(root, true);
        pairSum(iterator1, iterator2, sum);
    }

    private static void pairSum(BSTIterator iterator1, BSTIterator iterator2, int sum) {
        int i = iterator1.next();
        int j = iterator2.next();
        while (i < j) {
            int k = i + j;
            if(k == sum) {
                System.out.println(i + " " + j);
                i = iterator1.next();
                j = iterator2.next();
            }
            if (k < sum)
                i = iterator1.next();
            else if (k > sum)
                j = iterator2.next();
        }
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


class BSTIterator {

    Stack<BinaryTreeNode<Integer>> s = new Stack<>();
    boolean reverse = true;

    public BSTIterator(BinaryTreeNode<Integer> root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root, reverse);
    }

    public void pushAll(BinaryTreeNode<Integer> root, boolean reverse) {
        while (root != null) {
            s.push(root);
            if (reverse) {
                root = root.right;
                // s.push(root.right);
            } else {
                root = root.left;
                // s.push(root.left);
            }
        }
    }

    public int next() {
        BinaryTreeNode<Integer> ans = s.pop();
        if (reverse == true)
            pushAll(ans.left, reverse);
        else
            pushAll(ans.right, reverse);
        return ans.data;
    }
}

