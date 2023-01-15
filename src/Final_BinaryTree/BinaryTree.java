package Final_BinaryTree;

public class BinaryTree<E> {
    Node<E> root;
    public BinaryTree(E root) {
        this.root = null;
    }

    public void insert(E data) {
        root = insertRec(root, data);
    }

    public Node<E> insertRec(Node<E> root, E data) {
        if (root == null) {
            root = new Node<E>(data);
            return root;
        }
        if (((Comparable)data).compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node<E> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public boolean search(E data) {
        return searchRec(root, data);
    }

    public boolean searchRec(Node<E> root, E data) {
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

    public boolean deleteNode(E key) {
        // code for deletion
        Node<E> parent = root;
        Node<E> current = root;
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
            Node<E> successor = getSuccessor(current);

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

    public Node<E> getSuccessor(Node<E> victimNode) {
        Node<E> successor = null;
        Node<E> successorParent = null;
        Node<E> current = victimNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;

            current = current.left;
        }

        if (successor != victimNode.right) {
            successorParent.left = successor.right;
            successor.right = victimNode.right;
        }

        return successor;
    }

    public void display() {
        displayRec(root, 0);
    }

    private void displayRec(Node<E> root, int level) {
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

