package BinaryTreesJava;

public class BinaryTree {
    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    /*Method to find a node in the binary tree by ID
    */
    public boolean find_node(int id){
        Node current = root;

        while (current != null){
            if (current.data == id) //root.data can be made in place of current.data
                return true;
            else if (current.data > id)
                current = current.left;

            else current = current.right;
        }
        return false;
    }

    public boolean search(int id) {
        // This is same as the find_node(id) but without the current Node assignment

        while (root != null) {
            if (root.data == id)
                return true;
            else if (root.data > id)
                root = root.left;

            else root = root.right;
        }
        return false;
    }

    public void insert_node(int id){
        Node new_node = new Node(id);

        //? Try using traditional if-else condition\
        if (root == null){
            root = new_node;
            return;
        }

        Node current = root;
        Node parent = null;

        while (true){
            parent = current;

            if (id < current.data){
                current = current.left;

                if (current == null){
                    parent.left = new_node;
                    return;
                }
            } else {
                current = current.right;

                if (current == null){
                    parent.right = new_node;
                    return;
                }
            }
        }
    }

    public void display(Node root){
        if (root != null) {
            display(root.left);
            System.out.print("-->" + root.data);
            display(root.right);
        }
    }

    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = true;

        while (current.data != id) {
            parent = current;

            if (current.data > id) {
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
            Node successor = getSuccessor(current);

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

    public Node getSuccessor(Node victimNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = victimNode.right;

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
}
