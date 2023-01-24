package Final_DoubleLinked_List;

public class Node<E> implements Comparable<Node<E>>{
    E data;
    Node<E> previous;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }

    @Override
    public int compareTo(Node<E> o) {
        if (this.data == o.data)
            return 0;

        else return -1;
    }
}
