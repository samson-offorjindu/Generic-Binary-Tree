package DataStructures;

public class TreeNode<E> implements Comparable<Node<E>> {
    E data;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E data) {
        this.data = data;

        //Rest as null
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node<E> o) {
        if (this.data == o.data)
            return 0;

        else return -1;
    }
}
