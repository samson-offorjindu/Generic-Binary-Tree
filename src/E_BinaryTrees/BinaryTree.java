package E_BinaryTrees;

import java.util.Objects;

public class BinaryTree<E> extends Node<E>{
    public Node<E> root;

    public BinaryTree() {
        super();
        this.root = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BinaryTree<?> that))
            return false;

        return Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 31 * hash + (root == null ? 0 : root.hashCode());
        hash = 31 * hash + (data == null ? 0 : data.hashCode());

        return hash;
    }

    /*Method to find a node in the binary tree by ID
    */
    public boolean find_node(E id){
        Node<E> current = root;

        while (current != null){
            if (current.data.equals(id)) //root.data can be made in place of current.data
                return true;

            else if (current.data.hashCode() > id.hashCode())
                current = current.left;

            else current = current.right;
        }
        return false;
    }

    public boolean search(E id) {
        // This is same as the find_node(id) but without the current Node assignment

        while (root != null) {
            if (root.data.equals(id))
                return true;

            else if (root.data.hashCode() > id.hashCode())
                root = root.left;

            else root = root.right;
        }
        return false;
    }

    public void insert_node(E id){
        Node<E> new_node = new Node<>(id);

        //? Try using traditional if-else condition\
        if (root == null){
            root = new_node;
            return;
        }

        Node<E> current = root;
        Node<E> parent = null;

        while (true){
            parent = current;

            if (id.equals(current.data)){
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

    public void display(Node<E> root){
        if (root != null) {
            display(root.left);
            System.out.print("-->" + root.data);
            display(root.right);
        }
    }

    public boolean delete(E id) {
        Node<E> parent = root;
        Node<E> current = root;

        boolean isLeftChild = true;

        while (!current.data.equals(id)) {
            parent = current;

            if (current.data.hashCode() > id.hashCode()) {
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
}
