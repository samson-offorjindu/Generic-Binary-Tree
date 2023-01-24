package DataStructures;

public class BinaryTree<E>{
    TreeNode<E> root;
    public BinaryTree(E root) {
        this.root = null;
    }
    public BinaryTree(){}

    public void insert(E data) {
        root = insertRec(root, data);
    }
// hidden call
    private TreeNode<E> insertRec(TreeNode<E> root, E data) {
//         assigns node to root if no root
        if (root == null) {
            root = new TreeNode<E>(data);
            return root;
        }

//         if data is less than root assign to left
        if (((Comparable)data).compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);

//         else if data is greater or equal to root, assign to right
        } else {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode<E> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public void postorderPrint() {
        postorderPrintRec(root);
    }

    private void postorderPrintRec(TreeNode<E> node) {
        if (node == null)
            return;

        postorderPrintRec(node.left);
        postorderPrintRec(node.right);

        System.out.print(node.data + " ");
    }

    public boolean search(E data) {
        return searchRec(root, data);
    }

    private boolean searchRec(TreeNode<E> root, E data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (((Comparable)data).compareTo(root.data) < 0) {
            return searchRec(root.left, data);
        }
        return searchRec(root.right, data);
    }

    public boolean deleteTreeNode(E key) {
        TreeNode<E> parent = root, current = root;
        boolean isLeftChild = true;

        while (current.data != key) {
            parent = current;

            if (((Comparable)key).compareTo(root.data) > 0) {
                current = current.left;

            } else {
                isLeftChild = false;
                current = current.right;
            }

            if (current == null)
                return false;
        }

        if (current.left == null && current.right == null) { // if no existing children
            if (current == root)
                root = null;

            if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;

        } else if (current.right == null) { // if there's an existing left child
            if (current == root)
                root = current.left;

            else if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;

        } else if (current.left == null) { // if there's an existing right child
            if (current == root)
                root = current.right;

            else if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;

        } else { // if there are existing children
            TreeNode<E> successor = getSuccessor(current);

            if (current == root)
                root = successor;

            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;

            successor.left = current.left;
        }

        return true;
    }

    public TreeNode<E> getSuccessor(TreeNode<E> victimTreeNode) {
        TreeNode<E> successor = null;
        TreeNode<E> successorParent = null;
        TreeNode<E> current = victimTreeNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;

            current = current.left;
        }

        if (successor != victimTreeNode.right) {
            successorParent.left = successor.right;
            successor.right = victimTreeNode.right;
        }

        return successor;
    }

    public E findMin() {
        return findMinRec(root);
    }

    private E findMinRec(TreeNode<E> root) {
        if (root.left == null) {
            return root.data;
        }
        return findMinRec(root.left);
    }

    public E findMax() {
        return findMaxRec(root);
    }

    private E findMaxRec(TreeNode<E> root) {
        if (root.right == null) {
            return root.data;
        }
        return findMaxRec(root.right);
    }

    public void DFS() {
        DFSRec(root);
    }

    private void DFSRec(TreeNode<E> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            DFSRec(root.left);
            DFSRec(root.right);
        }
    }

    public boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(TreeNode<E> node, E min, E max) {
        if (node == null) {
            return true;
        }
        if ((min != null && ((Comparable)node.data).compareTo(min) <= 0)
                || (max != null && ((Comparable)node.data).compareTo(max) >= 0)) {
            return false;
        }
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }

    public void print() {
        print(root);
    }

    private void print(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        System.out.println();

        if (node.left != null)
            System.out.print("| L - " + node.left.data + " | ");
        else
            System.out.print("| null |");

        if (node.right != null)
            System.out.print(" R - " + node.right.data + " | ");
        else
            System.out.print("| null ");

        System.out.print(" D - " + node.data + " | ");

        System.out.print("\n|------------------------|");
        print(node.left);
        print(node.right);
    }

    public void display() {
        displayRec(root, 0);
    }

    private void displayRec(TreeNode<E> root, int level) {
        if (root != null) {
            displayRec(root.right, level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("|    ");
            }

            System.out.println("|---" + root.data);
            displayRec(root.left, level + 1);
        }
    }
}

