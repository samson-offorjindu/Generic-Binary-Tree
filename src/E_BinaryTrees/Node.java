package E_BinaryTrees;

import java.util.Collection;
import java.util.Iterator;

public class Node<E> implements Comparable<E> {
    E data;
    Node<E> right;
    Node<E> left;

    public Node(E data){
        this.data = data;
        right = null;
        left = null;
    }
    public Node(){}

    @Override
    public int compareTo(E o) {
        return 0;
    }
}
