package DataStructures;

public class Node<E> {
    E data;
    Node<E> previous;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }
}
